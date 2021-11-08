package pl.rex89m.mdrop;

import lombok.SneakyThrows;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import pl.rex89m.mdrop.AntyLog.AntyLogListener;
import pl.rex89m.mdrop.AntyLog.Every;
import pl.rex89m.mdrop.Ban.EventJoinBan;
import pl.rex89m.mdrop.Baza.SQL;
import pl.rex89m.mdrop.Case.CaseOpen;
import pl.rex89m.mdrop.Case.Listener.CaseClick;
import pl.rex89m.mdrop.Case.Listener.UseChest;
import pl.rex89m.mdrop.Commands.*;
import pl.rex89m.mdrop.Config.Yml;
import pl.rex89m.mdrop.Crafting.Crafting;
import pl.rex89m.mdrop.Crafting.Listener.Events;
import pl.rex89m.mdrop.Crafting.Listener.InventoryCraftingClick;
import pl.rex89m.mdrop.Drop.Listener.DropEvent;
import pl.rex89m.mdrop.Drop.Listener.InventoryClick;
import pl.rex89m.mdrop.Events.Chat;
import pl.rex89m.mdrop.Events.Join;
import pl.rex89m.mdrop.Stoniarka.Listener.BreakStoniarka;
import pl.rex89m.mdrop.Stoniarka.Listener.PlaceStoniarka;
import pl.rex89m.mdrop.Mute.EventChatMute;
import pl.rex89m.mdrop.Void.EventVoid;
import pl.rex89m.mdrop.Void.VoidGui;

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
    public final AddItemCommands addItemCommands;
    public final Crafting crafting;
    public final Events events;
    public final CraftingCommands craftingCommands;
    public final InventoryCraftingClick craftingClick;
    public final KickCommands kickCommands;
    public final BanCommands banCommands;
    public final WarnCommands warnCommands;
    public final EventJoinBan eventJoinBan;
    public final EventChatMute eventChatMute;
    public final MuteCommands muteCommands;
    public final UnMuteCommands unMuteCommands;
    public final UnBanCommands unBanCommands;
    public final VoidGui voidGui;
    public final EventVoid eventVoid;
    public final VoidCommands voidCommands;
    public final CreateKitCommands createKitCommands;
    public final TempBanCommands tempBanCommands;

    public LuckPerms luckPerms;

    public MDrop(){
        this.caseOpen= new CaseOpen(this);
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
        this.addItemCommands = new AddItemCommands(this);
        this.crafting = new Crafting(this);
        this.events = new Events(this);
        this.craftingCommands = new CraftingCommands(this);
        this.craftingClick = new InventoryCraftingClick(this);
        this.kickCommands = new KickCommands(this);
        this.banCommands = new BanCommands(this);
        this.warnCommands = new WarnCommands(this);
        this.eventJoinBan= new EventJoinBan(this);
        this.eventChatMute= new EventChatMute(this);
        this.muteCommands= new MuteCommands(this);
        this.unBanCommands= new UnBanCommands(this);
        this.unMuteCommands= new UnMuteCommands(this);
        this.voidGui= new VoidGui(this);
        this.eventVoid= new EventVoid(this);
        this.voidCommands= new VoidCommands(this);
        this.createKitCommands= new CreateKitCommands(this);
        this.tempBanCommands= new TempBanCommands(this);

        this.yml= new Yml(this);
    }

    @SneakyThrows
    @Override
    public void onEnable() {
        getCommand("open").setExecutor(new Open(this));
        getCommand("case").setExecutor(new CaseCommands());
        getCommand("topcase").setExecutor(new TopCommands(this));
        getCommand("stoniarka").setExecutor(new Stoniarka());
        getCommand("drop").setExecutor(new DropCommands());
        getCommand("efekty").setExecutor(new EffectCommands());
        getCommand("kit").setExecutor(new KitCommands(this));
        getCommand("additem").setExecutor(new AddItemCommands(this));
        getCommand("crafting").setExecutor(new CraftingCommands(this));
        getCommand("kick").setExecutor(new KickCommands(this));
        getCommand("ban").setExecutor(new BanCommands(this));
        getCommand("warn").setExecutor(new WarnCommands(this));
        getCommand("mute").setExecutor(new MuteCommands(this));
        getCommand("unban").setExecutor(new UnBanCommands(this));
        getCommand("unmute").setExecutor(new UnMuteCommands(this));
        getCommand("otchlan").setExecutor(new VoidCommands(this));
        getCommand("createkit").setExecutor(new CreateKitCommands(this));
        getCommand("tempban").setExecutor(new TempBanCommands(this));


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
        getServer().getPluginManager().registerEvents(events, this);
        getServer().getPluginManager().registerEvents(craftingClick, this);
        getServer().getPluginManager().registerEvents(eventChatMute, this);
        getServer().getPluginManager().registerEvents(eventJoinBan, this);
        getServer().getPluginManager().registerEvents(eventVoid, this);

        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        luckPerms=provider.getProvider();

        pl.rex89m.mdrop.Stoniarka.Stoniarka.setIsStoniarka(sql.getAllStoniarka());
        pl.rex89m.mdrop.Stoniarka.Stoniarka.setIsStoniarka(sql.getAllStoniarkaplus(), true);

        for (Player i: Bukkit.getOnlinePlayers()){
            join.load(i);
        }
        every.every();
    }
}
