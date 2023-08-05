# ColorAPI Minecraft Plugin

**Plugin page:** [download .jar](https://www.spigotmc.org)

Tested Minecraft Versions: 1.16 - 1.20

Languages Supported: Custom

**Donation Link:** [Support us on PayPal](https://www.paypal.com/donate/?hosted_button_id=J4Y27JYWLYLBG)

Join our Discord community for support and updates: [Discord Invite](https://discord.com/invite/Xf3PjwXzKg)

ColorAPI is an intuitive API plugin that introduces an innovative approach to working with colors in Minecraft!

This plugin allows you to create entirely new and bespoke color codes, with gradient capabilities, for your Minecraft servers!

## For Server Administrators

Effortlessly adjust color settings using the user-friendly `config.yml` file. Adapt your color scheme to complement your server theme and captivate players with visually stunning designs.

### Config.yml

```yaml
# ----------- Config -----------

# For example, in your text
# - '&y': Light Blue
# - '&z': Red
# - '&X': Gradient Red-Green

colors:
  x:
    color: "#ECFF00"
  y:
    color: "#B2EAF4" # Light Blue
  z:
    color: "#FF0000" # Red
  a:
    color: "#FFA500" # Orange
  b:
    color: "#FFC0CB" # Pink
  c:
    color: "#008000" # Green
  d:
    color: "#800080" # Purple

gradients:
  X:
    color1: "#FF0000" # Red
    color2: "#00FF00" # Green
  Y:
    color1: "#0000FF" # Blue
    color2: "#FFFF00" # Yellow
  Z:
    color1: "#FF00FF" # Magenta
    color2: "#00FFFF" # Cyan
  A:
    color1: "#FFA500" # Orange
    color2: "#FFC0CB" # Pink
  B:
    color1: "#008000" # Green
    color2: "#800080" # Purple
  C:
    color1: "#800000" # Maroon
    color2: "#00CED1" # Dark Turquoise
```

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
