package pl.rex89m.mdrop.Crafting;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.rex89m.mdrop.Stoniarka.Stoniarka;

public class Inventory {

    public static org.bukkit.inventory.Inventory chicken(){
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 54, "Crafting "+ ChatColor.YELLOW+"Nieskonczone jedzenie");
        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15));
        }
        inventory.setItem(10, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(11, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(12, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(19, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(20, new ItemStack(Material.COOKED_CHICKEN));
        inventory.setItem(21, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(28, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(29, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(30, new ItemStack(Material.IRON_INGOT));

        ItemStack itemStack = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW+"Nieskonczone jedzenie");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(45, itemStack);
        inventory.setItem(24, itemStack);

        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tntmeta = tnt.getItemMeta();
        tntmeta.setDisplayName(ChatColor.RED+"Odpalone TNT");
        tnt.setItemMeta(tntmeta);
        inventory.setItem(46, tnt);

        ItemStack fosa = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta fosameta = fosa.getItemMeta();
        fosameta.setDisplayName(ChatColor.RED+"FosaFarmer");
        fosa.setItemMeta(fosameta);
        inventory.setItem(47, fosa);

        ItemStack boy = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta boymeta = boy.getItemMeta();
        boymeta.setDisplayName(ChatColor.RED+"BoyFarmer");
        boy.setItemMeta(boymeta);
        inventory.setItem(48, boy);

        ItemStack sand = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta sandmeta = sand.getItemMeta();
        sandmeta.setDisplayName(ChatColor.YELLOW+"SandFarmer");
        sand.setItemMeta(sandmeta);
        inventory.setItem(49, sand);

        ItemStack ender = new ItemStack(Material.ENDER_CHEST);
        ItemMeta endermeta = ender.getItemMeta();
        ender.setItemMeta(endermeta);
        inventory.setItem(50, ender);

        ItemStack stoniarkaplus = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkaplusmeta = stoniarkaplus.getItemMeta();
        stoniarkaplusmeta.setDisplayName(pl.rex89m.mdrop.Stoniarka.Stoniarka.getName()+"+");
        stoniarkaplus.setItemMeta(stoniarkaplusmeta);
        inventory.setItem(51, stoniarkaplus);

        ItemStack stoniarka = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkameta = stoniarka.getItemMeta();
        stoniarkameta.setDisplayName(Stoniarka.getName());
        stoniarka.setItemMeta(stoniarkameta);
        inventory.setItem(52, stoniarka);
        return inventory;
    }

    public static org.bukkit.inventory.Inventory tnt(){
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 54, "Crafting "+ ChatColor.RED+"Odpalone TNT");
        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15));
        }
        inventory.setItem(10, new ItemStack(Material.GOLD_BLOCK));
        inventory.setItem(11, new ItemStack(Material.GOLD_BLOCK));
        inventory.setItem(12, new ItemStack(Material.GOLD_BLOCK));
        inventory.setItem(19, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(20, new ItemStack(Material.TNT));
        inventory.setItem(21, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(28, new ItemStack(Material.GOLD_INGOT));
        inventory.setItem(29, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(30, new ItemStack(Material.GOLD_INGOT));

        ItemStack itemStack = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW+"Nieskonczone jedzenie");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(45, itemStack);

        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tntmeta = tnt.getItemMeta();
        tntmeta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        tntmeta.setDisplayName(ChatColor.RED+"Odpalone TNT");
        tnt.setItemMeta(tntmeta);
        inventory.setItem(46, tnt);
        inventory.setItem(24, tnt);

        ItemStack fosa = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta fosameta = fosa.getItemMeta();
        fosameta.setDisplayName(ChatColor.RED+"FosaFarmer");
        fosa.setItemMeta(fosameta);
        inventory.setItem(47, fosa);

        ItemStack boy = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta boymeta = boy.getItemMeta();
        boymeta.setDisplayName(ChatColor.RED+"BoyFarmer");
        boy.setItemMeta(boymeta);
        inventory.setItem(48, boy);

        ItemStack sand = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta sandmeta = sand.getItemMeta();
        sandmeta.setDisplayName(ChatColor.YELLOW+"SandFarmer");
        sand.setItemMeta(sandmeta);
        inventory.setItem(49, sand);

        ItemStack ender = new ItemStack(Material.ENDER_CHEST);
        ItemMeta endermeta = ender.getItemMeta();
        ender.setItemMeta(endermeta);
        inventory.setItem(50, ender);

        ItemStack stoniarkaplus = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkaplusmeta = stoniarkaplus.getItemMeta();
        stoniarkaplusmeta.setDisplayName(pl.rex89m.mdrop.Stoniarka.Stoniarka.getName()+"+");
        stoniarkaplus.setItemMeta(stoniarkaplusmeta);
        inventory.setItem(51, stoniarkaplus);

        ItemStack stoniarka = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkameta = stoniarka.getItemMeta();
        stoniarkameta.setDisplayName(Stoniarka.getName());
        stoniarka.setItemMeta(stoniarkameta);
        inventory.setItem(52, stoniarka);
        return inventory;
    }

    public static org.bukkit.inventory.Inventory fosa(){
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 54, "Crafting "+ ChatColor.RED+"FosaFarmer");
        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15));
        }
        inventory.setItem(10, new ItemStack(Material.GLASS));
        inventory.setItem(11, new ItemStack(Material.GLASS));
        inventory.setItem(12, new ItemStack(Material.GLASS));
        inventory.setItem(19, new ItemStack(Material.REDSTONE));
        inventory.setItem(20, new ItemStack(Material.GOLD_INGOT));
        inventory.setItem(21, new ItemStack(Material.REDSTONE));
        inventory.setItem(28, new ItemStack(Material.REDSTONE));
        inventory.setItem(29, new ItemStack(Material.GOLD_INGOT));
        inventory.setItem(30, new ItemStack(Material.REDSTONE));

        ItemStack itemStack = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW+"Nieskonczone jedzenie");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(45, itemStack);

        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tntmeta = tnt.getItemMeta();
        tntmeta.setDisplayName(ChatColor.RED+"Odpalone TNT");
        tnt.setItemMeta(tntmeta);
        inventory.setItem(46, tnt);

        ItemStack fosa = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta fosameta = fosa.getItemMeta();
        fosameta.setDisplayName(ChatColor.RED+"FosaFarmer");
        fosameta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        fosa.setItemMeta(fosameta);
        inventory.setItem(47, fosa);
        inventory.setItem(24, fosa);

        ItemStack boy = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta boymeta = boy.getItemMeta();
        boymeta.setDisplayName(ChatColor.RED+"BoyFarmer");
        boy.setItemMeta(boymeta);
        inventory.setItem(48, boy);

        ItemStack sand = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta sandmeta = sand.getItemMeta();
        sandmeta.setDisplayName(ChatColor.YELLOW+"SandFarmer");
        sand.setItemMeta(sandmeta);
        inventory.setItem(49, sand);

        ItemStack ender = new ItemStack(Material.ENDER_CHEST);
        ItemMeta endermeta = ender.getItemMeta();
        ender.setItemMeta(endermeta);
        inventory.setItem(50, ender);

        ItemStack stoniarkaplus = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkaplusmeta = stoniarkaplus.getItemMeta();
        stoniarkaplusmeta.setDisplayName(pl.rex89m.mdrop.Stoniarka.Stoniarka.getName()+"+");
        stoniarkaplus.setItemMeta(stoniarkaplusmeta);
        inventory.setItem(51, stoniarkaplus);

        ItemStack stoniarka = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkameta = stoniarka.getItemMeta();
        stoniarkameta.setDisplayName(Stoniarka.getName());
        stoniarka.setItemMeta(stoniarkameta);
        inventory.setItem(52, stoniarka);
        return inventory;
    }

    public static org.bukkit.inventory.Inventory boy(){
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 54, "Crafting "+ ChatColor.RED+"BoyFarmer");
        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15));
        }
        inventory.setItem(10, new ItemStack(Material.OBSIDIAN));
        inventory.setItem(11, new ItemStack(Material.OBSIDIAN));
        inventory.setItem(12, new ItemStack(Material.OBSIDIAN));
        inventory.setItem(19, new ItemStack(Material.REDSTONE));
        inventory.setItem(20, new ItemStack(Material.GOLD_INGOT));
        inventory.setItem(21, new ItemStack(Material.REDSTONE));
        inventory.setItem(28, new ItemStack(Material.REDSTONE));
        inventory.setItem(29, new ItemStack(Material.GOLD_INGOT));
        inventory.setItem(30, new ItemStack(Material.REDSTONE));

        ItemStack itemStack = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW+"Nieskonczone jedzenie");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(45, itemStack);

        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tntmeta = tnt.getItemMeta();
        tntmeta.setDisplayName(ChatColor.RED+"Odpalone TNT");
        tnt.setItemMeta(tntmeta);
        inventory.setItem(46, tnt);

        ItemStack fosa = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta fosameta = fosa.getItemMeta();
        fosameta.setDisplayName(ChatColor.RED+"FosaFarmer");
        fosa.setItemMeta(fosameta);
        inventory.setItem(47, fosa);

        ItemStack boy = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta boymeta = boy.getItemMeta();
        boymeta.setDisplayName(ChatColor.RED+"BoyFarmer");
        boymeta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        boy.setItemMeta(boymeta);
        inventory.setItem(48, boy);
        inventory.setItem(24, boy);

        ItemStack sand = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta sandmeta = sand.getItemMeta();
        sandmeta.setDisplayName(ChatColor.YELLOW+"SandFarmer");
        sand.setItemMeta(sandmeta);
        inventory.setItem(49, sand);

        ItemStack ender = new ItemStack(Material.ENDER_CHEST);
        ItemMeta endermeta = ender.getItemMeta();
        ender.setItemMeta(endermeta);
        inventory.setItem(50, ender);

        ItemStack stoniarkaplus = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkaplusmeta = stoniarkaplus.getItemMeta();
        stoniarkaplusmeta.setDisplayName(pl.rex89m.mdrop.Stoniarka.Stoniarka.getName()+"+");
        stoniarkaplus.setItemMeta(stoniarkaplusmeta);
        inventory.setItem(51, stoniarkaplus);

        ItemStack stoniarka = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkameta = stoniarka.getItemMeta();
        stoniarkameta.setDisplayName(Stoniarka.getName());
        stoniarka.setItemMeta(stoniarkameta);
        inventory.setItem(52, stoniarka);
        return inventory;
    }

    public static org.bukkit.inventory.Inventory sand(){
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 54, "Crafting "+ ChatColor.YELLOW+"SandFarmer");
        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15));
        }
        inventory.setItem(10, new ItemStack(Material.SANDSTONE));
        inventory.setItem(11, new ItemStack(Material.SANDSTONE));
        inventory.setItem(12, new ItemStack(Material.SANDSTONE));
        inventory.setItem(19, new ItemStack(Material.REDSTONE_BLOCK));
        inventory.setItem(20, new ItemStack(Material.GOLD_BLOCK));
        inventory.setItem(21, new ItemStack(Material.REDSTONE_BLOCK));
        inventory.setItem(28, new ItemStack(Material.REDSTONE_BLOCK));
        inventory.setItem(29, new ItemStack(Material.GOLD_BLOCK));
        inventory.setItem(30, new ItemStack(Material.REDSTONE_BLOCK));

        ItemStack itemStack = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW+"Nieskonczone jedzenie");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(45, itemStack);

        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tntmeta = tnt.getItemMeta();
        tntmeta.setDisplayName(ChatColor.RED+"Odpalone TNT");
        tnt.setItemMeta(tntmeta);
        inventory.setItem(46, tnt);

        ItemStack fosa = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta fosameta = fosa.getItemMeta();
        fosameta.setDisplayName(ChatColor.RED+"FosaFarmer");
        fosa.setItemMeta(fosameta);
        inventory.setItem(47, fosa);

        ItemStack boy = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta boymeta = boy.getItemMeta();
        boymeta.setDisplayName(ChatColor.RED+"BoyFarmer");
        boy.setItemMeta(boymeta);
        inventory.setItem(48, boy);

        ItemStack sand = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta sandmeta = sand.getItemMeta();
        sandmeta.setDisplayName(ChatColor.YELLOW+"SandFarmer");
        sandmeta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        sand.setItemMeta(sandmeta);
        inventory.setItem(49, sand);
        inventory.setItem(24, sand);

        ItemStack ender = new ItemStack(Material.ENDER_CHEST);
        ItemMeta endermeta = ender.getItemMeta();
        ender.setItemMeta(endermeta);
        inventory.setItem(50, ender);

        ItemStack stoniarkaplus = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkaplusmeta = stoniarkaplus.getItemMeta();
        stoniarkaplusmeta.setDisplayName(pl.rex89m.mdrop.Stoniarka.Stoniarka.getName()+"+");
        stoniarkaplus.setItemMeta(stoniarkaplusmeta);
        inventory.setItem(51, stoniarkaplus);

        ItemStack stoniarka = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkameta = stoniarka.getItemMeta();
        stoniarkameta.setDisplayName(Stoniarka.getName());
        stoniarka.setItemMeta(stoniarkameta);
        inventory.setItem(52, stoniarka);
        return inventory;
    }

    public static org.bukkit.inventory.Inventory ender(){
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 54, "Crafting ender chest");
        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15));
        }
        inventory.setItem(10, new ItemStack(Material.OBSIDIAN));
        inventory.setItem(11, new ItemStack(Material.OBSIDIAN));
        inventory.setItem(12, new ItemStack(Material.OBSIDIAN));
        inventory.setItem(19, new ItemStack(Material.OBSIDIAN));
        inventory.setItem(20, new ItemStack(Material.ENDER_PEARL));
        inventory.setItem(21, new ItemStack(Material.OBSIDIAN));
        inventory.setItem(28, new ItemStack(Material.OBSIDIAN));
        inventory.setItem(29, new ItemStack(Material.OBSIDIAN));
        inventory.setItem(30, new ItemStack(Material.OBSIDIAN));

        ItemStack itemStack = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW+"Nieskonczone jedzenie");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(45, itemStack);

        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tntmeta = tnt.getItemMeta();
        tntmeta.setDisplayName(ChatColor.RED+"Odpalone TNT");
        tnt.setItemMeta(tntmeta);
        inventory.setItem(46, tnt);

        ItemStack fosa = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta fosameta = fosa.getItemMeta();
        fosameta.setDisplayName(ChatColor.RED+"FosaFarmer");
        fosa.setItemMeta(fosameta);
        inventory.setItem(47, fosa);

        ItemStack boy = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta boymeta = boy.getItemMeta();
        boymeta.setDisplayName(ChatColor.RED+"BoyFarmer");
        boy.setItemMeta(boymeta);
        inventory.setItem(48, boy);

        ItemStack sand = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta sandmeta = sand.getItemMeta();
        sandmeta.setDisplayName(ChatColor.YELLOW+"SandFarmer");
        sand.setItemMeta(sandmeta);
        inventory.setItem(49, sand);

        ItemStack ender = new ItemStack(Material.ENDER_CHEST);
        ItemMeta endermeta = ender.getItemMeta();
        endermeta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        ender.setItemMeta(endermeta);
        inventory.setItem(24, ender);
        inventory.setItem(50, ender);

        ItemStack stoniarkaplus = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkaplusmeta = stoniarkaplus.getItemMeta();
        stoniarkaplusmeta.setDisplayName(pl.rex89m.mdrop.Stoniarka.Stoniarka.getName()+"+");
        stoniarkaplus.setItemMeta(stoniarkaplusmeta);
        inventory.setItem(51, stoniarkaplus);

        ItemStack stoniarka = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkameta = stoniarka.getItemMeta();
        stoniarkameta.setDisplayName(Stoniarka.getName());
        stoniarka.setItemMeta(stoniarkameta);
        inventory.setItem(52, stoniarka);
        return inventory;
    }

    public static org.bukkit.inventory.Inventory stoniarka(){
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 54, "Crafting "+ Stoniarka.getName());
        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15));
        }
        inventory.setItem(10, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(11, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(12, new ItemStack(Material.IRON_INGOT));
        inventory.setItem(19, new ItemStack(Material.REDSTONE));
        inventory.setItem(20, new ItemStack(Material.STONE));
        inventory.setItem(21, new ItemStack(Material.REDSTONE));
        inventory.setItem(28, new ItemStack(Material.REDSTONE));
        inventory.setItem(29, new ItemStack(Material.WOOD));
        inventory.setItem(30, new ItemStack(Material.REDSTONE));

        ItemStack itemStack = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW+"Nieskonczone jedzenie");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(45, itemStack);

        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tntmeta = tnt.getItemMeta();
        tntmeta.setDisplayName(ChatColor.RED+"Odpalone TNT");
        tnt.setItemMeta(tntmeta);
        inventory.setItem(46, tnt);

        ItemStack fosa = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta fosameta = fosa.getItemMeta();
        fosameta.setDisplayName(ChatColor.RED+"FosaFarmer");
        fosa.setItemMeta(fosameta);
        inventory.setItem(47, fosa);

        ItemStack boy = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta boymeta = boy.getItemMeta();
        boymeta.setDisplayName(ChatColor.RED+"BoyFarmer");
        boy.setItemMeta(boymeta);
        inventory.setItem(48, boy);

        ItemStack sand = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta sandmeta = sand.getItemMeta();
        sandmeta.setDisplayName(ChatColor.YELLOW+"SandFarmer");
        sand.setItemMeta(sandmeta);
        inventory.setItem(49, sand);

        ItemStack ender = new ItemStack(Material.ENDER_CHEST);
        ItemMeta endermeta = ender.getItemMeta();
        ender.setItemMeta(endermeta);
        inventory.setItem(24, ender);
        inventory.setItem(50, ender);

        ItemStack stoniarkaplus = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkaplusmeta = stoniarkaplus.getItemMeta();
        stoniarkaplusmeta.setDisplayName(Stoniarka.getName()+"+");
        stoniarkaplus.setItemMeta(stoniarkaplusmeta);
        inventory.setItem(51, stoniarkaplus);

        ItemStack stoniarka = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkameta = stoniarka.getItemMeta();
        stoniarkameta.setDisplayName(Stoniarka.getName());
        stoniarkameta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        stoniarka.setItemMeta(stoniarkameta);
        inventory.setItem(52, stoniarka);
        inventory.setItem(24, stoniarka);
        return inventory;
    }

    public static org.bukkit.inventory.Inventory stoniarkaplus(){
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, 54, "Crafting "+Stoniarka.getName()+"+");
        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15));
        }
        inventory.setItem(10, new ItemStack(Material.IRON_BLOCK));
        inventory.setItem(11, new ItemStack(Material.IRON_BLOCK));
        inventory.setItem(12, new ItemStack(Material.IRON_BLOCK));
        inventory.setItem(19, new ItemStack(Material.REDSTONE_BLOCK));
        inventory.setItem(20, new ItemStack(Material.STONE));
        inventory.setItem(21, new ItemStack(Material.REDSTONE_BLOCK));
        inventory.setItem(28, new ItemStack(Material.REDSTONE_BLOCK));
        inventory.setItem(29, new ItemStack(Material.GOLD_BLOCK));
        inventory.setItem(30, new ItemStack(Material.REDSTONE_BLOCK));

        ItemStack itemStack = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW+"Nieskonczone jedzenie");
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(45, itemStack);

        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tntmeta = tnt.getItemMeta();
        tntmeta.setDisplayName(ChatColor.RED+"Odpalone TNT");
        tnt.setItemMeta(tntmeta);
        inventory.setItem(46, tnt);

        ItemStack fosa = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta fosameta = fosa.getItemMeta();
        fosameta.setDisplayName(ChatColor.RED+"FosaFarmer");
        fosa.setItemMeta(fosameta);
        inventory.setItem(47, fosa);

        ItemStack boy = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta boymeta = boy.getItemMeta();
        boymeta.setDisplayName(ChatColor.RED+"BoyFarmer");
        boy.setItemMeta(boymeta);
        inventory.setItem(48, boy);

        ItemStack sand = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta sandmeta = sand.getItemMeta();
        sandmeta.setDisplayName(ChatColor.YELLOW+"SandFarmer");
        sand.setItemMeta(sandmeta);
        inventory.setItem(49, sand);

        ItemStack ender = new ItemStack(Material.ENDER_CHEST);
        ItemMeta endermeta = ender.getItemMeta();
        ender.setItemMeta(endermeta);
        inventory.setItem(24, ender);
        inventory.setItem(50, ender);

        ItemStack stoniarkaplus = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkaplusmeta = stoniarkaplus.getItemMeta();
        stoniarkaplusmeta.setDisplayName(Stoniarka.getName()+"+");
        stoniarkaplusmeta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        stoniarkaplus.setItemMeta(stoniarkaplusmeta);
        inventory.setItem(51, stoniarkaplus);
        inventory.setItem(24, stoniarkaplus);

        ItemStack stoniarka = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkameta = stoniarka.getItemMeta();
        stoniarkameta.setDisplayName(Stoniarka.getName());
        stoniarka.setItemMeta(stoniarkameta);
        inventory.setItem(52, stoniarka);
        return inventory;
    }

}
