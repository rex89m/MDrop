package pl.rex89m.mdrop.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.rex89m.mdrop.MDrop;

public class VoidCommands implements CommandExecutor {

    public final MDrop plugin;

    public VoidCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        plugin.voidGui.open((Player) commandSender);
        return false;
    }
}
