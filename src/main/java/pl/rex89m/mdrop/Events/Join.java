package pl.rex89m.mdrop.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.rex89m.mdrop.Case.Case;
import pl.rex89m.mdrop.MDrop;

public class Join implements Listener {

    public final MDrop plugin;

    public Join(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        for (String i: Case.getAllID()) {
            plugin.sql.inserPlayerTopCase(e.getPlayer().getName(), i);
        }
    }
}
