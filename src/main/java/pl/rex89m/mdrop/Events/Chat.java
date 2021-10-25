package pl.rex89m.mdrop.Events;

import net.dzikoysk.funnyguilds.basic.user.User;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import pl.rex89m.mdrop.MDrop;

import java.util.Objects;

public class Chat implements Listener {

    public final MDrop plugin;

    public Chat(MDrop plugin) {
        this.plugin = plugin;
    }

    String format = "{PKT} {ranga} {nick} {message}";

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent e) {
        User user = User.get(e.getPlayer().getUniqueId());
        if (e.getPlayer().hasPermission("mdrop.chat.color")) {
            e.setFormat(ChatColor.translateAlternateColorCodes('&', format.replaceFirst("\\{ranga}", Objects.requireNonNull(plugin.luckPerms.getGroupManager().getGroup(plugin.luckPerms.getUserManager().getUser(e.getPlayer().getUniqueId()).getPrimaryGroup()).getCachedData().getMetaData().getPrefix())).replaceFirst("\\{nick}", "&r"+e.getPlayer().getName()).replaceFirst("\\{message}", "&r"+e.getMessage()).replaceFirst("\\{PKT}", String.valueOf(user.getRank().getPoints()))));
        }else{
            e.setFormat(ChatColor.translateAlternateColorCodes('&', format.replaceFirst("\\{ranga}", Objects.requireNonNull(plugin.luckPerms.getGroupManager().getGroup(plugin.luckPerms.getUserManager().getUser(e.getPlayer().getUniqueId()).getPrimaryGroup()).getCachedData().getMetaData().getPrefix()))).replaceFirst("\\{nick}", e.getPlayer().getName()).replaceFirst("\\{message}", e.getMessage()).replaceFirst("\\{PKT}", String.valueOf(user.getRank().getPoints())));
        }
    }
}
