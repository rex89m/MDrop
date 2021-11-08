package pl.rex89m.mdrop.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.rex89m.mdrop.Case.Case;

public class CaseCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("case.*")) {
            if (args.length == 0) {
                sender.sendMessage("Komendy:");
                sender.sendMessage("/Case give chest/key idCase Player");
                sender.sendMessage(ChatColor.GREEN+"Lista:");
                for (String i: Case.getAllID()){
                    sender.sendMessage(ChatColor.AQUA+i);
                }
            } else if (args[0].equalsIgnoreCase("give")) {
                if (args.length > 1) {
                    if (args[1].equalsIgnoreCase("chest")) {
                        if (args.length > 2) {
                            for (String i : Case.getAllID()) {
                                if (i.equalsIgnoreCase(args[2])) {
                                    if (args.length==4){
                                        if (args[3].equalsIgnoreCase("all")){
                                            for (Player i2 : Bukkit.getOnlinePlayers()){
                                                i2.getInventory().addItem(Case.get(args[2]).getChest());
                                            }
                                        }else {
                                            if (Bukkit.getPlayerExact(args[3]) != null) {
                                                Bukkit.getPlayerExact(args[3]).getInventory().addItem(Case.get(args[2]).getChest());
                                            }
                                        }
                                        break;
                                    }else {
                                        p.getInventory().addItem(Case.get(args[2]).getChest());
                                        break;
                                    }
                                }
                            }
                        } else {
                            p.sendMessage("podaj id");
                        }
                    } else {
                        if (args[1].equalsIgnoreCase("key")) {
                            for (String i : Case.getAllID()) {
                                if (i.equalsIgnoreCase(args[2])) {
                                    if (args.length==4){
                                        if (args[3].equalsIgnoreCase("all")){
                                            for (Player i2 : Bukkit.getOnlinePlayers()){
                                                i2.getInventory().addItem(Case.get(args[2]).getKey());
                                            }
                                        }else {
                                            if (Bukkit.getPlayerExact(args[3]) != null) {
                                                Bukkit.getPlayerExact(args[3]).getInventory().addItem(Case.get(args[2]).getKey());
                                            }
                                        }
                                        break;
                                    }else {
                                        p.getInventory().addItem(Case.get(args[2]).getKey());
                                        break;
                                    }
                                }
                            }
                        } else {
                            p.sendMessage("Podaj chest albo key");
                        }
                    }
                } else {
                    p.sendMessage("Podaj chest albo key");
                }
            }
        }
        return false;
    }
}
