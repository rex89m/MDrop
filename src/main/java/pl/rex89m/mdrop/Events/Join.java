package pl.rex89m.mdrop.Events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.rex89m.mdrop.Case.Case;
import pl.rex89m.mdrop.Drop.Drop;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Player.PlayerSettings;

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
        if (plugin.sql.loadPlayerSettings(e.getPlayer())==null) {
            String var ="";
            for (Material i : Drop.getDrop().keySet()){
                if (var.equals("")){
                    var= i.name()+"@true";
                }else {
                    var = var+"#"+i.name()+"@true";
                }
            }
            plugin.sql.addSettingsPlayer(e.getPlayer(), var);
        }else{
            for (String i : PlayerSettings.get(e.getPlayer().getUniqueId()).getDrop().split("#")){
                String[] var2 = i.split("@");

            }
        }
    }
}
