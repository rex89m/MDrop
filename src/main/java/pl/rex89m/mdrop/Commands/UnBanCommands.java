package pl.rex89m.mdrop.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.rex89m.mdrop.MDrop;

public class UnBanCommands implements CommandExecutor {

    public final MDrop plugin;

    public UnBanCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("mdrop.unban")){
            if (args.length==1){
                if (plugin.sql.hasPlayerban(args[0])) {
                    plugin.sql.removePlayerban(args[0]);
                    sender.sendMessage("Odbanowano");
                }else sender.sendMessage("Ten gracz nie ma bana");
            }else{
                sender.sendMessage(ChatColor.AQUA+"Podaj nick gracz");
            }
        }
        return false;
    }
}
