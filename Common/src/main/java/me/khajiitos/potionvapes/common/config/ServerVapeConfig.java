package me.khajiitos.potionvapes.common.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import me.khajiitos.potionvapes.common.PotionVapes;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ServerVapeConfig {
    private static final File file = new File("config/potionvapes.json");
    public static boolean cancerMode = true;

    public static void init() {
        if (file.exists()) {
            try (FileReader fileReader = new FileReader(file)) {
                JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();

                cancerMode = !jsonObject.has("cancerMode") || jsonObject.get("cancerMode").getAsBoolean();
            } catch (IOException e) {
                PotionVapes.LOGGER.error("Failed to read Potion Vapes config");
            } catch (JsonSyntaxException | IllegalStateException e) {
                PotionVapes.LOGGER.error("Potion Vapes config is malformed");
            }
        } else {
            if (file.getParentFile().isDirectory() || file.mkdirs()) {
                save();
            }
        }
    }

    private static void save() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("cancerMode", cancerMode);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonObject.toString());
        } catch (IOException e) {
            PotionVapes.LOGGER.error("Failed to save Potion Vapes config");
        }
    }
}
