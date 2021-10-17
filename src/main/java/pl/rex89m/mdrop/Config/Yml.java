package pl.rex89m.mdrop.Config;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.rex89m.mdrop.Case.Case;
import pl.rex89m.mdrop.MDrop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Yml {

    private final MDrop plugin;

    public Yml(MDrop plugin) {
        this.plugin = plugin;
        load();
    }

    File file = new File("plugins/MDrop");
    File ymlFille = new File("plugins/MDrop/Config.yml");

    YamlConfiguration configuration = YamlConfiguration.loadConfiguration(ymlFille);

    ConfigurationSection section;


    public void load() {
        if (!file.exists()){
            file.mkdirs();
        }
        if (!ymlFille.exists()){
            try {
                ymlFille.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (configuration.isConfigurationSection("case")){
            section = configuration.getConfigurationSection("case");
        }else{
            section = configuration.createSection("case");
        }
        for (String i :section.getKeys(false)){
            Case configCase = new Case(Integer.parseInt(i), section.getString(i+".name"));
            for (String i2 :section.getStringList(i+".items")){
                String material = section.getString(i+"."+i2+".material");
                ItemStack itemStack = new ItemStack(Material.getMaterial(section.getString(i+"."+i2+".material")), Integer.parseInt(section.getString(i+"."+i2+"."+material+".ilosc")), Short.parseShort(section.getString(i+"."+i2+"."+material+".metadata")));
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setLore(section.getStringList(i+"."+i2+"."+material+".lore"));
                itemStack.setItemMeta(itemMeta);
                configCase.addItem(itemStack);
            }
        }
    }
}
