package pl.rex89m.mdrop.Commands;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.IEssentials;
import com.earth2me.essentials.Kit;
import lombok.SneakyThrows;
import net.ess3.api.IUser;
import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
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
