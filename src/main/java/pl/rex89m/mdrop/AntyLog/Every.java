package pl.rex89m.mdrop.AntyLog;

import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
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
                    if (playerSettings.getAntylog()>0){
                        playerSettings.setAntylogTime(playerSettings.getAntylog()-1);
                        if (Bukkit.getPlayer(i)!=null) {
                            sendActionText(Bukkit.getPlayer(i), ChatColor.translateAlternateColorCodes('&', "&4"+playerSettings.getAntylog()+"s"));
                        }
                    }else{
                        remove.add(i);
                    }
                }
                for (UUID i: remove){
                    PlayerSettings.antyloglist.remove(i);
                }
            }
        },20);
    }
    public void sendActionText(Player player, String message){
        PacketPlayOutChat packet = new PacketPlayOutChat(new ChatComponentText(message), (byte)2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

}
