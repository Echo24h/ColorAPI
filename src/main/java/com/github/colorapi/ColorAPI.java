package com.github.colorapi;

public class ColorAPI {

    public static String translateColorCodes(String text) {
        return ColorAPIPlugin.getInstance().getColorFormat().formatText(text);
    }
}
