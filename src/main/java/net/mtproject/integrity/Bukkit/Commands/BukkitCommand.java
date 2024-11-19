package net.mtproject.integrity.Bukkit.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import net.mtproject.integrity.Shared.Utils.ChatColorUtil;
import org.bukkit.command.CommandSender;

@CommandAlias("integrity|int")
public class BukkitCommand extends BaseCommand {

    @Subcommand("version")
    @CommandPermission("integrity.version")
    @Description("Shows the plugin version")
    public void onVersion(CommandSender sender) {
        sender.sendMessage(ChatColorUtil.colorSpigot("&6Integrity &ev0.1"));
    }

    @Subcommand("reload")
    @CommandPermission("integrity.reload")
    @Description("Reloads the plugin configuration")
    public void onReload(CommandSender sender) {
        sender.sendMessage(ChatColorUtil.colorSpigot("&aConfiguration reloaded!"));
    }

    @Default
    @CatchUnknown
    public void onDefault(CommandSender sender) {
        sender.sendMessage(ChatColorUtil.colorSpigot("&6=== &eIntegrity Help &6==="));
        sender.sendMessage(ChatColorUtil.colorSpigot("&e/integrity version &7- Shows plugin version"));
        sender.sendMessage(ChatColorUtil.colorSpigot("&e/integrity reload &7- Reloads configuration"));
    }
}