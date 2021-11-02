package pl.rex89m.mdrop.Void;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import pl.rex89m.mdrop.MDrop;

public class VoidGui {

    public final MDrop plugin;

    public VoidGui(MDrop plugin) {
        this.plugin = plugin;
    }

    Inventory inventory = Bukkit.createInventory(null, 9*6, ChatColor.BLACK+"Otchlan");

    public void open(Player p){
        p.openInventory(inventory);
    }
}
