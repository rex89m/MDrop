package pl.rex89m.mdrop.Mute;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Player.PlayerSettings;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventChatMute implements Listener {

    public final MDrop plugin;

    public EventChatMute(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onChat(AsyncPlayerChatEvent e){
        PlayerSettings settings = PlayerSettings.get(e.getPlayer().getUniqueId());
        if (settings.hasMute()) {
            if (new Date().before(settings.getMuteInfo().getDateend())) {
                e.setCancelled(true);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                e.getPlayer().sendMessage(ChatColor.AQUA+"Poczekaj do: "+simpleDateFormat.format(settings.getMuteInfo().getDateend()));
            }else{
                plugin.sql.removePlayerMute(e.getPlayer().getName());
            }
        }
    }
}
