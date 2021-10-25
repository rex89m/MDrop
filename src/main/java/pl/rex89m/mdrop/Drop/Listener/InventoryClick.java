package pl.rex89m.mdrop.Drop.Listener;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;
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
            e.setCancelled(true);
            if (e.getCurrentItem()!=null){
                if (e.getCurrentItem().getType()!=null) {
                    if (e.getCurrentItem().getItemMeta()!=null) {
                        PlayerSettings playerSettings = PlayerSettings.get(e.getWhoClicked().getUniqueId());
                        if (e.getRawSlot()!=Drop.Cobble_slot) {
                            for (String i : playerSettings.getDrop().split("#")) {
                                String[] var = i.split("@");
                                if (e.getCurrentItem().getType().name().equals(var[0])) {
                                    if (var[1].equals("true")) {
                                        ItemMeta itemMeta = e.getCurrentItem().getItemMeta();
                                        itemMeta.removeEnchant(Enchantment.DAMAGE_ALL);
                                        e.getCurrentItem().setItemMeta(itemMeta);
                                    } else {
                                        ItemMeta itemMeta = e.getCurrentItem().getItemMeta();
                                        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, false);
                                        e.getCurrentItem().setItemMeta(itemMeta);
                                    }
                                    String var3 = playerSettings.getDrop();
                                    plugin.sql.updateSettingsDrop((Player) e.getWhoClicked(), var3.replaceAll(e.getCurrentItem().getType().name() + "@" + var[1], e.getCurrentItem().getType().name() + "@" + !Boolean.parseBoolean(var[1])));
                                    break;
                                }
                            }
                        }else{
                            if (playerSettings.getCobblestone()) {
                                ItemMeta itemMeta = e.getCurrentItem().getItemMeta();
                                itemMeta.removeEnchant(Enchantment.DAMAGE_ALL);
                                e.getCurrentItem().setItemMeta(itemMeta);
                            } else {
                                ItemMeta itemMeta = e.getCurrentItem().getItemMeta();
                                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, false);
                                e.getCurrentItem().setItemMeta(itemMeta);
                            }
                            plugin.sql.updateSettingsDropCobblestone((Player) e.getWhoClicked(), !playerSettings.getCobblestone());
                        }
                    }
                }
            }
        }
    }
}
