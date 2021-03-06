package pl.rex89m.mdrop.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.rex89m.mdrop.Player.PlayerSettings;

import java.util.Arrays;

public class EffectCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (PlayerSettings.get(((Player) sender).getUniqueId()).getAntylog() <= 0) {
            Inventory inventory = Bukkit.createInventory((InventoryHolder) sender, 36, ChatColor.translateAlternateColorCodes('&',"&3Efekty"));
            for (int i = 0; i < 36; i++) {
                ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                itemStack.getItemMeta().setDisplayName("");
                inventory.setItem(i, itemStack);
            }
            ItemStack sila1 = new ItemStack(Material.BLAZE_ROD, 1);
            ItemMeta sila1Meta = sila1.getItemMeta();
            sila1Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&4Siła 1"));
            sila1Meta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&',"&aEmerald Block x64"), ChatColor.translateAlternateColorCodes('&',"&6Czas 2 min")));
            sila1.setItemMeta(sila1Meta);
            inventory.setItem(10, sila1);

            ItemStack sila2 = new ItemStack(Material.BLAZE_ROD, 1);
            ItemMeta sila2Meta = sila2.getItemMeta();
            sila2Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&4Siła 2"));
            sila2Meta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&',"&aEmerald Block x128"), ChatColor.translateAlternateColorCodes('&',"&6Czas 1 min")));
            sila2.setItemMeta(sila2Meta);
            inventory.setItem(19, sila2);

            ItemStack speed = new ItemStack(Material.BLAZE_POWDER, 1);
            ItemMeta speedmeta = speed.getItemMeta();
            speedmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&bSzybkość 1"));
            speedmeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&',"&aEmerald Block x64"), ChatColor.translateAlternateColorCodes('&',"&6Czas 2 min")));
            speed.setItemMeta(speedmeta);
            inventory.setItem(12, speed);

            ItemStack jump = new ItemStack(Material.RABBIT_FOOT, 1);
            ItemMeta jumpmeta = speed.getItemMeta();
            jumpmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&aWysoki skok 1"));
            jumpmeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&',"&aEmerald Block x64"), ChatColor.translateAlternateColorCodes('&',"&6Czas 5 min")));
            jump.setItemMeta(jumpmeta);
            inventory.setItem(16, jump);

            ItemStack jump2 = new ItemStack(Material.RABBIT_FOOT, 1);
            ItemMeta jumpmeta2 = speed.getItemMeta();
            jumpmeta2.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&aWysoki skok 2"));
            jumpmeta2.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&',"&aEmerald Block x128"), ChatColor.translateAlternateColorCodes('&',"&6Czas 5 min")));
            jump2.setItemMeta(jumpmeta2);
            inventory.setItem(25, jump2);

            ItemStack mine = new ItemStack(Material.GOLD_PICKAXE, 1);
            ItemMeta minemeta2 = speed.getItemMeta();
            minemeta2.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&eSzybkie kopanie"));
            minemeta2.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&',"&aEmerald Block x64"), ChatColor.translateAlternateColorCodes('&',"&6Czas 2 min")));
            mine.setItemMeta(minemeta2);
            inventory.setItem(14, mine);
            ((Player) sender).openInventory(inventory);
        }
        return false;
    }
}
