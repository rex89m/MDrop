package pl.rex89m.mdrop;

import com.earth2me.essentials.Essentials;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import pl.rex89m.mdrop.AntyLog.AntyLogListener;
import pl.rex89m.mdrop.AntyLog.Every;
import pl.rex89m.mdrop.Baza.SQL;
import pl.rex89m.mdrop.Case.CaseOpen;
import pl.rex89m.mdrop.Case.Listener.CaseClick;
import pl.rex89m.mdrop.Case.Listener.UseChest;
import pl.rex89m.mdrop.Commands.*;
import pl.rex89m.mdrop.Config.Yml;
import pl.rex89m.mdrop.Drop.Listener.DropEvent;
import pl.rex89m.mdrop.Drop.Listener.InventoryClick;
import pl.rex89m.mdrop.Events.Chat;
import pl.rex89m.mdrop.Events.Join;
import pl.rex89m.mdrop.Stoniarka.Listener.BreakStoniarka;
import pl.rex89m.mdrop.Stoniarka.Listener.PlaceStoniarka;

public final class MDrop extends JavaPlugin {

    public final CaseOpen caseOpen;
    public final Yml yml;
    public final Open open;
    public final CaseClick caseClick;
    public final UseChest useChest;
    public final SQL sql;
    public final Join join;
    public final TopCommands topCommands;
    public final PlaceStoniarka placeStoniarka;
    public final BreakStoniarka breakStoniarka;
    public final DropEvent dropEvent;
    public final InventoryClick inventoryClick;
    public final AntyLogListener antyLogListener;
    public final Every every;
    public final Effekty effekty;
    public final KitCommands kitCommands;
    public final Chat chat;
    public LuckPerms luckPerms;
    public MDrop(){
        this.caseOpen= new CaseOpen(this);
        this.yml= new Yml(this);
        this.open= new Open(this);
        this.caseClick= new CaseClick(this);
        this.useChest= new UseChest(this);
        this.sql= new SQL(this);
        this.join= new Join(this);
        this.topCommands= new TopCommands(this);
        this.placeStoniarka= new PlaceStoniarka(this);
        this.breakStoniarka= new BreakStoniarka(this);
        this.dropEvent= new DropEvent(this);
        this.inventoryClick= new InventoryClick(this);
        this.antyLogListener= new AntyLogListener(this);
        this.every= new Every(this);
        this.effekty = new Effekty(this);
        this.kitCommands = new KitCommands(this);
        this.chat = new Chat(this);
    }

    @Override
    public void onEnable() {
        getCommand("open").setExecutor(new Open(this));
        getCommand("case").setExecutor(new CaseCommands());
        getCommand("topcase").setExecutor(new TopCommands(this));
        getCommand("stoniarka").setExecutor(new Stoniarka());
        getCommand("drop").setExecutor(new DropCommands());
        getCommand("efekty").setExecutor(new EffectCommands());
        getCommand("kit").setExecutor(new KitCommands(this));

        getServer().getPluginManager().registerEvents(caseClick, this);
        getServer().getPluginManager().registerEvents(useChest, this);
        getServer().getPluginManager().registerEvents(join, this);
        getServer().getPluginManager().registerEvents(placeStoniarka, this);
        getServer().getPluginManager().registerEvents(breakStoniarka, this);
        getServer().getPluginManager().registerEvents(dropEvent, this);
        getServer().getPluginManager().registerEvents(inventoryClick, this);
        getServer().getPluginManager().registerEvents(antyLogListener, this);
        getServer().getPluginManager().registerEvents(effekty, this);
        getServer().getPluginManager().registerEvents(chat, this);
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        luckPerms=provider.getProvider();

        pl.rex89m.mdrop.Stoniarka.Stoniarka.setIsStoniarka(sql.getAllStoniarka());

        for (Player i: Bukkit.getOnlinePlayers()){
            join.load(i);
        }
        every.every();
        ess = (Essentials) Essentials.getProvidingPlugin(Essentials.class);
    }

    public static Essentials ess;


}
