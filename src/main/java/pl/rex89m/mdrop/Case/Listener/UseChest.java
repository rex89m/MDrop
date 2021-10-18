package pl.rex89m.mdrop.Case.Listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import pl.rex89m.mdrop.Case.Case;
import pl.rex89m.mdrop.MDrop;

public class UseChest implements Listener {

    public final MDrop plugin;

    public UseChest(MDrop player) {
        this.plugin = player;
    }

    @EventHandler
    public void useChest(PlayerInteractEvent e){
        if (e.getItem()!=null) {
            if (e.getItem().getType() == Material.CHEST || e.getItem().getType() == Material.ENDER_CHEST || e.getItem().getType() == Material.TRAPPED_CHEST || e.getItem().getType()==Material.TRIPWIRE_HOOK){
                if (e.getItem().getItemMeta().hasDisplayName()) {
                    for (String i : Case.getAllID()) {
                        e.setCancelled(true);
                        if (e.getItem().getType()==Material.TRIPWIRE_HOOK){
                            if (e.getItem().getItemMeta().getDisplayName().equals(Case.get(i).getKey().getItemMeta().getDisplayName())) {
                                if (e.getPlayer().getInventory().containsAtLeast(Case.get(i).getChest(), 1)) {
                                    ItemStack var1 = Case.get(i).getChest();
                                    var1.setAmount(1);
                                    ItemStack var2 = Case.get(i).getKey();
                                    var2.setAmount(1);
                                    e.getPlayer().getInventory().removeItem(var1);
                                    e.getPlayer().getInventory().removeItem(var2);
                                    plugin.caseOpen.open(e.getPlayer(), i);
                                    plugin.sql.addTopPlayerCase(e.getPlayer().getName(), i);
                                    break;
                                }else{
                                    e.getPlayer().sendMessage("Brak szkrzyni");
                                }
                            }else{
                                e.getPlayer().sendMessage("nie ma takiego klucza");
                            }
                        }else{
                            if (e.getItem().getItemMeta().getDisplayName().equals(Case.get(i).getChest().getItemMeta().getDisplayName())) {
                                if (e.getPlayer().getInventory().containsAtLeast(Case.get(i).getKey(), 1)) {
                                    ItemStack var1 = Case.get(i).getChest();
                                    var1.setAmount(1);
                                    ItemStack var2 = Case.get(i).getKey();
                                    var2.setAmount(1);
                                    e.getPlayer().getInventory().removeItem(var1);
                                    e.getPlayer().getInventory().removeItem(var2);
                                    plugin.caseOpen.open(e.getPlayer(), i);
                                    plugin.sql.addTopPlayerCase(e.getPlayer().getName(), i);
                                    break;
                                }else{
                                    e.getPlayer().sendMessage("Brak klucza");
                                }
                            }else{
                                e.getPlayer().sendMessage("nie ma takiej skrzyni");
                            }
                        }
                    }
                }
            }
        }
    }
}
