package pl.rex89m.mdrop.Stoniarka.Listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import pl.rex89m.mdrop.MDrop;
import pl.rex89m.mdrop.Stoniarka.Stoniarka;

public class PlaceStoniarka implements Listener {

    public final MDrop plugin;

    public PlaceStoniarka(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        if (!e.isCancelled()) {
            if (e.getBlockPlaced()!=null){
                if (e.getBlockPlaced().getType()== Material.ENDER_STONE){
                    if (e.getItemInHand().getItemMeta().hasDisplayName()){
                        if (e.getItemInHand().getItemMeta().getDisplayName().equals(Stoniarka.getName())){
                            e.getBlock().setType(Material.STONE);
                            plugin.sql.addLocationStoniarka(e.getBlockPlaced().getLocation());
                            e.getPlayer().sendMessage(Stoniarka.getPlaceMessage());
                        }else{
                            if (e.getItemInHand().getItemMeta().getDisplayName().equals(Stoniarka.getName()+"+")){
                                e.getBlock().setType(Material.STONE);
                                plugin.sql.addLocationStoniarkaplus(e.getBlockPlaced().getLocation());
                                e.getPlayer().sendMessage(Stoniarka.getPlaceMessage());
                            }
                        }
                    }
                }
            }
        }
    }
}
