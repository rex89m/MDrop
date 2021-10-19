package pl.rex89m.mdrop.Drop.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.rex89m.mdrop.Baza.SQL;
import pl.rex89m.mdrop.Drop.Drop;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Player.PlayerSettings;

public class InventoryClick implements Listener {

    public final MDrop plugin;

    public InventoryClick(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if (e.getWhoClicked().getOpenInventory().getTitle().equals(Drop.Inventory_name)){
            if (e.getCurrentItem()!=null){
                if (e.getCurrentItem().getItemMeta().hasDisplayName()){
                    PlayerSettings playerSettings = PlayerSettings.get(e.getWhoClicked().getUniqueId());
                    for (String i : playerSettings.getDrop().split("#")){
                        String[] var = i.split("@");
                        if (e.getCurrentItem().getType().name().equals(var[0])){
                            String var3 = playerSettings.getDrop();
                            plugin.sql.updateSettingsDrop((Player) e.getWhoClicked(), var3.replaceAll(e.getCurrentItem().getType().name()+"@"+var[1],e.getCurrentItem().getType().name()+"@"+!Boolean.parseBoolean(var[1])));
                        }
                    }
                    e.setCancelled(true);
                }
            }
        }
    }
}
