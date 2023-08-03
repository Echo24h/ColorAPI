package com.github.colorapi.format;

import com.github.colorapi.ColorAPI;
import net.md_5.bungee.api.ChatColor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorFormat {

    private ColorAPI plugin;

    public ColorFormat(ColorAPI plugin) {
        this.plugin = plugin;
    }

    public String formatText(String text) {

        String colorsCode = plugin.getColorConfig().getColorsCode();

        Pattern pattern = getCustomPattern(colorsCode);

        StringBuilder stringBuilder = new StringBuilder();

        Matcher matcher = pattern.matcher(text);

        int lastIndex = 0;

        // '&'
        while (matcher.find()) {

            int startIndex = matcher.start();
            int endIndex = matcher.end();

            // Before color code
            if (startIndex > lastIndex) {
                stringBuilder.append(text.substring(lastIndex, startIndex));
            }
            if (startIndex + 1 < text.length()) {

                // Get color code
                char colorChar = text.charAt(startIndex + 1);

                String colorCode = String.valueOf(colorChar);

                // Get Gradient
                List<String> hexGradient = plugin.getColorConfig().getGradient(colorCode);

                // Gradient
                if (hexGradient != null) {
                    // Create Gradient
                    List<ChatColor> gradiant = Gradient.generateGradient(
                            hexGradient.get(0), hexGradient.get(1), endIndex - startIndex - 2
                    );

                    String gradiantPart = formatGradiant(gradiant, text.substring(startIndex + 2, endIndex));

                    stringBuilder.append(gradiantPart);
                }
                else {
                    // Custom colors
                    ChatColor color = plugin.getColorConfig().getColor(colorCode);

                    if (color != null) {
                        stringBuilder.append(color)
                                . append(text.substring(startIndex + 2, endIndex));
                    }
                    else { // No colors
                        stringBuilder.append(text.substring(startIndex, endIndex));
                    }
                }
            } // No color character
            else {
                stringBuilder.append(text.substring(lastIndex, endIndex));
            }
            lastIndex = endIndex + 1;
        }

        // End of message
        if (lastIndex < text.length()) {
            stringBuilder.append(text.substring(lastIndex));
        }

        return stringBuilder.toString();
    }

    private Pattern getCustomPattern(String colorsCode) {
        // "&[c].*?(?=&[b]|$)"
        // '&c ... to ... &b or end' (for example)
        Pattern pattern = Pattern.compile(
                "&[" + colorsCode + "].*?(?=&[" + colorsCode + "]|$)");
        return pattern;
    }

    private String formatGradiant(List<ChatColor> gradiant, String part) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < part.length(); i++) {

            char c = part.charAt(i);
            stringBuilder.append("" + gradiant.get(i) + c);
        }
        return stringBuilder.toString();
    }
}
