package net.mtproject.integrity.Bukkit;

import co.aikar.commands.PaperCommandManager;
import net.mtproject.integrity.Bukkit.Commands.BukkitCommand;
import org.bukkit.plugin.java.JavaPlugin;
import net.mtproject.integrity.Shared.IntegrityCore;

public class IntegrityBukkit extends JavaPlugin {
    private PaperCommandManager commandManager;
    private IntegrityCore core;

    @Override
    public void onEnable() {
        // Core'u başlat
        this.core = new IntegrityCore();

        // ACF'yi başlat
        this.commandManager = new PaperCommandManager(this);

        // Komutları kaydet
        commandManager.registerCommand(new BukkitCommand());
    }
}
