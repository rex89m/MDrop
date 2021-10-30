package pl.rex89m.mdrop.Stoniarka.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Stoniarka.Stoniarka;

public class BreakStoniarka implements Listener {

    public final MDrop plugin;

    public BreakStoniarka(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onBreak(BlockBreakEvent e){
        if (!e.isCancelled()) {
            if (e.getBlock().getType()== Material.STONE){
                if (Stoniarka.isStoniarka(e.getBlock().getLocation())) {
                    if (e.getPlayer().getInventory().getItemInHand() != null) {
                        if (e.getPlayer().getInventory().getItemInHand().getType()==Material.GOLD_PICKAXE) {
                            plugin.sql.rmoveLocationStoniarka(e.getBlock().getLocation());
                            e.getPlayer().sendMessage(Stoniarka.getBreakMessage());
                            ItemStack itemStack = new ItemStack(Material.ENDER_STONE);
                            ItemMeta itemMeta = itemStack.getItemMeta();
                            itemMeta.setDisplayName(pl.rex89m.mdrop.Stoniarka.Stoniarka.getName());
                            itemMeta.setLore(pl.rex89m.mdrop.Stoniarka.Stoniarka.getLore());
                            itemStack.setItemMeta(itemMeta);
                            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), itemStack);
                        }else{
                            Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                                @Override
                                public void run() {
                                    e.getBlock().setType(Material.STONE);
                                }
                            }, 20);
                        }
                    }
                }else{
                    if (Stoniarka.isStoniarka(e.getBlock().getLocation(), true)) {
                        if (e.getPlayer().getInventory().getItemInHand() != null) {
                            if (e.getPlayer().getInventory().getItemInHand().getType() == Material.GOLD_PICKAXE) {
                                plugin.sql.rmoveLocationStoniarkaplus(e.getBlock().getLocation());
                                e.getPlayer().sendMessage(Stoniarka.getBreakMessage());
                                ItemStack itemStack = new ItemStack(Material.ENDER_STONE);
                                ItemMeta itemMeta = itemStack.getItemMeta();
                                itemMeta.setDisplayName(pl.rex89m.mdrop.Stoniarka.Stoniarka.getName()+"+");
                                itemMeta.setLore(pl.rex89m.mdrop.Stoniarka.Stoniarka.getLore());
                                itemStack.setItemMeta(itemMeta);
                                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), itemStack);
                            } else {
                                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                                    @Override
                                    public void run() {
                                        e.getBlock().setType(Material.STONE);
                                    }
                                }, 10);
                            }
                        }
                    }
                }
            }
        }
    }
}
