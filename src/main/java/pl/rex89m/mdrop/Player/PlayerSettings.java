package pl.rex89m.mdrop.Player;

import org.bukkit.entity.Player;
import pl.rex89m.mdrop.Ban.BanInfo;
import pl.rex89m.mdrop.Mute.MuteInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class PlayerSettings {

    private UUID uuid;

    private String nick;

    private Boolean cobblestone;

    private String drop;

    private BanInfo banInfo;

    private MuteInfo muteInfo;

    private int antylog;

    private HashMap<String , Date> kits;

    public MuteInfo getMuteInfo() {
        return muteInfo;
    }

    public void setMuteInfo(MuteInfo muteInfo) {
        this.muteInfo = muteInfo;
    }

    public boolean hasMute(){
        if (muteInfo.getDateend()==null){
            return false;
        }
        return true;
    }

    public HashMap<String, Date> getKits() {
        return kits;
    }

    public void setKits(HashMap<String, Date> kits) {
        this.kits = kits;
    }

    public BanInfo getBanInfo() {
        return banInfo;
    }

    public void setBanInfo(BanInfo banInfo) {
        this.banInfo = banInfo;
    }

    public Boolean getCobblestone() {
        return cobblestone;
    }

    public boolean hasBan(){
        if (banInfo.getReason()==null){
            return false;
        }
        return true;
    }

    public void setCobblestone(Boolean cobblestone) {
        this.cobblestone = cobblestone;
    }

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
