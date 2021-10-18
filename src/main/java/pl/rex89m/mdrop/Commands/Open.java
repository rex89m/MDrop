package pl.rex89m.mdrop.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.rex89m.mdrop.MDrop;

public class Open implements CommandExecutor {

    public final MDrop plugin;

    public Open(MDrop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.caseOpen.open((Player) sender, "test");
        return false;
    }
}
