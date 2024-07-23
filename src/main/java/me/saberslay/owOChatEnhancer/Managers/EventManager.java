package me.saberslay.owOChatEnhancer.Managers;

import me.saberslay.owOChatEnhancer.OwOChatEnhancer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Random;

public class EventManager implements Listener {
    public EventManager(OwOChatEnhancer owoTextGenerator) {
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        // Get the player's message
        String message = event.getMessage();

        // Convert the message to OwO style
        String owoMessage = convertToOwO(message);

        // Replace raw message with owoMessage
        event.setMessage(owoMessage);
    }
// need to move this to its owne jar file
    public String convertToOwO(String message) {
        // Simple OwO conversion logic with additional transformations
        String owoMessage = message
                .replaceAll("[rl]", "w")
                .replaceAll("[RL]", "W")
                .replaceAll("n([aeiou])", "ny$1")
                .replaceAll("N([aeiou])", "Ny$1")
                .replaceAll("N([AEIOU])", "NY$1")
                .replaceAll("ove", "uv")
                .replaceAll("th", "d")
                .replaceAll("TH", "D");

        // Add some common OwO faces and phrases randomly
        String[] faces = {" OwO ", " UwU ", " >w< ", " ^w^ ", " uwu ", " owo ", " >_< "};
        String[] phrases = {" what's this? ", " notices bulge ", " *nuzzles* ", " *pounces on you* ", " *blushes* ", " oh~ ", " nya~ "};
        Random random = new Random();
        owoMessage += faces[random.nextInt(faces.length)];
        if (random.nextBoolean()) {
            owoMessage += phrases[random.nextInt(phrases.length)];
        }

        return owoMessage;
    }

}
