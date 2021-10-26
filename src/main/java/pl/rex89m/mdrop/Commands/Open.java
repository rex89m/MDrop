package pl.rex89m.mdrop.Commands;

import com.earth2me.essentials.Kit;
import lombok.SneakyThrows;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.rex89m.mdrop.MDrop;

public class Open implements CommandExecutor {

    public final MDrop plugin;

    public Open(MDrop plugin) {
        this.plugin = plugin;
    }

    @SneakyThrows
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Kit kit = new Kit("tools", MDrop.ess);
        return false;
    }
}
