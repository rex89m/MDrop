package pl.rex89m.mdrop.Config;

import lombok.SneakyThrows;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.rex89m.mdrop.Case.Case;
import pl.rex89m.mdrop.Commands.BanCommands;
import pl.rex89m.mdrop.Commands.KickCommands;
import pl.rex89m.mdrop.Commands.MuteCommands;
import pl.rex89m.mdrop.Commands.WarnCommands;
import pl.rex89m.mdrop.Drop.Drop;
import pl.rex89m.mdrop.Kit.KitInfo;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Stoniarka.Stoniarka;

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

    ConfigurationSection sectionDrop;

    ConfigurationSection sectionkit;

    public void load() {
        if (!ymlFille.exists()){
            plugin.saveDefaultConfig();
        }
        configuration = YamlConfiguration.loadConfiguration(ymlFille);

        if (configuration.isSet("Stoniarka.name")){
            Stoniarka.setName(color(configuration.getString("Stoniarka.name")));
        }else{
            Stoniarka.setName("error name");
        }
        if (configuration.isSet("Settings.kick.message")){
            KickCommands.kickmessage = color(configuration.getString("Settings.kick.message"));
        }else{
            Stoniarka.setName("error kick.message");
        }
        if (configuration.isSet("Settings.warn.message")){
            WarnCommands.warnmessage = color(configuration.getString("Settings.warn.message"));
        }else{
            Stoniarka.setName("error warn.message");
        }
        if (configuration.isSet("Settings.mute.message")){
                MuteCommands.mutemessage = color(configuration.getString("Settings.mute.message"));
        }else{
            Stoniarka.setName("error mute.message");
        }
        if (configuration.isSet("Settings.ban.message")){
            BanCommands.banmessage = color(configuration.getString("Settings.ban.message"));
        }else{
            Stoniarka.setName("error kick.message");
        }
        if (configuration.isSet("Stoniarka.lore")){
            Stoniarka.setLore(color(configuration.getStringList("Stoniarka.lore")));
        }else{
            Stoniarka.setName("error lore");
        }
        if (configuration.isSet("Stoniarka.place_message")){
            Stoniarka.setPlaceMessage(color(configuration.getString("Stoniarka.place_message")));
        }else{
            Stoniarka.setName("error place_message");
        }
        if (configuration.isSet("Stoniarka.break_message")){
            Stoniarka.setBreakMessage(color(configuration.getString("Stoniarka.break_message")));
        }else{
            Stoniarka.setName("error break_message");
        }

        if (configuration.isConfigurationSection("case")){
            section = configuration.getConfigurationSection("case");
        }else{
            section = configuration.createSection("case");
        }
        if (configuration.isConfigurationSection("drop")){
            sectionDrop = configuration.getConfigurationSection("drop");
        }else{
            sectionDrop = configuration.createSection("drop");
        }
        if (configuration.isConfigurationSection("kits")){
            sectionkit = configuration.getConfigurationSection("kits");
        }else{
            sectionkit = configuration.createSection("kits");
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
            if (section.isConfigurationSection(i+".items")) {
                for (String i2 : section.getConfigurationSection(i + ".items").getKeys(false)) {
                    if (section.isSet(i + ".items." + i2 + ".material") && section.isSet(i + ".items." + i2 + ".ilosc") && section.isSet(i + ".items." + i2 + ".metadata")){
                        ItemStack itemStack = new ItemStack(Material.getMaterial(section.getString(i + ".items." + i2 + ".material")), Integer.parseInt(section.getString(i + ".items." + i2 + ".ilosc")), Short.parseShort(section.getString(i + ".items." + i2 + ".metadata")));
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        if (section.isSet(i + ".items." + i2 + ".name")) {
                            itemMeta.setDisplayName(color(section.getString(i + ".items." + i2 + ".name")));
                        }
                        if (section.isSet(i + ".items." + i2 + ".lore")) {
                            itemMeta.setLore(color(section.getStringList(i + ".items." + i2 + ".lore")));
                        }
                        for (String i3 : section.getStringList(i + ".items." + i2 + ".enchants")) {
                            String[] var = i3.split("#");
                            if (var[0].equalsIgnoreCase("GLOW")) {
                                itemMeta.addEnchant(Enchantment.LUCK, 10, false);
                            } else {
                                itemMeta.addEnchant(Enchantment.getByName(var[0]), Integer.parseInt(var[1]), true);
                            }
                        }
                        itemStack.setItemMeta(itemMeta);
                        configCase.addItem(itemStack);
                    }
                }
            }
        }
        for (String i : sectionDrop.getKeys(false)) {
            if (!i.equals("name") && !i.equals("size") && !i.equals("cobble_slot") && !i.equals("cobble_name")) {
                Drop drop = new Drop(color(sectionDrop.getString(i + ".name")), Material.getMaterial(i), Double.parseDouble(sectionDrop.getString(i + ".chance")));
                if (sectionDrop.isSet(i + ".lore")) {
                    drop.setLore(color(sectionDrop.getStringList(i + ".lore")));
                }
                drop.setLoreInventory(color(sectionDrop.getStringList(i + ".inventory_lore")));
                drop.setSlot(sectionDrop.getInt(i + ".inventory_slot"));
            }else{
                Drop.Inventory_name=color(sectionDrop.getString("name"));
                Drop.Inventory_size=sectionDrop.getInt("size");
                Drop.Cobble_slot=sectionDrop.getInt("cobble_slot");
                Drop.Cobble_Name=sectionDrop.getString(color("cobble_name"));
            }
        }
        for (String i : sectionkit.getKeys(false)){
            KitInfo kit = new KitInfo(i);
            if (sectionkit.isSet(i + ".Delay")){
                kit.setDelay(sectionkit.getInt(i + ".Delay"));
            }else{
                kit.setDelay(0);
            }
            if (sectionkit.isSet(i + ".Permission")) {
                kit.setPermission(sectionkit.getString(i + ".Permission"));
            }
            if (sectionkit.isConfigurationSection(i+".items")) {
                for (String i2 : sectionkit.getConfigurationSection(i + ".items").getKeys(false)) {
                    if (sectionkit.isSet(i + ".items." + i2 + ".material") && sectionkit.isSet(i + ".items." + i2 + ".ilosc") && sectionkit.isSet(i + ".items." + i2 + ".metadata")){
                        ItemStack itemStack = new ItemStack(Material.getMaterial(sectionkit.getString(i + ".items." + i2 + ".material")), Integer.parseInt(sectionkit.getString(i + ".items." + i2 + ".ilosc")), Short.parseShort(sectionkit.getString(i + ".items." + i2 + ".metadata")));
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        if (sectionkit.isSet(i + ".items." + i2 + ".name")) {
                            itemMeta.setDisplayName(color(sectionkit.getString(i + ".items." + i2 + ".name")));
                        }
                        if (sectionkit.isSet(i + ".items." + i2 + ".lore")) {
                            itemMeta.setLore(color(sectionkit.getStringList(i + ".items." + i2 + ".lore")));
                        }
                        for (String i3 : sectionkit.getStringList(i + ".items." + i2 + ".enchants")) {
                            String[] var = i3.split("#");
                            if (var[0].equalsIgnoreCase("GLOW")) {
                                itemMeta.addEnchant(Enchantment.LUCK, 10, false);
                            } else {
                                itemMeta.addEnchant(Enchantment.getByName(var[0]), Integer.parseInt(var[1]), true);
                            }
                        }
                        itemStack.setItemMeta(itemMeta);
                        kit.addItem(itemStack);
                    }
                }
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
        return lista;
    }

    @SneakyThrows
    public void addItemCase(String casename, String material, String name, String ilosc, byte data, List<String> lore, ArrayList<String> enchants){
        int i=1;
        if (Case.get(casename).getItems()!=null){
            i = Case.get(casename).getItems().size()+1;
        }
        section.set(casename+".items."+i+".material", material);
        section.set(casename+".items."+i+".name", name);
        section.set(casename+".items."+i+".ilosc", ilosc);
        section.set(casename+".items."+i+".metadata", data);
        section.set(casename+".items."+i+".lore", lore);
        section.set(casename+".items."+i+".enchants", enchants);
        configuration.save(ymlFille);
    }
    @SneakyThrows
    public void addItemKit(String kitname, String material, String name, String ilosc, byte data, List<String> lore, ArrayList<String> enchants){
        int i=1;
        if (KitInfo.get(kitname)!=null) {
            if (KitInfo.get(kitname).getItems() != null) {
                i = KitInfo.get(kitname).getItems().size() + 1;
            }
            sectionkit.set(kitname+".items."+i+".material", material);
            sectionkit.set(kitname+".items."+i+".name", name);
            sectionkit.set(kitname+".items."+i+".ilosc", ilosc);
            sectionkit.set(kitname+".items."+i+".metadata", data);
            sectionkit.set(kitname+".items."+i+".lore", lore);
            sectionkit.set(kitname+".items."+i+".enchants", enchants);
            configuration.save(ymlFille);
            ItemStack itemStack = new ItemStack(Material.getMaterial(material), Integer.parseInt(ilosc), data);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(name);
            itemMeta.setLore(lore);
            for (String i2: enchants){
                String[] var = i2.split("#");
                itemMeta.addEnchant(Enchantment.getByName(var[0]), Integer.parseInt(var[1]), true);
            }
            itemStack.setItemMeta(itemMeta);
            KitInfo.get(kitname).addItem(itemStack);
        }
    }

    @SneakyThrows
    public void createkit(String name, int delay, String permission){
        sectionkit.set(name+".Delay", +delay);
        sectionkit.set(name+".Permission", permission);
        configuration.save(ymlFille);
        KitInfo kit = new KitInfo(name);
        kit.setPermission(permission);
        kit.setDelay(delay);
    }
}
