package pl.rex89m.mdrop.Player;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class PlayerSettings {

    private UUID uuid;

    private String nick;

    private String drop;

    private int antylog;

    public static ArrayList<UUID> antyloglist = new ArrayList<>();

    public int getAntylog() {
        return antylog;
    }

    public void setAntylog(int antylog) {
        this.antylog = antylog;
        antyloglist.add(uuid);
    }
    public void setAntylogTime(int antylog) {
        this.antylog = antylog;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String drop) {
        this.drop = drop;
    }

    private static HashMap<UUID, PlayerSettings> save = new HashMap<>();

    public PlayerSettings(Player p){
        this.nick=p.getName();
        this.uuid=p.getUniqueId();
        save.put(p.getUniqueId(), this);
    }

    public static PlayerSettings get(UUID uuid){
        return save.get(uuid);
    }
}
