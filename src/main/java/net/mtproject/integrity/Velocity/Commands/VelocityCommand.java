package net.mtproject.integrity.Velocity.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.velocitypowered.api.command.CommandSource;
import net.mtproject.integrity.Shared.Utils.ChatColorUtil;

@CommandAlias("integrity|int")
public class VelocityCommand extends BaseCommand {

    @Subcommand("version")
    @CommandPermission("integrity.version")
    @Description("Shows the plugin version")
    public void onVersion(CommandSource sender) {
        sender.sendMessage(ChatColorUtil.colorVelocity("&6Integrity &ev0.1"));
    }

    @Subcommand("reload")
    @CommandPermission("integrity.reload")
    @Description("Reloads the plugin configuration")
    public void onReload(CommandSource sender) {
        sender.sendMessage(ChatColorUtil.colorVelocity("&aConfiguration reloaded!"));
    }

    @Default
    @CatchUnknown
    public void onDefault(CommandSource sender) {
        sender.sendMessage(ChatColorUtil.colorVelocity("&6=== &eIntegrity Help &6==="));
        sender.sendMessage(ChatColorUtil.colorVelocity("&e/integrity version &7- Shows plugin version"));
        sender.sendMessage(ChatColorUtil.colorVelocity("&e/integrity reload &7- Reloads configuration"));
    }
}