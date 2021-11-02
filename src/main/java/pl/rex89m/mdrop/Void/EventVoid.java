package pl.rex89m.mdrop.Void;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.rex89m.mdrop.MDrop;

public class EventVoid implements Listener {

    public final MDrop plugin;

    public EventVoid(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDespawn(ItemDespawnEvent e) {
        if (plugin.voidGui.inventory.firstEmpty()!=-1) {
            plugin.voidGui.inventory.addItem(e.getEntity().getItemStack());
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (e.getWhoClicked().getOpenInventory().getTitle().equals(ChatColor.BLACK+"Otchlan")){
            if (e.getRawSlot()>=54){
                e.setCancelled(true);
            }
        }
    }
}
