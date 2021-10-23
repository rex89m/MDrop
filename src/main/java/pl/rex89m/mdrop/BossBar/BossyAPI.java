package pl.rex89m.mdrop.BossBar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class BossyAPI {
    private static Plugin plugin;
    private static Bossy instance;

    static {
        plugin = Bukkit.getPluginManager().getPlugins()[0];
    }

    public static void init(Plugin newPlugin) {
        plugin = newPlugin;
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public static Bossy getInstance() {
        if (instance == null)
            instance = new Bossy(plugin);
        return instance;
    }

    public static void show(Player player) {
        getInstance().show(player);
    }

    public void hide(Player player) {
        getInstance().hide(player);
    }

    public void setText(Player player, String text) {
        getInstance().setText(player, text);
    }

    public void setPercent(Player player, float percent) {
        getInstance().setPercent(player, percent);
    }

    public void set(Player player, String text, float percent) {
        getInstance().set(player, text, percent);
    }
}
