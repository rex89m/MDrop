package pl.rex89m.mdrop.Drop.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.rex89m.mdrop.Drop.Drop;
import pl.rex89m.mdrop.MDrop;

public class DropEvent implements Listener {

    public final MDrop plugin;

    public DropEvent(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if (!e.isCancelled()) {
            if (e.getBlock().getType() == Material.STONE) {
                double randDouble = Math.random();
                for (Material i: Drop.getDrop().keySet()) {
                    Drop drop = Drop.getDrop(i);
                    if (randDouble <= drop.getChance()/100){
                        ItemStack itemStack = new ItemStack(drop.getItem());
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        itemMeta.setDisplayName(drop.getName());
                        itemMeta.setLore(drop.getLore());
                        itemStack.setItemMeta(itemMeta);
                        if (e.getPlayer().getInventory().firstEmpty()!=-1) {
                            e.getPlayer().getInventory().addItem(itemStack);
                        }else{
                            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), itemStack);
                        }
                    }
                }
            }
        }
    }
}
