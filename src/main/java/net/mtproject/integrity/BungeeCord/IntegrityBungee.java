package net.mtproject.integrity.BungeeCord;

import co.aikar.commands.BungeeCommandManager;
import net.md_5.bungee.api.plugin.Plugin;
import net.mtproject.integrity.BungeeCord.Commands.BungeeCommand;
import net.mtproject.integrity.Shared.IntegrityCore;

public class IntegrityBungee extends Plugin {
    private BungeeCommandManager commandManager;
    private IntegrityCore core;

    @Override
    public void onEnable() {
        this.core = new IntegrityCore();

        this.commandManager = new BungeeCommandManager(this);

        commandManager.registerCommand(new BungeeCommand());
    }
}