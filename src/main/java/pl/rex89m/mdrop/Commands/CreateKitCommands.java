package pl.rex89m.mdrop.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.rex89m.mdrop.MDrop;

public class CreateKitCommands implements CommandExecutor {

    public final MDrop plugin;

    public CreateKitCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("mdrop.createkit")){
            if (args.length>=1){
                if (args.length >= 2) {
                    if (args.length == 3) {
                        plugin.yml.createkit(args[0], Integer.parseInt(args[1]), args[3]);
                    }
                    else{
                        plugin.yml.createkit(args[0], Integer.parseInt(args[1]), "mdrop."+args[0]);
                    }
                }else{
                    sender.sendMessage(ChatColor.AQUA+"/createkit nazwa czas odnowienia w sekundach");
                }
            }else{
                sender.sendMessage(ChatColor.AQUA+"/createkit nazwa czas odnowienia w sekundach");
            }
        }
        return false;
    }
}
