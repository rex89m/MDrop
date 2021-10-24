package pl.rex89m.mdrop.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Stoniarka implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("stoniarka.give")) {
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                ItemStack itemStack = new ItemStack(Material.ENDER_STONE);
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(pl.rex89m.mdrop.Stoniarka.Stoniarka.getName());
                itemMeta.setLore(pl.rex89m.mdrop.Stoniarka.Stoniarka.getLore());
                itemStack.setItemMeta(itemMeta);
                target.getInventory().addItem(itemStack);
            } else {
                Player target = (Player) sender;
                ItemStack itemStack = new ItemStack(Material.ENDER_STONE);
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(pl.rex89m.mdrop.Stoniarka.Stoniarka.getName());
                itemMeta.setLore(pl.rex89m.mdrop.Stoniarka.Stoniarka.getLore());
                itemStack.setItemMeta(itemMeta);
                target.getInventory().addItem(itemStack);
            }
        }
        return false;
    }
}
