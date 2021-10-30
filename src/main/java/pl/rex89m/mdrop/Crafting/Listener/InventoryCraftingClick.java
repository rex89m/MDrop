package pl.rex89m.mdrop.Crafting.Listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.rex89m.mdrop.Crafting.Inventory;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Stoniarka.Stoniarka;

public class InventoryCraftingClick implements Listener {


    public final MDrop plugin;

    public InventoryCraftingClick(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (e.getWhoClicked().getOpenInventory().getTitle().equals("Crafting "+ ChatColor.YELLOW+"Nieskonczone jedzenie")){
            if (e.getRawSlot()<54){
                if (e.getRawSlot()==45) e.getWhoClicked().openInventory(Inventory.chicken());
                else if (e.getRawSlot()==46) e.getWhoClicked().openInventory(Inventory.tnt());
                else if (e.getRawSlot()==47) e.getWhoClicked().openInventory(Inventory.fosa());
                else if (e.getRawSlot()==48) e.getWhoClicked().openInventory(Inventory.boy());
                else if (e.getRawSlot()==49) e.getWhoClicked().openInventory(Inventory.sand());
                else if (e.getRawSlot()==50) e.getWhoClicked().openInventory(Inventory.ender());
                else if (e.getRawSlot()==51) e.getWhoClicked().openInventory(Inventory.stoniarkaplus());
                else if (e.getRawSlot()==52) e.getWhoClicked().openInventory(Inventory.stoniarka());
           //     else if (e.getRawSlot()==53) e.getWhoClicked().openInventory(Inventory.tnt());
                e.setCancelled(true);
            }
        }else if (e.getWhoClicked().getOpenInventory().getTitle().equals("Crafting "+ ChatColor.RED+"Odpalone TNT")){
            if (e.getRawSlot()<54){
                if (e.getRawSlot()==45) e.getWhoClicked().openInventory(Inventory.chicken());
                else if (e.getRawSlot()==46) e.getWhoClicked().openInventory(Inventory.tnt());
                else if (e.getRawSlot()==47) e.getWhoClicked().openInventory(Inventory.fosa());
                else if (e.getRawSlot()==48) e.getWhoClicked().openInventory(Inventory.boy());
                else if (e.getRawSlot()==49) e.getWhoClicked().openInventory(Inventory.sand());
                else if (e.getRawSlot()==50) e.getWhoClicked().openInventory(Inventory.ender());
                else if (e.getRawSlot()==51) e.getWhoClicked().openInventory(Inventory.stoniarkaplus());
                else if (e.getRawSlot()==52) e.getWhoClicked().openInventory(Inventory.stoniarka());
                //     else if (e.getRawSlot()==53) e.getWhoClicked().openInventory(Inventory.tnt());
                e.setCancelled(true);
            }
        }else if (e.getWhoClicked().getOpenInventory().getTitle().equals("Crafting "+ ChatColor.RED+"FosaFarmer")){
            if (e.getRawSlot()<54){
                if (e.getRawSlot()==45) e.getWhoClicked().openInventory(Inventory.chicken());
                else if (e.getRawSlot()==46) e.getWhoClicked().openInventory(Inventory.tnt());
                else if (e.getRawSlot()==47) e.getWhoClicked().openInventory(Inventory.fosa());
                else if (e.getRawSlot()==48) e.getWhoClicked().openInventory(Inventory.boy());
                else if (e.getRawSlot()==49) e.getWhoClicked().openInventory(Inventory.sand());
                else if (e.getRawSlot()==50) e.getWhoClicked().openInventory(Inventory.ender());
                else if (e.getRawSlot()==51) e.getWhoClicked().openInventory(Inventory.stoniarkaplus());
                else if (e.getRawSlot()==52) e.getWhoClicked().openInventory(Inventory.stoniarka());
                //     else if (e.getRawSlot()==53) e.getWhoClicked().openInventory(Inventory.tnt());
                e.setCancelled(true);
            }
        }else if (e.getWhoClicked().getOpenInventory().getTitle().equals("Crafting "+ ChatColor.RED+"BoyFarmer")){
            if (e.getRawSlot()<54){
                if (e.getRawSlot()==45) e.getWhoClicked().openInventory(Inventory.chicken());
                else if (e.getRawSlot()==46) e.getWhoClicked().openInventory(Inventory.tnt());
                else if (e.getRawSlot()==47) e.getWhoClicked().openInventory(Inventory.fosa());
                else if (e.getRawSlot()==48) e.getWhoClicked().openInventory(Inventory.boy());
                else if (e.getRawSlot()==49) e.getWhoClicked().openInventory(Inventory.sand());
                else if (e.getRawSlot()==50) e.getWhoClicked().openInventory(Inventory.ender());
                else if (e.getRawSlot()==51) e.getWhoClicked().openInventory(Inventory.stoniarkaplus());
                else if (e.getRawSlot()==52) e.getWhoClicked().openInventory(Inventory.stoniarka());
                //     else if (e.getRawSlot()==53) e.getWhoClicked().openInventory(Inventory.tnt());
                e.setCancelled(true);
            }
        }else if (e.getWhoClicked().getOpenInventory().getTitle().equals("Crafting "+ ChatColor.YELLOW+"SandFarmer")){
            if (e.getRawSlot()<54){
                if (e.getRawSlot()==45) e.getWhoClicked().openInventory(Inventory.chicken());
                else if (e.getRawSlot()==46) e.getWhoClicked().openInventory(Inventory.tnt());
                else if (e.getRawSlot()==47) e.getWhoClicked().openInventory(Inventory.fosa());
                else if (e.getRawSlot()==48) e.getWhoClicked().openInventory(Inventory.boy());
                else if (e.getRawSlot()==49) e.getWhoClicked().openInventory(Inventory.sand());
                else if (e.getRawSlot()==50) e.getWhoClicked().openInventory(Inventory.ender());
                else if (e.getRawSlot()==51) e.getWhoClicked().openInventory(Inventory.stoniarkaplus());
                else if (e.getRawSlot()==52) e.getWhoClicked().openInventory(Inventory.stoniarka());
                //     else if (e.getRawSlot()==53) e.getWhoClicked().openInventory(Inventory.tnt());
                e.setCancelled(true);
            }
        }else if (e.getWhoClicked().getOpenInventory().getTitle().equals("Crafting ender chest")){
            if (e.getRawSlot()<54){
                if (e.getRawSlot()==45) e.getWhoClicked().openInventory(Inventory.chicken());
                else if (e.getRawSlot()==46) e.getWhoClicked().openInventory(Inventory.tnt());
                else if (e.getRawSlot()==47) e.getWhoClicked().openInventory(Inventory.fosa());
                else if (e.getRawSlot()==48) e.getWhoClicked().openInventory(Inventory.boy());
                else if (e.getRawSlot()==49) e.getWhoClicked().openInventory(Inventory.sand());
                else if (e.getRawSlot()==50) e.getWhoClicked().openInventory(Inventory.ender());
                else if (e.getRawSlot()==51) e.getWhoClicked().openInventory(Inventory.stoniarkaplus());
                else if (e.getRawSlot()==52) e.getWhoClicked().openInventory(Inventory.stoniarka());
                //     else if (e.getRawSlot()==53) e.getWhoClicked().openInventory(Inventory.tnt());
                e.setCancelled(true);
            }
        }else if (e.getWhoClicked().getOpenInventory().getTitle().equals("Crafting "+ Stoniarka.getName()+"+")){
            if (e.getRawSlot()<54){
                if (e.getRawSlot()==45) e.getWhoClicked().openInventory(Inventory.chicken());
                else if (e.getRawSlot()==46) e.getWhoClicked().openInventory(Inventory.tnt());
                else if (e.getRawSlot()==47) e.getWhoClicked().openInventory(Inventory.fosa());
                else if (e.getRawSlot()==48) e.getWhoClicked().openInventory(Inventory.boy());
                else if (e.getRawSlot()==49) e.getWhoClicked().openInventory(Inventory.sand());
                else if (e.getRawSlot()==50) e.getWhoClicked().openInventory(Inventory.ender());
                else if (e.getRawSlot()==51) e.getWhoClicked().openInventory(Inventory.stoniarkaplus());
                else if (e.getRawSlot()==52) e.getWhoClicked().openInventory(Inventory.stoniarka());
                //     else if (e.getRawSlot()==53) e.getWhoClicked().openInventory(Inventory.tnt());
                e.setCancelled(true);
            }
        }else if (e.getWhoClicked().getOpenInventory().getTitle().equals("Crafting "+ Stoniarka.getName())){
            if (e.getRawSlot()<54){
                if (e.getRawSlot()==45) e.getWhoClicked().openInventory(Inventory.chicken());
                else if (e.getRawSlot()==46) e.getWhoClicked().openInventory(Inventory.tnt());
                else if (e.getRawSlot()==47) e.getWhoClicked().openInventory(Inventory.fosa());
                else if (e.getRawSlot()==48) e.getWhoClicked().openInventory(Inventory.boy());
                else if (e.getRawSlot()==49) e.getWhoClicked().openInventory(Inventory.sand());
                else if (e.getRawSlot()==50) e.getWhoClicked().openInventory(Inventory.ender());
                else if (e.getRawSlot()==51) e.getWhoClicked().openInventory(Inventory.stoniarkaplus());
                else if (e.getRawSlot()==52) e.getWhoClicked().openInventory(Inventory.stoniarka());
                //     else if (e.getRawSlot()==53) e.getWhoClicked().openInventory(Inventory.tnt());
                e.setCancelled(true);
            }
        }
    }
}
