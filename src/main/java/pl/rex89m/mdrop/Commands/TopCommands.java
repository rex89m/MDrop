package pl.rex89m.mdrop.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.rex89m.mdrop.Case.Case;
import pl.rex89m.mdrop.MDrop;

import java.util.*;

public class TopCommands implements CommandExecutor {

    public final MDrop plugin;

    public TopCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length==1) {
            for (String i : Case.getAllID()){
                if (args[0].equalsIgnoreCase(i)){
                    Map<String, Integer> map = plugin.sql.getAllTopPlayerCase(args[0]);

                    List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
                    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                        @Override
                        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                            return o2.getValue().compareTo(o1.getValue());
                        }
                    });
                    int liczba;
                    for (Map.Entry<String, Integer> i2: list){
                        liczba=+1;
                        if (liczba>10){
                            break;
                        }
                        sender.sendMessage(ChatColor.GRAY+String.valueOf(liczba)+ChatColor.DARK_GRAY+". "+ChatColor.DARK_AQUA+i2.getKey() + " "+ChatColor.AQUA+i2.getValue());
                    }
                    break;
                }
            }
        }else{
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Lista skrzyn:"));
            for (String i: Case.getAllID()){
                sender.sendMessage(i);
            }
        }
        return false;
    }
}
