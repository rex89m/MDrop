package pl.rex89m.mdrop.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.rex89m.mdrop.Drop.Drop;

public class DropCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Inventory inventory = Bukkit.createInventory((InventoryHolder) sender, 9*Drop.Inventory_size, Drop.Inventory_name);
        for (Material i : Drop.getDrop().keySet()){
            Drop drop = Drop.getDrop(i);
            ItemStack stack = new ItemStack(i);
            ItemMeta itemMeta = stack.getItemMeta();
            itemMeta.setDisplayName(drop.getName());
            itemMeta.setLore(drop.getLoreInventory());
            stack.setItemMeta(itemMeta);
            inventory.setItem(drop.getSlot(), stack);
        }
        ((Player)sender).openInventory(inventory);
        return false;
    }
}