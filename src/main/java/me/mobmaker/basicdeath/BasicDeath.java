package me.mobmaker.basicdeath;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class BasicDeath extends JavaPlugin {

    public static NamespacedKey deathKey;
    public static BasicDeath plugin;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new InvulnerabilityEvents(), this);
        deathKey = new NamespacedKey(this, "deathstart");
        plugin = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
