package pl.flezy.pearltweaks;

import org.bukkit.plugin.java.JavaPlugin;
import pl.flezy.pearltweaks.Commands.PearlTweaksCommand;
import pl.flezy.pearltweaks.Commands.PearlTweaksTabCompleter;
import pl.flezy.pearltweaks.Listener.PearlListener;

public class PearlTweaks extends JavaPlugin {
    public final Config config = new Config(this);

    @Override
    public void onEnable(){
        getCommand("pearltweaks").setExecutor(new PearlTweaksCommand(this));
        getCommand("pearltweaks").setTabCompleter(new PearlTweaksTabCompleter());

        getServer().getPluginManager().registerEvents(new PearlListener(this),this);

        saveDefaultConfig();
        config.reload();
    }
}
