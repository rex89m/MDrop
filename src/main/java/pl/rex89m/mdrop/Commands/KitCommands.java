package pl.rex89m.mdrop.Commands;

import com.earth2me.essentials.*;
import com.earth2me.essentials.commands.NoChargeException;
import com.earth2me.essentials.libs.snakeyaml.external.biz.base64Coder.Base64Coder;
import com.earth2me.essentials.textreader.IText;
import com.earth2me.essentials.textreader.KeywordReplacer;
import com.earth2me.essentials.textreader.SimpleTextInput;
import com.earth2me.essentials.utils.DateUtil;
import lombok.SneakyThrows;
import net.ess3.api.events.KitClaimEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import pl.rex89m.mdrop.MDrop;

import java.util.Iterator;
import java.util.logging.Level;

public class KitCommands implements CommandExecutor {

    public final MDrop plugin;

    public KitCommands(MDrop plugin) {
        this.plugin = plugin;
    }

    @SneakyThrows
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length==1) {
            if (MDrop.ess.getKits().getKit(args[0]) != null) {
                Kit kit = new Kit(args[0], MDrop.ess);
                User user = MDrop.ess.getUser(sender);
                IText input = new SimpleTextInput(kit.getItems());
                IText output = new KeywordReplacer(input, user.getSource(), MDrop.ess, true, true);
                KitClaimEvent event = new KitClaimEvent(user, kit);
                Bukkit.getPluginManager().callEvent(event);
                if (event.isCancelled()) {
                    return false;
                }else {
                    if (!user.isAuthorized("mdrop.kit." + args[0])) {
                        user.sendMessage(I18n.tl("noKitPermission", new Object[]{args[0]}));
                        return false;
                    }
                    if (!user.getBase().hasPermission("mdrop.kit.nodelay")) {
                        long nextUse = kit.getNextUse(user);
                        if (nextUse != 0L) {
                            if (nextUse < 0L) {
                                user.sendMessage(I18n.tl("kitOnce", new Object[0]));
                                return false;
                            } else {
                                user.sendMessage(I18n.tl("kitTimed", new Object[]{DateUtil.formatDateDiff(nextUse)}));
                                return false;
                            }
                        }
                        kit.setTime(user);
                    }
                    Inventory inventory = Bukkit.createInventory((InventoryHolder) sender, 9 * 4, ChatColor.translateAlternateColorCodes('&', "&5Kit: " + args[0]));
                    Iterator var13 = output.getLines().iterator();
                    ItemStack itemStack;
                    while (var13.hasNext()) {
                        String kitItem = (String) var13.next();
                        ItemStack stack;
                        if (kitItem.startsWith("@")) {
                            if (MDrop.ess.getSerializationProvider() == null) {
                                MDrop.ess.getLogger().log(Level.WARNING, I18n.tl("kitError3", new Object[]{args[0], user.getName()}));
                                continue;
                            }

                            stack = MDrop.ess.getSerializationProvider().deserializeItem(Base64Coder.decodeLines(kitItem.substring(1)));
                        } else {
                            String[] parts = kitItem.split(" +");
                            itemStack = MDrop.ess.getItemDb().get(parts[0], parts.length > 1 ? Integer.parseInt(parts[1]) : 1);
                            if (itemStack.getType() == Material.AIR) {
                                continue;
                            }

                            MetaItemStack metaStack = new MetaItemStack(itemStack);
                            if (parts.length > 2) {
                                metaStack.parseStringMeta((CommandSource) null, true, parts, 2, MDrop.ess);
                            }

                            stack = metaStack.getItemStack();
                            inventory.addItem(itemStack);
                        }

                    }


                    //MDrop.ess.getSerializationProvider().deserializeItem();
                    //InventoryWorkaround.addItems(user.getBase().getInventory(), (ItemStack[])kit.getItems().toArray(new ItemStack[0]));
                    user.getBase().openInventory(inventory);
                }
            }
        }
        return false;
    }
}
