package pl.rex89m.mdrop.Ban;

import org.bukkit.entity.Player;

import java.util.Date;

public class BanInfo {

    private Player player;

    private String reason;

    private String sender;

    private Date dateCreated;

    private Date dateend;

    private boolean perm = false;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean hasperm(){
        return perm;
    }

    public void setPerm(boolean perm) {
        this.perm = perm;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateend() {
        return dateend;
    }

    public void setDateend(Date dateend) {
        this.dateend = dateend;
    }

    public BanInfo() {}
}
