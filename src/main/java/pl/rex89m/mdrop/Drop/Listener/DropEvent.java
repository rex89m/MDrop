package pl.rex89m.mdrop.Drop.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.rex89m.mdrop.Drop.Drop;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Player.PlayerSettings;
import pl.rex89m.mdrop.Stoniarka.Stoniarka;

import java.util.HashMap;

public class DropEvent implements Listener {

    public final MDrop plugin;

    public DropEvent(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if (!e.isCancelled()) {
            if (e.getBlock().getType() == Material.STONE) {
                if (e.getPlayer().getInventory().getItemInHand().getType() == Material.GOLD_PICKAXE) {
                    if (Stoniarka.isStoniarka(e.getBlock().getLocation()) && Stoniarka.isStoniarka(e.getBlock().getLocation(),true)){
                        return;
                    }
                }else{
                    double randDouble = Math.random();
                    HashMap<String, String> var = new HashMap<>();
                    for (String i : PlayerSettings.get(e.getPlayer().getUniqueId()).getDrop().split("#")) {
                        String[] var2 = i.split("@");
                        var.put(var2[0], var2[1]);
                    }
                    for (Material i : Drop.getDrop().keySet()) {
                        if (var.containsKey(i.name())) {
                            if (var.get(i.name()).equals("true")) {
                                Drop drop = Drop.getDrop(i);
                                if (randDouble <= drop.getChance() / 100) {
                                    ItemStack itemStack = new ItemStack(drop.getItem());
                                    ItemMeta itemMeta = itemStack.getItemMeta();
                                    itemMeta.setDisplayName(drop.getName());
                                    itemMeta.setLore(drop.getLore());
                                    itemStack.setItemMeta(itemMeta);
                                    if (e.getPlayer().getInventory().firstEmpty() != -1) {
                                        e.getPlayer().getInventory().addItem(itemStack);
                                    } else {
                                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), itemStack);
                                    }
                                }
                            }
                        }
                    }
                    if (!PlayerSettings.get(e.getPlayer().getUniqueId()).getCobblestone()) {
                        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                            @Override
                            public void run() {
                                for (Entity i : e.getBlock().getWorld().getNearbyEntities(e.getBlock().getLocation(), 1, 1, 1)) {
                                    if (i.getType() == EntityType.DROPPED_ITEM) {
                                        System.out.println(i.getType().name());
                                        i.remove();
                                        break;
                                    }
                                }
                            }
                        }, 1);
                    }
                }
            }
        }
    }
}
