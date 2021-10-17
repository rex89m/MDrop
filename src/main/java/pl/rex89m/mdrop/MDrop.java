package pl.rex89m.mdrop;

import org.bukkit.plugin.java.JavaPlugin;
import pl.rex89m.mdrop.Case.CaseOpen;
import pl.rex89m.mdrop.Config.Yml;

public final class MDrop extends JavaPlugin {

    final CaseOpen caseOpen;
    final Yml yml;


    public MDrop(){
        this.caseOpen= new CaseOpen(this);
        this.yml= new Yml(this);
    }


    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {
    }
}
