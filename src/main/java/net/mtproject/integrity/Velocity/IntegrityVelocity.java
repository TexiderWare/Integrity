package net.mtproject.integrity.Velocity;

import co.aikar.commands.VelocityCommandManager;
import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import net.mtproject.integrity.Shared.IntegrityCore;
import net.mtproject.integrity.Velocity.Commands.VelocityCommand;

@Plugin(
        id = "integrity",
        name = "Integrity",
        version = "0.1",
        authors = {"MTProject Industries Dev Team"}
)
public class IntegrityVelocity {
    private final ProxyServer server;
    private VelocityCommandManager commandManager;
    private IntegrityCore core;

    @Inject
    public IntegrityVelocity(ProxyServer server) {
        this.server = server;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        this.core = new IntegrityCore();

        this.commandManager = new VelocityCommandManager(server, this);

        commandManager.registerCommand(new VelocityCommand());
    }
}