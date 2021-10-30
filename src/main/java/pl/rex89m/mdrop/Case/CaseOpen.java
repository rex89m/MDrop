package pl.rex89m.mdrop.Case;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.rex89m.mdrop.MDrop;

import java.util.HashMap;
import java.util.Random;

public class CaseOpen {

    public final MDrop plugin;

    public CaseOpen(MDrop plugin) {
        this.plugin = plugin;
    }

    int[] slots = {10, 11, 12, 13, 14, 15, 16};
    int winslot = 13;

    HashMap<Player, Integer> playerOpenCase = new HashMap<>();

    public void open(Player p, String id){
        if (p.getInventory().firstEmpty()!=-1) {
            Random random = new Random();
            playerOpenCase.put(p, random.nextInt(10) + Case.get(id).getItems().size()+10);
            Inventory inventory = Bukkit.createInventory(p, 27, Case.get(id).getName());
            for (int i = 0; i < 27; i++) {
                inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15));
            }
            for (int i : slots) {
                inventory.setItem(i, random(id));
            }
            p.openInventory(inventory);
            nextItem(id, inventory, p);
        }else{
            p.sendMessage("full Inventory");
        }
    }

    public void nextItem(String id, Inventory inventory, Player p){
        if (playerOpenCase.get(p)>=1) {
            playerOpenCase.put(p, playerOpenCase.get(p)-1);
            if (p.getOpenInventory().getTitle().equals(inventory.getTitle())) {
                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                    @Override
                    public void run() {
                        ItemStack[] itemStacks = new ItemStack[slots.length - 1];
                        for (int i = 0; i < itemStacks.length; i++) {
                            itemStacks[i] = inventory.getItem(slots[i + 1]);
                        }
                        int var = 0;
                        for (ItemStack i : itemStacks) {
                            inventory.setItem(slots[var], i);
                            var++;
                        }
                        inventory.setItem(slots[slots.length - 1], random(id));
                        nextItem(id, inventory, p);
                    }
                }, 5);
            }else{
                for (int i2 = 0; i2 < playerOpenCase.get(p); i2++) {
                    ItemStack[] itemStacks = new ItemStack[slots.length - 1];
                    for (int i = 0; i < itemStacks.length; i++) {
                        itemStacks[i] = inventory.getItem(slots[i + 1]);
                    }
                    int var = 0;
                    for (ItemStack i : itemStacks) {
                        inventory.setItem(slots[var], i);
                        var++;
                    }
                    inventory.setItem(slots[slots.length - 1], random(id));
                }
                if (p.getInventory().firstEmpty()!=-1) {
                    p.getInventory().addItem(inventory.getItem(winslot));
                }
                else{
                    p.getWorld().dropItemNaturally(p.getLocation(), inventory.getItem(winslot));
                }
            }
        }else{
            Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                @Override
                public void run() {
                    if (p.getInventory().firstEmpty()!=-1) {
                        p.getInventory().addItem(inventory.getItem(winslot));
                    }
                    else{
                        p.getWorld().dropItemNaturally(p.getLocation(), inventory.getItem(winslot));
                    }
                    p.closeInventory();
                }
            },20);
        }
    }

    public ItemStack random(String id){
        Random random = new Random();
        return Case.get(id).getItems().get(random.nextInt(Case.get(id).getItems().size()));
    }
}
