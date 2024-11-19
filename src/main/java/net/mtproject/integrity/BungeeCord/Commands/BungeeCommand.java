package net.mtproject.integrity.BungeeCord.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import net.md_5.bungee.api.CommandSender;
import net.mtproject.integrity.Shared.Utils.ChatColorUtil;

@CommandAlias("integrity|int")
public class BungeeCommand extends BaseCommand {

    @Subcommand("version|ver")
    @CommandPermission("integrity.version")
    @Description("Shows the plugin version")
    public void onVersion(CommandSender sender) {
        sender.sendMessage(ChatColorUtil.colorBungee("&6Integrity &ev0.1"));
    }

    @Subcommand("reload")
    @CommandPermission("integrity.reload")
    @Description("Reloads the plugin configuration")
    public void onReload(CommandSender sender) {
        sender.sendMessage(ChatColorUtil.colorBungee("&aConfiguration reloaded!"));
    }

    @Default
    @CatchUnknown
    public void onDefault(CommandSender sender) {
        sender.sendMessage(ChatColorUtil.colorBungee("&6=== &eIntegrity Help &6==="));
        sender.sendMessage(ChatColorUtil.colorBungee("&e/integrity version &7- Shows plugin version"));
        sender.sendMessage(ChatColorUtil.colorBungee("&e/integrity reload &7- Reloads configuration"));
    }
}
