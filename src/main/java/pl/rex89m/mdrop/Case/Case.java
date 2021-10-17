package pl.rex89m.mdrop.Case;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class Case {

    int id;

    String name;

    ArrayList<ItemStack> items;

    ArrayList<String> lore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    private static HashMap<Integer, Case> save = new HashMap<>();

    public Case(int id, String name){
        this.id=id;
        this.name=name;
        save.put(id, this);
    }

    public static Case get(int id){
        return save.get(id);
    }

}
