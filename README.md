# ColorAPI Minecraft Plugin

**Plugin page:** [download .jar](https://www.spigotmc.org/resources/colorapi.111792/)

Tested Minecraft Versions: 1.16 - 1.20

Languages Supported: Custom

**Donation Link:** [Support us on PayPal](https://www.paypal.com/donate/?hosted_button_id=J4Y27JYWLYLBG)

Join our Discord community for support and updates: [Discord Invite](https://discord.com/invite/Xf3PjwXzKg)

ColorAPI is an intuitive API plugin that introduces an innovative approach to working with colors in Minecraft!

This plugin allows you to create entirely new and bespoke color codes, with gradient capabilities, for your Minecraft servers!

## For Server Administrators

Effortlessly adjust color settings using the user-friendly `config.yml` file. Adapt your color scheme to complement your server theme and captivate players with visually stunning designs.

## For Developers

Easily integrate ColorAPI into all your plugins. Enhance your creations by exploiting the full potential of colors:

### Usage

```java
String text = "&y" + "This is a custom colored message!";
if (colorAPI != null)
    text = colorAPI.translateColorCodes(text);
```
### Include the API

#### How to include the API with Maven:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.Echo24h</groupId>
        <artifactId>ColorAPI</artifactId>
        <version>1.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

#### How to include the API with Gradle:

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    compileOnly "com.github.Echo24h:ColorAPI:1.0"
}
```

### Implementing ColorAPI

```java
package com.example.plugin;

import com.github.colorapi.ColorAPI;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyPlugin extends JavaPlugin {

    private static ColorAPI colorAPI;
    @Override
    public void onEnable() {
        if (!setupColorAPI()) {
            getLogger().warning("Failed to hook into ColorAPI");
        }
    }

    private boolean setupColorAPI() {
        if (getServer().getPluginManager().getPlugin("ColorAPI") == null)
            return false;
        RegisteredServiceProvider<ColorAPI> rsp = getServer().getServicesManager().getRegistration(ColorAPI.class);
        if (rsp == null)
            return false;
        colorAPI = rsp.getProvider();
        return colorAPI != null;
    }
}
```

Enrich your Minecraft experience with the creative potential of ColorAPI! Create captivating visuals and immersive gameplay using the power of custom colors and gradients. Whether you're a server administrator or a developer, ColorAPI offers an exceptional way to engage players and elevate your Minecraft projects to new heights.
