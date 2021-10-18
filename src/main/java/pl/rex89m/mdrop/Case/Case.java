package pl.rex89m.mdrop.Case;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class Case {

    private String id;

    private String name;

    private ArrayList<ItemStack> items;

    private ArrayList<String> lore;

    private ItemStack chest;

    private ItemStack key;

    public ItemStack getChest() {
        return chest;
    }

    public void setChest(ItemStack chest) {
        this.chest = chest;
    }

    public ItemStack getKey() {
        return key;
    }

    public void setKey(ItemStack key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ItemStack> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemStack> items) {
        this.items = items;
    }

    public ArrayList<String> getLore() {
        return lore;
    }

    public void setLore(ArrayList<String> lore) {
        this.lore = lore;
    }

    public void addItem(ItemStack itemStack){
        if (items==null){
            items = new ArrayList<>();
        }
        items.add(itemStack);
    }

    private static HashMap<String, Case> save = new HashMap<>();
    private static ArrayList<String> idall = new ArrayList<>();


    public Case(String id, String name){
        if (!idall.equals(id)){
            idall.add(id);
        }
        this.id=id;
        this.name=name;
        save.put(id, this);
    }

    public static Case get(String id){
        return save.get(id);
    }

    public static ArrayList<String> getAllID(){
        return idall;
    }

}
