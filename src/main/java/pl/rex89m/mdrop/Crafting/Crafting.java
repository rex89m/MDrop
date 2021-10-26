package pl.rex89m.mdrop.Crafting;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Stoniarka.Stoniarka;

public class Crafting {

    public final MDrop plugin;

    public Crafting(MDrop plugin) {
        this.plugin = plugin;
        craftingload();
    }

    public void craftingload(){
        ItemStack itemStack = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW+"Nieskonczone jedzenie");
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        itemStack.setItemMeta(itemMeta);
        ShapedRecipe recipe = new ShapedRecipe(itemStack);
        recipe.shape("@@@","@#@","@@@");
        recipe.setIngredient('@', Material.IRON_INGOT);
        recipe.setIngredient('#', Material.COOKED_CHICKEN);
        plugin.getServer().addRecipe(recipe);

        ItemStack tnt = new ItemStack(Material.TNT);
        ItemMeta tntmeta = tnt.getItemMeta();
        tntmeta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        tntmeta.setDisplayName(ChatColor.RED+"Odpalone TNT");
        tnt.setItemMeta(tntmeta);
        ShapedRecipe recipetnt = new ShapedRecipe(tnt);
        recipetnt.shape("%%%","@$@","#@#");
        recipetnt.setIngredient('@', Material.IRON_INGOT);
        recipetnt.setIngredient('#', Material.GOLD_INGOT);
        recipetnt.setIngredient('$', Material.TNT);
        recipetnt.setIngredient('%', Material.GOLD_BLOCK);
        plugin.getServer().addRecipe(recipetnt);

        ItemStack fosa = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta fosameta = fosa.getItemMeta();
        fosameta.setDisplayName(ChatColor.RED+"FosaFarmer");
        fosameta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        fosa.setItemMeta(fosameta);
        ShapedRecipe recipefosa = new ShapedRecipe(fosa);
        recipefosa.shape("%%%","@#@","@#@");
        recipefosa.setIngredient('@', Material.REDSTONE);
        recipefosa.setIngredient('#', Material.GOLD_INGOT);
        recipefosa.setIngredient('%', Material.GLASS);
        plugin.getServer().addRecipe(recipefosa);

        ItemStack boy = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta boymeta = boy.getItemMeta();
        boymeta.setDisplayName(ChatColor.RED+"BoyFarmer");
        boymeta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        boy.setItemMeta(boymeta);
        ShapedRecipe recipeboy = new ShapedRecipe(boy);
        recipeboy.shape("%%%","@#@","@#@");
        recipeboy.setIngredient('@', Material.REDSTONE);
        recipeboy.setIngredient('#', Material.GOLD_INGOT);
        recipeboy.setIngredient('%', Material.OBSIDIAN);
        plugin.getServer().addRecipe(recipeboy);

        ItemStack sand = new ItemStack(Material.ENDER_PORTAL_FRAME);
        ItemMeta sandmeta = sand.getItemMeta();
        sandmeta.setDisplayName(ChatColor.YELLOW+"SandFarmer");
        sandmeta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        sand.setItemMeta(sandmeta);
        ShapedRecipe recipesand = new ShapedRecipe(sand);
        recipesand.shape("%%%","@#@","@#@");
        recipesand.setIngredient('@', Material.REDSTONE_BLOCK);
        recipesand.setIngredient('#', Material.GOLD_BLOCK);
        recipesand.setIngredient('%', Material.SANDSTONE);
        plugin.getServer().addRecipe(recipesand);

        ItemStack ender = new ItemStack(Material.ENDER_CHEST);
        ItemMeta endermeta = ender.getItemMeta();
        endermeta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        ender.setItemMeta(endermeta);
        ShapedRecipe recipeender = new ShapedRecipe(ender);
        recipeender.shape("@@@","@#@","@@@");
        recipeender.setIngredient('@', Material.OBSIDIAN);
        recipeender.setIngredient('#', Material.ENDER_PEARL);
        plugin.getServer().addRecipe(recipeender);

        ItemStack stoniarkaplus = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkaplusmeta = stoniarkaplus.getItemMeta();
        stoniarkaplusmeta.setDisplayName(Stoniarka.getName()+"+");
        stoniarkaplusmeta.setLore(Stoniarka.getLore());
        stoniarkaplusmeta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        stoniarkaplus.setItemMeta(stoniarkaplusmeta);
        ShapedRecipe recipestoniarkaplus = new ShapedRecipe(stoniarkaplus);
        recipestoniarkaplus.shape("@@@","!#!","!$!");
        recipestoniarkaplus.setIngredient('!', Material.REDSTONE_BLOCK);
        recipestoniarkaplus.setIngredient('@', Material.IRON_BLOCK);
        recipestoniarkaplus.setIngredient('#', Material.STONE);
        recipestoniarkaplus.setIngredient('$', Material.GOLD_BLOCK);
        plugin.getServer().addRecipe(recipestoniarkaplus);

        ItemStack stoniarka = new ItemStack(Material.ENDER_STONE);
        ItemMeta stoniarkameta = stoniarka.getItemMeta();
        stoniarkameta.setDisplayName(Stoniarka.getName());
        stoniarkameta.setLore(Stoniarka.getLore());
        stoniarkameta.addEnchant(Enchantment.ARROW_DAMAGE, 10,false);
        stoniarka.setItemMeta(stoniarkameta);
        ShapedRecipe recipestoniarka = new ShapedRecipe(stoniarka);
        recipestoniarka.shape("!!!","@#@","@$@");
        recipestoniarka.setIngredient('!', Material.IRON_INGOT);
        recipestoniarka.setIngredient('@', Material.REDSTONE);
        recipestoniarka.setIngredient('#', Material.STONE);
        recipestoniarka.setIngredient('$', Material.WOOD);
        plugin.getServer().addRecipe(recipestoniarka);






    }
}
