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

public class MuteCommands implements CommandExecutor {

    public final MDrop plugin;

    public MuteCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    public static String mutemessage ="";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length>=1){
            OfflinePlayer targetplayer = Bukkit.getOfflinePlayer(args[0]);
            if (sender instanceof Player) {
                User user = plugin.luckPerms.getUserManager().getUser(sender.getName());
                User target = plugin.luckPerms.getUserManager().getUser(args[0]);
                if (plugin.luckPerms.getGroupManager().getGroup(target.getPrimaryGroup()).getWeight().getAsInt() < plugin.luckPerms.getGroupManager().getGroup(user.getPrimaryGroup()).getWeight().getAsInt()) {
                    if (args.length >= 2) {
                        if (args.length >= 3) {
                            Calendar c = Calendar.getInstance();
                            c.add(Calendar.MINUTE, Integer.parseInt(args[2]));
                            plugin.sql.addmutePlayer((Player) sender, targetplayer, args[1], c.getTime());
                            if (targetplayer.isOnline()) {
                                ((Player) targetplayer).sendMessage(mutemessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", target.getUsername()).replaceFirst("%message%", args[1]).replaceFirst("%group%", user.getPrimaryGroup()));
                            }
                        }else{
                            sender.sendMessage(ChatColor.AQUA+"Podaj czas w minutach");
                        }
                    }else{
                        sender.sendMessage(ChatColor.AQUA+"Podaj powod");
                    }
                }
            }else{
                if (args.length >= 2) {
                    if (args.length >= 3) {
                        Calendar c = Calendar.getInstance();
                        c.add(Calendar.MINUTE, Integer.parseInt(args[2]));
                        plugin.sql.addmutePlayer((ConsoleCommandSender) sender, targetplayer, args[1], c.getTime());
                        if (targetplayer.isOnline()) {
                            ((Player) targetplayer).sendMessage(mutemessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", targetplayer.getName()).replaceFirst("%message%", args[1]).replaceFirst("%group%", ""));
                        }
                    }else{
                        sender.sendMessage(ChatColor.AQUA+"Podaj czas w minutach");
                    }
                }else{
                    sender.sendMessage(ChatColor.AQUA+"Podaj powod");
                }
            }
        }else{
            sender.sendMessage(ChatColor.AQUA+"Podaj nick gracz");
        }
        return false;
    }
}
