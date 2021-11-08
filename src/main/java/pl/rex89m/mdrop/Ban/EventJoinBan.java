package pl.rex89m.mdrop.Ban;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.rex89m.mdrop.Events.Chat;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Player.PlayerSettings;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventJoinBan implements Listener {

    public final MDrop plugin;

    public EventJoinBan(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        PlayerSettings settings = PlayerSettings.get(e.getPlayer().getUniqueId());
        if (settings.hasBan()) {
            if (settings.getBanInfo().hasperm()) {
                e.getPlayer().kickPlayer(ChatColor.translateAlternateColorCodes('&', settings.getBanInfo().getReason()));
                e.setJoinMessage("");
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (new Date().before(settings.getBanInfo().getDateend())) {
                    e.getPlayer().kickPlayer(ChatColor.translateAlternateColorCodes('&', settings.getBanInfo().getReason())+ ChatColor.RED +"\n"+simpleDateFormat.format(settings.getBanInfo().getDateend()));
                    e.setJoinMessage("");
                } else {
                    plugin.sql.removePlayerban(e.getPlayer().getName());
                }
            }
        }
    }
}
