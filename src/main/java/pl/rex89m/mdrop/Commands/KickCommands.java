package pl.rex89m.mdrop.Commands;

import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.rex89m.mdrop.MDrop;

public class KickCommands implements CommandExecutor {

    public final MDrop plugin;

    public KickCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    public static String kickmessage = "";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("mdrop.kick")){
            if (args.length>=1){
                User user = plugin.luckPerms.getUserManager().getUser(sender.getName());
                if (Bukkit.getPlayer(args[0])!=null) {
                    Player targetplayer = Bukkit.getPlayer(args[0]);
                    User target = plugin.luckPerms.getUserManager().getUser(args[0]);
                    if (plugin.luckPerms.getGroupManager().getGroup(target.getPrimaryGroup()).getWeight().isPresent()) {
                        if (plugin.luckPerms.getGroupManager().getGroup(target.getPrimaryGroup()).getWeight().getAsInt() < plugin.luckPerms.getGroupManager().getGroup(user.getPrimaryGroup()).getWeight().getAsInt()) {
                            if (args.length >= 2) {
                                targetplayer.kickPlayer(ChatColor.translateAlternateColorCodes('&', args[1]));
                                plugin.sql.addhistoryPlayer((Player) sender, targetplayer, args[1], "-", "KICK");
                                if (args.length == 3) {
                                    if (args[2].equalsIgnoreCase("-s")) {
                                        for (Player i : Bukkit.getOnlinePlayers()) {
                                            if (!plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("default") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("vip") && !plugin.luckPerms.getUserManager().getUser(i.getName()).getPrimaryGroup().equals("svip")) {
                                                i.sendMessage(kickmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", target.getUsername()).replaceFirst("%message%", args[1]).replaceFirst("%group%", user.getPrimaryGroup()));
                                            }
                                        }
                                    }
                                    return false;
                                }
                                Bukkit.broadcastMessage(kickmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", target.getUsername()).replaceFirst("%message%", args[1]).replaceFirst("%group%", user.getPrimaryGroup()));
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
}