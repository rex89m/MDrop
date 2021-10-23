package pl.rex89m.mdrop.AntyLog;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Player.PlayerSettings;

public class AntyLogListener implements Listener {

    public final MDrop plugin;

    public AntyLogListener(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        PlayerSettings playerSettings = PlayerSettings.get(e.getPlayer().getUniqueId());
        if (playerSettings.getAntylog()>0){
            e.getPlayer().setHealth(0);
        }
    }

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Player){
            if (e.getEntity() instanceof Player){
                PlayerSettings.get(e.getDamager().getUniqueId()).setAntylog(15);
                PlayerSettings.get(e.getEntity().getUniqueId()).setAntylog(15);
            }
        }
    }
}
