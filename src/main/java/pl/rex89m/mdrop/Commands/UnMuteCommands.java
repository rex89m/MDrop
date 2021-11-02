package pl.rex89m.mdrop.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.rex89m.mdrop.MDrop;

public class UnMuteCommands implements CommandExecutor {

    public final MDrop plugin;

    public UnMuteCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("mdrop.unmute")){
            if (args.length==1){
                if (plugin.sql.hasPlayermute(args[0])) {
                    plugin.sql.removePlayerMute(args[0]);
                    sender.sendMessage("usunieto wyciszenie");
                }else sender.sendMessage("Ten gracz nie ma muta");
            }else{
                sender.sendMessage(ChatColor.AQUA+"Podaj nick gracz");
            }
        }
        return false;
    }
}
