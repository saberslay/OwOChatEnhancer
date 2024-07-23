package me.saberslay.owOChatEnhancer.utile;
import me.saberslay.owOChatEnhancer.OwOChatEnhancer;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateChecker {

    private OwOChatEnhancer plugin;
    private int ResourceID;

    public  UpdateChecker (OwOChatEnhancer plugin, int ResourceID) {
        this.plugin  = plugin;
        this.ResourceID = ResourceID;
    }
    public void getLatestVersion(Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.ResourceID).openStream();
                 Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                plugin.getLogger().info("Update checker is broken, can't find an update!" + exception.getMessage());
            }
        });
    }
}
