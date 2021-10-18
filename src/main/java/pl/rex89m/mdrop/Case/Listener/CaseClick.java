package pl.rex89m.mdrop.Case.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.rex89m.mdrop.Case.Case;
import pl.rex89m.mdrop.MDrop;

public class CaseClick implements Listener {

    public final MDrop plugin;

    public CaseClick(MDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (e.getWhoClicked().getOpenInventory()!=null) {
            for (String i : Case.getAllID()) {
                if (e.getWhoClicked().getOpenInventory().getTitle().equals(Case.get(i).getName())) {
                    e.setCancelled(true);
                    break;
                }
            }
        }
    }
}
