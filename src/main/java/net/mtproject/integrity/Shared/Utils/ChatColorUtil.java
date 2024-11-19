package net.mtproject.integrity.Shared.Utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.md_5.bungee.api.ChatColor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatColorUtil {
    private static final Pattern HEX_PATTERN = Pattern.compile("#[a-fA-F0-9]{6}");
    private static final char COLOR_CHAR = '§';
    private static final char ALT_COLOR_CHAR = '&';

    /**
     * String'i Paper/Spigot için renklendirir
     *
     * @param message Renklendirmek istenen mesaj
     * @return Renklendirilmiş mesaj
     */
    public static String colorSpigot(String message) {
        if (message == null) return null;
        return translateHexColorCodes(ChatColor.translateAlternateColorCodes('&', message));
    }

    /**
     * String'i BungeeCord için renklendirir
     *
     * @param message Renklendirmek istenen mesaj
     * @return Renklendirilmiş mesaj
     */
    public static String colorBungee(String message) {
        if (message == null) return null;
        Matcher matcher = HEX_PATTERN.matcher(message);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String group = matcher.group();
            matcher.appendReplacement(buffer, ChatColor.of(group).toString());
        }
        matcher.appendTail(buffer);

        return ChatColor.translateAlternateColorCodes('&', buffer.toString());
    }

    /**
     * String'i Velocity için Component'e çevirir
     *
     * @param message Renklendirmek istenen mesaj
     * @return Renklendirilmiş Component
     */
    public static Component colorVelocity(String message) {
        if (message == null) return Component.empty();

        Matcher matcher = HEX_PATTERN.matcher(message);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String hexColor = matcher.group();
            matcher.appendReplacement(buffer, "§x§" + String.join("§", hexColor.substring(1).split("")));
        }
        matcher.appendTail(buffer);

        String legacyText = buffer.toString().replace(ALT_COLOR_CHAR, COLOR_CHAR);

        return LegacyComponentSerializer.legacySection().deserialize(legacyText);
    }

    private static String translateHexColorCodes(String message) {
        Matcher matcher = HEX_PATTERN.matcher(message);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String group = matcher.group();
            matcher.appendReplacement(buffer, ChatColor.of(group).toString());
        }

        return matcher.appendTail(buffer).toString();
    }

    public static String gradient(String message, String fromHex, String toHex, Platform platform) {
        if (message == null || message.isEmpty()) return message;

        java.awt.Color fromColor = java.awt.Color.decode(fromHex);
        java.awt.Color toColor = java.awt.Color.decode(toHex);

        char[] chars = message.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                result.append(' ');
                continue;
            }

            double ratio = (double) i / (chars.length - 1);
            int red = (int) (fromColor.getRed() * (1 - ratio) + toColor.getRed() * ratio);
            int green = (int) (fromColor.getGreen() * (1 - ratio) + toColor.getGreen() * ratio);
            int blue = (int) (fromColor.getBlue() * (1 - ratio) + toColor.getBlue() * ratio);

            String hex = String.format("#%02x%02x%02x", red, green, blue);

            switch (platform) {
                case SPIGOT:
                    result.append(ChatColor.of(hex)).append(chars[i]);
                    break;
                case BUNGEE:
                    result.append(ChatColor.of(hex)).append(chars[i]);
                    break;
                case VELOCITY:
                    result.append("§x§").append(String.join("§", hex.substring(1).split("")))
                            .append(chars[i]);
                    break;
            }
        }

        return result.toString();
    }

    public enum Platform {
        SPIGOT,
        BUNGEE,
        VELOCITY
    }
}
