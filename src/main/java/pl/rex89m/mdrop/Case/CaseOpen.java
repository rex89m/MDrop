package pl.rex89m.mdrop.Case;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.rex89m.mdrop.MDrop;

public class CaseOpen {

    final MDrop plugin;

    public CaseOpen(MDrop plugin) {
        this.plugin = plugin;
    }

    int[] slots = {10, 11, 12, 13, 14, 15};


    public void Open(Player p){
        Inventory inventory = Bukkit.createInventory(p, 9*3, "case");
        for (int i=0;i<26;i++){
            inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15));
        }


    }
}
