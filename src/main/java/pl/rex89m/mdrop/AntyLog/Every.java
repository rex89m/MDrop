package pl.rex89m.mdrop.AntyLog;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import pl.rex89m.mdrop.BossBar.Bossy;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Player.PlayerSettings;

import java.util.ArrayList;
import java.util.UUID;

public class Every {

    public final MDrop plugin;

    public Every(MDrop plugin) {
        this.plugin = plugin;
    }

    public void every(){
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            @Override
            public void run() {
                every();
                ArrayList<UUID> remove = new ArrayList<>();
                for (UUID i : PlayerSettings.antyloglist){
                    PlayerSettings playerSettings = PlayerSettings.get(i);
                    Bossy bossy = new Bossy(plugin);
                    if (playerSettings.getAntylog()>0){
                        playerSettings.setAntylogTime(playerSettings.getAntylog()-1);
                        if (Bukkit.getPlayer(i)!=null) {
                            bossy.set(Bukkit.getPlayer(i), ChatColor.translateAlternateColorCodes('&', "&4Anty log :" + playerSettings.getAntylog()), 1F);
                            bossy.setPercent(Bukkit.getPlayer(i), 1F); // change health/percent (between 0 and 1)
                            bossy.show(Bukkit.getPlayer(i));
                        }
                    }else{
                        remove.add(i);
                        if (Bukkit.getPlayer(i)!=null) {
                            bossy.hide(Bukkit.getPlayer(i));
                        }
                    }
                }
                for (UUID i: remove){
                    PlayerSettings.antyloglist.remove(i);
                }
            }
        },20);
    }

}
