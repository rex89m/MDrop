package pl.rex89m.mdrop.Stoniarka;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.List;

public class Stoniarka {

    public static String name;

    public static List<String> lore;

    private static HashMap<Location, Boolean> isStoniarka;

    private static HashMap<Location, Boolean> isStoniarkaplus;

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
    public static void removeStoniarka(Location location){
        if (isStoniarka.containsKey(location)) {
            isStoniarka.remove(location);
        }
    }
    public static void removeStoniarka(Location location, boolean plus){
        if (plus){
            if (isStoniarkaplus.containsKey(location)) {
                isStoniarkaplus.remove(location);
            }
        }else {
            if (isStoniarka.containsKey(location)) {
                isStoniarka.remove(location);
            }
        }
    }


    public static Boolean isStoniarka(Location location) {
        if (isStoniarka.containsKey(location)) {
            return isStoniarka.get(location);
        }else{
            return false;
        }
    }
    public static Boolean isStoniarka(Location location, boolean plus) {
        if (plus){
            if (isStoniarkaplus.containsKey(location)) {
                return isStoniarkaplus.get(location);
            }else{
                return false;
            }
        }else {
            if (isStoniarka.containsKey(location)) {
                return isStoniarka.get(location);
            }else{
                return false;
            }
        }
    }


    public static void addLocation(Location location, boolean plus){
        if (plus) {
            if (isStoniarkaplus == null) {
                isStoniarkaplus = new HashMap<>();
            }
            isStoniarkaplus.put(location,true);
        }else {
            if (isStoniarka==null){
                isStoniarka=new HashMap<>();
            }
            isStoniarka.put(location, true);
        }
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

    public static void setIsStoniarka(HashMap<Location, Boolean> isStoniarka, boolean plus) {
        if (plus){
            Stoniarka.isStoniarkaplus = isStoniarka;
        }else {
            Stoniarka.isStoniarka = isStoniarka;
        }
    }


}
