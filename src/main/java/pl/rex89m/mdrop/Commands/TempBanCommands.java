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

import java.util.Calendar;
import java.util.Locale;

public class TempBanCommands implements CommandExecutor {

    public final MDrop plugin;

    public TempBanCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("mdrop.ban")){
            if (args.length>=1) {
                User user = plugin.luckPerms.getUserManager().getUser(sender.getName());
                OfflinePlayer targetplayer = Bukkit.getOfflinePlayer(args[0]);
                if (sender instanceof Player) {
                    User target = plugin.luckPerms.getUserManager().getUser(args[0]);
                    if (plugin.luckPerms.getGroupManager().getGroup(target.getPrimaryGroup()).getWeight().getAsInt() < plugin.luckPerms.getGroupManager().getGroup(user.getPrimaryGroup()).getWeight().getAsInt()) {
                        if (args.length >= 2) {
                            if (args.length >= 3) {
                                args[2] = args[2].toUpperCase(Locale.ROOT);
                                Calendar c = Calendar.getInstance();
                                if (args[2].contains("D")) {
                                    c.add(Calendar.DAY_OF_YEAR, Integer.parseInt(args[2].replaceAll("D", "")));
                                } else if (args[2].contains("H"))
                                    c.add(Calendar.HOUR, Integer.parseInt(args[2].replaceAll("H", "")));
                                else if (args[2].contains("M"))
                                    c.add(Calendar.MINUTE, Integer.parseInt(args[2].replaceAll("M", "")));
                                else if (args[2].contains("S"))
                                    c.add(Calendar.SECOND, Integer.parseInt(args[2].replaceAll("S", "")));
                                else if (args[2].contains("Y"))
                                    c.add(Calendar.YEAR, Integer.parseInt(args[2].replaceAll("Y", "")));
                                plugin.sql.addbanPlayer((Player) sender, targetplayer, args[1], c.getTime());
                                if (targetplayer.isOnline()) {
                                    Bukkit.getPlayer(args[0]).kickPlayer(ChatColor.translateAlternateColorCodes('&', args[1]));
                                }
                                if (args.length == 4) {
                                    if (args[2].equalsIgnoreCase("-s")) {
                                        for (Player i : Bukkit.getOnlinePlayers()) {
                                            if (!plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("default") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("vip") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("svip")) {
                                                i.sendMessage(plugin.banCommands.banmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", target.getUsername()).replaceFirst("%message%", args[1]).replaceFirst("%group%", user.getPrimaryGroup()));
                                            }
                                        }
                                    }
                                    return false;
                                }
                                Bukkit.broadcastMessage(plugin.banCommands.banmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", target.getUsername()).replaceFirst("%message%", args[1]).replaceFirst("%group%", user.getPrimaryGroup()));

                            }else{
                                sender.sendMessage(ChatColor.AQUA+"/tempban nick powod czas(1s/1m/1d/1y)");
                            }
                        }else{
                            sender.sendMessage(ChatColor.AQUA+"/tempban nick powod czas(1s/1m/1d/1y)");
                        }
                    }
                } else {
                    if (args.length >= 2) {
                        if (args.length >= 3) {
                            ConsoleCommandSender commandSender = (ConsoleCommandSender) sender;
                            args[2] = args[2].toUpperCase(Locale.ROOT);
                            Calendar c = Calendar.getInstance();
                            if (args[2].contains("D")) {
                                c.add(Calendar.DAY_OF_YEAR, Integer.parseInt(args[2].replaceAll("D", "")));
                            } else if (args[2].contains("H"))
                                c.add(Calendar.HOUR, Integer.parseInt(args[2].replaceAll("H", "")));
                            else if (args[2].contains("M"))
                                c.add(Calendar.MINUTE, Integer.parseInt(args[2].replaceAll("M", "")));
                            else if (args[2].contains("S"))
                                c.add(Calendar.SECOND, Integer.parseInt(args[2].replaceAll("S", "")));
                            else if (args[2].contains("Y"))
                                c.add(Calendar.YEAR, Integer.parseInt(args[2].replaceAll("Y", "")));
                            plugin.sql.addbanPlayer(commandSender, targetplayer, args[1], c.getTime());
                            if (targetplayer.isOnline()) {
                                Bukkit.getPlayer(args[0]).kickPlayer(ChatColor.translateAlternateColorCodes('&', args[1]));
                            }
                            if (args.length == 4) {
                                if (args[2].equalsIgnoreCase("-s")) {
                                    for (Player i : Bukkit.getOnlinePlayers()) {
                                        if (!plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("default") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("vip") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("svip")) {
                                            i.sendMessage(plugin.banCommands.banmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", targetplayer.getName()).replaceFirst("%message%", args[1]).replaceFirst("%group%", ""));
                                        }
                                    }
                                }
                                return false;
                            }
                            Bukkit.broadcastMessage(plugin.banCommands.banmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", targetplayer.getName()).replaceFirst("%message%", args[1]).replaceFirst("%group%", ""));

                        }else{
                            sender.sendMessage(ChatColor.AQUA+"/tempban nick powod czas(1s/1m/1d/1y)");
                        }
                    }else{
                        sender.sendMessage(ChatColor.AQUA+"/tempban nick powod czas(1s/1m/1d/1y)");
                    }
                }
            }else{
                sender.sendMessage(ChatColor.AQUA+"/tempban nick powod czas(1s/1m/1d/1y)");
            }
        }
        return false;
    }
}
