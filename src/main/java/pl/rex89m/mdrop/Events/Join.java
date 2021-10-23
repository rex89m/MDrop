package pl.rex89m.mdrop.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.rex89m.mdrop.Case.Case;
import pl.rex89m.mdrop.Drop.Drop;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Player.PlayerSettings;
import pl.rex89m.mdrop.BossBar.Bossy;

import java.util.HashMap;

public class Join implements Listener {

    public final MDrop plugin;

    public Join(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Bossy bossy = new Bossy(plugin);
        bossy.set(e.getPlayer(), "Your message", 0.5F);
        bossy.setText(e.getPlayer(), "Change the message");
        bossy.setPercent(e.getPlayer(), 1F); // change health/percent (between 0 and 1)
        bossy.show(e.getPlayer());
        load(e.getPlayer());
    }

    public void load(Player e){
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
            HashMap<String, String> var = new HashMap<>();
            for (String i: PlayerSettings.get(e.getPlayer().getUniqueId()).getDrop().split("#")){
                String[] var2 = i.split("@");
                var.put(var2[0], var2[1]);
            }
            String varstring ="";
            for (Material i : Drop.getDrop().keySet()) {
                if (var.containsKey(i.name())){
                    if (varstring.equals("")){
                        varstring = i.name()+"@"+var.get(i.name());
                    }else{
                        varstring = varstring+"#"+i.name()+"@"+var.get(i.name());
                    }
                }else{
                    if (varstring.equals("")){
                        varstring = i.name()+"@true";
                    }else{
                        varstring = varstring+"#"+i.name()+"@true";
                    }
                }
            }
            plugin.sql.updateSettingsDrop(e.getPlayer(), varstring);
        }
    }
}
