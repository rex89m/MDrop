package pl.rex89m.mdrop;

import org.bukkit.plugin.java.JavaPlugin;
import pl.rex89m.mdrop.Baza.SQL;
import pl.rex89m.mdrop.Case.CaseOpen;
import pl.rex89m.mdrop.Case.Listener.CaseClick;
import pl.rex89m.mdrop.Case.Listener.UseChest;
import pl.rex89m.mdrop.Commands.CaseCommands;
import pl.rex89m.mdrop.Commands.Open;
import pl.rex89m.mdrop.Config.Yml;

public final class MDrop extends JavaPlugin {

    public final CaseOpen caseOpen;
    public final Yml yml;
    public final Open open;
    public final CaseClick caseClick;
    public final UseChest useChest;
    public final SQL sql;


    public MDrop(){
        this.caseOpen= new CaseOpen(this);
        this.yml= new Yml(this);
        this.open= new Open(this);
        this.caseClick= new CaseClick(this);
        this.useChest= new UseChest(this);
        this.sql= new SQL(this);

    }


    @Override
    public void onEnable() {
        getCommand("open").setExecutor(new Open(this));
        getCommand("case").setExecutor(new CaseCommands());
        getServer().getPluginManager().registerEvents(caseClick, this);
        getServer().getPluginManager().registerEvents(useChest, this);

    }

    @Override
    public void onDisable() {
    }
}
