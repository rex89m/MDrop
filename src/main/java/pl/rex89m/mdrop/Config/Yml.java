package pl.rex89m.mdrop.Config;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.rex89m.mdrop.Case.Case;
import pl.rex89m.mdrop.MDrop;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Yml {

    public final MDrop plugin;

    public Yml(MDrop plugin) {
        this.plugin = plugin;
        load();
    }

    File ymlFille = new File("plugins/MDrop/config.yml");

    YamlConfiguration configuration;

    ConfigurationSection section;

    public void load() {
        if (!ymlFille.exists()){
            plugin.saveDefaultConfig();
        }
        configuration = YamlConfiguration.loadConfiguration(ymlFille);
        if (configuration.isConfigurationSection("case")){
            section = configuration.getConfigurationSection("case");
        }else{
            section = configuration.createSection("case");
        }
        for (String i :section.getKeys(false)){
            Case configCase = new Case(i, color(section.getString(i+".name_Inventory")));
            ItemStack itemStackChest = new ItemStack(Material.getMaterial(section.getString(i+".material_chest")));
            ItemMeta itemMetaChest = itemStackChest.getItemMeta();
            itemMetaChest.setDisplayName(color(section.getString(i+".name_chest")));
            itemMetaChest.setLore(color(section.getStringList(i+".lore_chest")));
            itemStackChest.setItemMeta(itemMetaChest);
            configCase.setChest(itemStackChest);
            ItemStack itemStackkey= new ItemStack(Material.TRIPWIRE_HOOK);
            ItemMeta itemMetakey = itemStackkey.getItemMeta();
            itemMetakey.setDisplayName(color(section.getString(i+".name_key")));
            itemMetakey.setLore(color(section.getStringList(i+".lore_key")));
            itemStackkey.setItemMeta(itemMetakey);
            configCase.setKey(itemStackkey);
            for (String i2 :section.getConfigurationSection(i+".items").getKeys(false)){
                ItemStack itemStack = new ItemStack(Material.getMaterial(i2), Integer.parseInt(section.getString(i+".items."+i2+".ilosc")), Short.parseShort(section.getString(i+".items."+i2+".metadata")));
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(color(section.getString(i+".items."+i2+".name")));
                itemMeta.setLore(color(section.getStringList(i+".items."+i2+".lore")));
                for (String i3: section.getStringList(i+".items."+i2+".enchants")) {
                    String[] var = i3.split("#");
                    if (var[0].equalsIgnoreCase("GLOW")){
                        itemMeta.addEnchant(Enchantment.LUCK, 10, false);
                    }else{
                        itemMeta.addEnchant(Enchantment.getByName(var[0]), Integer.parseInt(var[1]), true);
                    }
                }
                itemStack.setItemMeta(itemMeta);
                configCase.addItem(itemStack);
            }
        }
    }

    public String color(String s){
        return ChatColor.translateAlternateColorCodes('&',s);
    }
    public List<String> color(List<String> s){
        List<String> lista = new ArrayList<>();
        for (String i: s){
            lista.add(ChatColor.translateAlternateColorCodes('&',i));
        }
        System.out.println(lista);
        return lista;
    }
}
