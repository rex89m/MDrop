package pl.rex89m.mdrop.Commands;

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
                    SortedMap<> values = new TreeSet<>(plugin.sql.getAllTopPlayerCase(args[0]).values());
                    Collections.synchronizedSortedMap()
                    for (String i2 : values){
                        sender.sendMessage(i2);
                    }
                    break;
                }
            }
        }
        return false;
    }
}
