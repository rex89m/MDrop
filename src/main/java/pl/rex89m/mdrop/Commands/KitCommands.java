package pl.rex89m.mdrop.Commands;

import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pl.rex89m.mdrop.Kit.KitInfo;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Player.PlayerSettings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class KitCommands implements CommandExecutor {

    public final MDrop plugin;

    public KitCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    @SneakyThrows
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length==1){
            for (String i: KitInfo.allkits){
                if (i.equals(args[0])){
                    System.out.println(PlayerSettings.get(((Player)sender).getUniqueId()).getKits().size());
                    if (new Date().after(PlayerSettings.get(((Player)sender).getUniqueId()).getKits().get(args[0]))) {
                        KitInfo kit = KitInfo.get(i);
                        if (sender.hasPermission(kit.getPermission())) {
                            Inventory inventory = Bukkit.createInventory((InventoryHolder) sender, 9 * 3, ChatColor.BLUE + args[0]);
                            for (ItemStack i3 : kit.getItems()) {
                                inventory.addItem(i3);
                            }
                            ((Player) sender).openInventory(inventory);
                            Calendar c = Calendar.getInstance();
                            c.add(Calendar.SECOND, kit.getDelay());
                            plugin.sql.updateSettingsKitDelay((Player) sender, args[0], c.getTime());
                            return false;
                        }
                    }else{
                        Date date2 = PlayerSettings.get(((Player)sender).getUniqueId()).getKits().get(args[0]);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        sender.sendMessage(ChatColor.AQUA+"Odnawi się: "+simpleDateFormat.format(date2));
                    }
                }
            }
        }else{
            sender.sendMessage(ChatColor.GREEN+"Lista:");
            for (String i: KitInfo.allkits){
                KitInfo kit = KitInfo.get(i);
                if (sender.hasPermission(kit.getPermission())){
                    sender.sendMessage(kit.getName());
                }
            }
        }


        return false;
    }
}
