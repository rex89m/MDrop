package pl.rex89m.mdrop.Commands;

import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import pl.rex89m.mdrop.MDrop;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BanCommands implements CommandExecutor {

    public final MDrop plugin;

    public BanCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    public static String banmessage = "";


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("mdrop.ban")){
            if (args.length>=1){
                User user = plugin.luckPerms.getUserManager().getUser(sender.getName());
                OfflinePlayer targetplayer = Bukkit.getPlayer(args[0]);
                if (sender instanceof Player){
                    User target = plugin.luckPerms.getUserManager().getUser(args[0]);
                    if (plugin.luckPerms.getGroupManager().getGroup(target.getPrimaryGroup()).getWeight().getAsInt() < plugin.luckPerms.getGroupManager().getGroup(user.getPrimaryGroup()).getWeight().getAsInt()) {
                        if (args.length >= 2) {
                            if (args.length >= 3) {
                                if (args[2].equals("-1")){
                                    plugin.sql.addbanPlayer((Player) sender, targetplayer, args[1], "-1");
                                    Bukkit.getPlayer(args[0]).kickPlayer(ChatColor.translateAlternateColorCodes('&', args[1]));
                                    if (args.length == 4) {
                                        if (args[2].equalsIgnoreCase("-s")) {
                                            for (Player i : Bukkit.getOnlinePlayers()) {
                                                if (!plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("default") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("vip") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("svip")) {
                                                    i.sendMessage(banmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", target.getUsername()).replaceFirst("%message%", args[1]).replaceFirst("%group%", user.getPrimaryGroup()));
                                                }
                                            }
                                        }
                                        return false;
                                    }
                                    Bukkit.broadcastMessage(banmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", target.getUsername()).replaceFirst("%message%", args[1]).replaceFirst("%group%", user.getPrimaryGroup()));
                                }else {
                                    Calendar c = Calendar.getInstance();
                                    c.add(Calendar.HOUR, Integer.parseInt(args[2]));
                                    plugin.sql.addbanPlayer((Player) sender, targetplayer, args[1], c.getTime());
                                    Bukkit.getPlayer(args[0]).kickPlayer(ChatColor.translateAlternateColorCodes('&', args[1]));
                                    if (args.length == 4) {
                                        if (args[2].equalsIgnoreCase("-s")) {
                                            for (Player i : Bukkit.getOnlinePlayers()) {
                                                if (!plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("default") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("vip") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("svip")) {
                                                    i.sendMessage(banmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", target.getUsername()).replaceFirst("%message%", args[1]).replaceFirst("%group%", user.getPrimaryGroup()));
                                                }
                                            }
                                        }
                                        return false;
                                    }
                                    Bukkit.broadcastMessage(banmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", target.getUsername()).replaceFirst("%message%", args[1]).replaceFirst("%group%", user.getPrimaryGroup()));

                                }
                                }else{
                                sender.sendMessage(ChatColor.AQUA+"Podaj czas w godzinach lub -1");
                            }
                        }else{
                            sender.sendMessage(ChatColor.AQUA+"Podaj powod");
                        }
                    }
                } else {
                    if (args.length >= 2) {
                        if (args.length >= 3) {
                            ConsoleCommandSender commandSender = (ConsoleCommandSender) sender;
                            if (args[2].equals("-1")){
                                plugin.sql.addbanPlayer(commandSender, targetplayer, args[1], "-1");
                                Bukkit.getPlayer(args[0]).kickPlayer(ChatColor.translateAlternateColorCodes('&', args[1]));
                                if (args.length == 4) {
                                    if (args[2].equalsIgnoreCase("-s")) {
                                        for (Player i : Bukkit.getOnlinePlayers()) {
                                            if (!plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("default") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("vip") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("svip")) {
                                                i.sendMessage(banmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", targetplayer.getName()).replaceFirst("%message%", args[1]).replaceFirst("%group%", ""));
                                            }
                                        }
                                    }
                                    return false;
                                }
                                Bukkit.broadcastMessage(banmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", targetplayer.getName()).replaceFirst("%message%", args[1]).replaceFirst("%group%", ""));
                            }else {
                                Calendar c = Calendar.getInstance();
                                c.add(Calendar.HOUR, Integer.parseInt(args[2]));
                                plugin.sql.addbanPlayer(commandSender, targetplayer, args[1], c.getTime());
                                Bukkit.getPlayer(args[0]).kickPlayer(ChatColor.translateAlternateColorCodes('&', args[1]));
                                if (args.length == 4) {
                                    if (args[2].equalsIgnoreCase("-s")) {
                                        for (Player i : Bukkit.getOnlinePlayers()) {
                                            if (!plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("default") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("vip") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("svip")) {
                                                i.sendMessage(banmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", targetplayer.getName()).replaceFirst("%message%", args[1]).replaceFirst("%group%", ""));
                                            }
                                        }
                                    }
                                    return false;
                                }
                                Bukkit.broadcastMessage(banmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", targetplayer.getName()).replaceFirst("%message%", args[1]).replaceFirst("%group%", ""));

                            }
                            }else{
                            sender.sendMessage(ChatColor.AQUA+"Podaj czas w godzinach");
                        }
                    }else{
                        sender.sendMessage(ChatColor.AQUA+"Podaj powod");
                    }
                }
            }else{
                sender.sendMessage(ChatColor.AQUA+"Podaj nick gracza");
            }
        }
        return false;
    }
}
