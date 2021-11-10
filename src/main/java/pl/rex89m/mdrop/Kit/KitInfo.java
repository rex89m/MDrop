package pl.rex89m.mdrop.Kit;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class KitInfo {

    private String name;

    private ArrayList<ItemStack> items;

    private int delay;

    private String permission;

    public KitInfo(String name) {
        this.name = name;
        allkits.add(name);
        save.put(name, this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ItemStack> getItems(){
        if (items==null){
            items = new ArrayList<>();
        }
        return items;
    }

    public void addItem(ItemStack itemStack){
        if (items==null){
            items = new ArrayList<>();
        }
        items.add(itemStack);
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public String getPermission() {
        if (permission==null){
            return "";
        }
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    private static HashMap<String, KitInfo> save = new HashMap<>();

    public static ArrayList<String> allkits = new ArrayList<>();

    public static KitInfo get(String key){
        return save.get(key);
    }

}
