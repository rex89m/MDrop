package pl.rex89m.mdrop.Crafting.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import pl.rex89m.mdrop.MDrop;

public class Events implements Listener {

    public final MDrop plugin;

    public Events(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e){
        if (e.getItem().getType()== Material.COOKED_CHICKEN){
            if (e.getItem().getItemMeta().hasEnchant(Enchantment.ARROW_DAMAGE)){
                e.setCancelled(true);
                e.getPlayer().setFoodLevel(20);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlace(BlockPlaceEvent e){
        if (!e.isCancelled()) {
            if (e.getBlockPlaced().getType() == Material.ENDER_PORTAL_FRAME) {
                if (e.getItemInHand().hasItemMeta()) {
                    if (e.getItemInHand().getItemMeta().hasDisplayName()) {
                        if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "FosaFarmer")) {
                            for (int i = 0; i < 256; i++) {
                                if (e.getBlockPlaced().getLocation().getWorld().getBlockAt(e.getBlockPlaced().getLocation().add(0,-i,0)).getType() != Material.BEDROCK) {
                                    e.getBlockPlaced().getLocation().add(0,-i,0).getBlock().setType(Material.AIR);
                                } else {
                                    break;
                                }
                            }
                        } else if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "BoyFarmer")) {
                            Location location = e.getBlockPlaced().getLocation();
                            for (int i = 0; i < 256; i++) {
                                if (location.getWorld().getBlockAt(location).getType() != Material.BEDROCK) {
                                    location.getBlock().setType(Material.OBSIDIAN);
                                    location.add(0, -1, 0);
                                } else {
                                    break;
                                }
                            }
                        } else if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "SandFarmer")) {
                            Location location = e.getBlockPlaced().getLocation();
                            for (int i = 0; i < 256; i++) {
                                if (location.getWorld().getBlockAt(location).getType() != Material.BEDROCK) {
                                    location.getBlock().setType(Material.SAND);
                                    location.add(0, -1, 0);
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            } else if (e.getBlock().getType() == Material.TNT){
                if (e.getItemInHand().hasItemMeta()) {
                    if (e.getItemInHand().getItemMeta().hasDisplayName()) {
                        if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "Odpalone TNT")) {
                            e.getBlock().setType(Material.AIR);
                            e.getBlock().getWorld().spawnEntity(e.getBlockPlaced().getLocation(), EntityType.PRIMED_TNT);
                        }
                    }
                }
            }
        }
    }
}
