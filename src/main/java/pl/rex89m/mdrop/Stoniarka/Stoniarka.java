package pl.rex89m.mdrop.Stoniarka;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.List;

public class Stoniarka {

    public static String name;

    public static List<String> lore;

    private static HashMap<Location, Boolean> isStoniarka;

    private static String placeMessage;

    private static String breakMessage;

    public static String getPlaceMessage() {
        return placeMessage;
    }

    public static void setPlaceMessage(String placeMessage) {
        Stoniarka.placeMessage = placeMessage;
    }

    public static String getBreakMessage() {
        return breakMessage;
    }

    public static void setBreakMessage(String breakMessage) {
        Stoniarka.breakMessage = breakMessage;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Stoniarka.name = name;
    }

    public static List<String> getLore() {
        return lore;
    }

    public static void setLore(List<String> lore) {
        Stoniarka.lore = lore;
    }

    public static Boolean isStoniarka(Location location) {
        return isStoniarka.get(location);
    }

    public static void addLocation(Location location){
        if (isStoniarka==null){
            isStoniarka=new HashMap<>();
        }
        isStoniarka.put(location, true);
    }

    public static void setIsStoniarka(HashMap<Location, Boolean> isStoniarka) {
        Stoniarka.isStoniarka = isStoniarka;
    }
}
