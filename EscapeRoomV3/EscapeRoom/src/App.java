import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class App {
    public static void main(String[] args) throws Exception {
        // Carica il contenuto del file JSON
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("C:/Users/Java/Documents/java-Local/java-FullStack-Assignement/EscapeRoomV3/EscapeRoom/src/dialogues.json"));
        JSONArray dialoguesArray = (JSONArray) jsonObject.get("dialogues");

        // Simuliamo un evento del gioco
        boolean playerReachedSpecificLocation = true;

        // Se l'evento del gioco è stato attivato
        if (playerReachedSpecificLocation) {
            // Stampa solo i dialoghi tra "PersonaggioA" e "PersonaggioB"
            for (Object dialogueObj : dialoguesArray) {
                JSONObject dialogue = (JSONObject) dialogueObj;
                String character = (String) dialogue.get("character");
                String text = (String) dialogue.get("text");

                if (character.equals("PersonaggioA") || character.equals("PersonaggioB")) {
                    System.out.println(character + ": " + text);
                }
            }
        }
    }
}
