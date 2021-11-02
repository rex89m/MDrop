package pl.rex89m.mdrop.Commands;

import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.rex89m.mdrop.MDrop;

public class WarnCommands implements CommandExecutor {

    public final MDrop plugin;

    public WarnCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    public static String warnmessage = "";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length>=1){
            if (sender instanceof Player){
                User user = plugin.luckPerms.getUserManager().getUser(sender.getName());
                if (Bukkit.getPlayer(args[0])!=null) {
                    Player targetplayer = Bukkit.getPlayer(args[0]);
                    User target = plugin.luckPerms.getUserManager().getUser(args[0]);
                    if (plugin.luckPerms.getGroupManager().getGroup(target.getPrimaryGroup()).getWeight().getAsInt() < plugin.luckPerms.getGroupManager().getGroup(user.getPrimaryGroup()).getWeight().getAsInt()) {
                        if (args.length == 2) {
                            plugin.sql.addhistoryPlayer((Player) sender, targetplayer, args[1], "-", "WARN");
                            targetplayer.sendMessage(warnmessage.replaceFirst("%player%", sender.getName()).replaceFirst("%target%", target.getUsername()).replaceFirst("%message%", args[1]).replaceFirst("%group%", user.getPrimaryGroup()));
                        }else{
                            sender.sendMessage(ChatColor.AQUA+"Podaj powod");
                        }
                    }
                }
            }
        }else{
            sender.sendMessage(ChatColor.AQUA+"Podaj nick gracz");
        }
        return false;
    }
}
