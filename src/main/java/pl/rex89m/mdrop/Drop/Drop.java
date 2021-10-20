package pl.rex89m.mdrop.Drop;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.List;

public class Drop {

    public static String Inventory_name;

    public static int Inventory_size;

    private String name;

    private Material item;

    private List<String> lore;

    private int slot;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public List<String> getLoreInventory() {
        return loreInventory;
    }

    public void setLoreInventory(List<String> loreInventory) {
        this.loreInventory = loreInventory;
    }

    private List<String> loreInventory;

    private Double chance;

    private static HashMap<Material, Drop> save = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getItem() {
        return item;
    }

    public void setItem(Material item) {
        this.item = item;
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public Double getChance() {
        return chance;
    }

    public void setChance(Double chance) {
        this.chance = chance;
    }

    public Drop(String name, Material item, Double chance){
        this.name=name;
        this.item=item;
        this.chance=chance;
        save.put(item, this);
    }

    public static Drop getDrop(Material item){
        return save.get(item);
    }
    public static HashMap<Material, Drop> getDrop(){
        return save;
    }
}

