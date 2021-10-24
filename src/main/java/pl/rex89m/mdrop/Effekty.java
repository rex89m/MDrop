package pl.rex89m.mdrop;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Effekty implements Listener {

    public final MDrop plugin;

    public Effekty(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (e.getWhoClicked().getOpenInventory().getTitle().equals(ChatColor.translateAlternateColorCodes('&',"&3Efekty"))){
            e.setCancelled(true);
            if (e.getCurrentItem()!=null){
                if (e.getCurrentItem().getItemMeta()!=null){
                    if (e.getCurrentItem().getItemMeta().hasDisplayName()){
                        if (e.getRawSlot()==10){
                            ItemStack stack = new ItemStack(Material.EMERALD_BLOCK, 64);
                            if (e.getWhoClicked().getInventory().containsAtLeast(stack, stack.getAmount())){
                                e.getWhoClicked().getInventory().removeItem(stack);
                                e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*60*2,0,false, true));
                            }
                        }else if (e.getRawSlot()==19){
                            ItemStack stack = new ItemStack(Material.EMERALD_BLOCK, 64*2);
                            if (e.getWhoClicked().getInventory().containsAtLeast(stack, stack.getAmount())){
                                e.getWhoClicked().getInventory().removeItem(stack);
                                e.getWhoClicked().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                                e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*60*1,1,false, true));
                            }
                        }else if (e.getRawSlot()==12){
                            ItemStack stack = new ItemStack(Material.EMERALD_BLOCK, 64);
                            if (e.getWhoClicked().getInventory().containsAtLeast(stack, stack.getAmount())){
                                e.getWhoClicked().getInventory().removeItem(stack);
                                e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*60*2,0,false, true));
                            }
                        }else if (e.getRawSlot()==16){
                            ItemStack stack = new ItemStack(Material.EMERALD_BLOCK, 64);
                            if (e.getWhoClicked().getInventory().containsAtLeast(stack, stack.getAmount())){
                                e.getWhoClicked().getInventory().removeItem(stack);
                                e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*60*5,0,false, true));
                            }
                        }else if (e.getRawSlot()==25){
                            ItemStack stack = new ItemStack(Material.EMERALD_BLOCK, 64*2);
                            if (e.getWhoClicked().getInventory().containsAtLeast(stack, stack.getAmount())){
                                e.getWhoClicked().getInventory().removeItem(stack);
                                e.getWhoClicked().removePotionEffect(PotionEffectType.JUMP);
                                e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*60*5,1,false, true));
                            }
                        }else if (e.getRawSlot()==14){
                            ItemStack stack = new ItemStack(Material.EMERALD_BLOCK, 64);
                            if (e.getWhoClicked().getInventory().containsAtLeast(stack, stack.getAmount())){
                                e.getWhoClicked().getInventory().removeItem(stack);
                                e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20*60*2,0,false, true));
                            }
                        }
                    }
                }
            }
        }
    }
}
