package pl.rex89m.mdrop.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.rex89m.mdrop.MDrop;

import java.util.ArrayList;

public class AddItemCommands implements CommandExecutor {

    public final MDrop plugin;

    public AddItemCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("mdrop.additem")){
            if (args.length>1) {
                if (args.length>2) {
                    if (args.length == 3) {
                        if (args[0].equals("case")) {
                            ItemStack itemStack = ((Player) sender).getItemInHand();
                            ItemMeta itemMeta = itemStack.getItemMeta();
                            ArrayList<String> lista = new ArrayList<>();
                            for (Enchantment i : itemMeta.getEnchants().keySet()) {
                                lista.add(i.getName() + "#" + itemMeta.getEnchants().get(i));
                            }
                            plugin.yml.addItemCase(args[1], itemStack.getType().name(), itemMeta.getDisplayName(), args[2], itemStack.getData().getData(), itemMeta.getLore(), lista);
                        }else {
                            if (args[0].equals("kit")){

                            }
                        }
                    }else{
                        sender.sendMessage("additem kit/case nazwa ilosc");
                    }
                }else{
                    sender.sendMessage("additem kit/case nazwa ilosc");
                }
            }else{
                sender.sendMessage("additem kit/case nazwa ilosc");
            }
        }
        return false;
    }
}
