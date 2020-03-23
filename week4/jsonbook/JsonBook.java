package jsonbook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

/*
Deze klasse demonstreert het werken met json-bestanden, zowel het lezen als het schrijven. Er worden
hierin twee libraries bij geïntroduceerd:

    org.json.simple (http://www.java2s.com/Code/Jar/j/Downloadjsonsimple11jar.htm)
    com.google.gson (https://mvnrepository.com/artifact/com.google.code.gson/gson)

Er zijn nog veel meer json-libraries voor Java. Bekijk de onderstaande benchmark om een idee te
krijgen van de verschillen en de performance hiervan:

    https://github.com/fabienrenaud/java-json-benchmark

Bestudeer de werking van json nog even om duidelijk te hebben hoe dit werk (http://json.org). Dit
data-format (JavaScript Object Notation) heeft key-value als algemene vorm: die key is in de regel
een string-literal (hoewel het ook een object kan zijn) en de value kan van alles zijn. Tezamen
worden deze dingen weer in een array gestopt, die dan weer als value kan gelden voor een specifieke
key. Bekijk bijvoorbeeld de bijgevoegde of gegenereerde json-bestanden.

In de klasse hieronder staan vier methoden: twee om data te lezen en twee om data te schrijven.
*/

public class JsonBook {
    // Verander de onderstaande constante in het correcte pad (waar de bestanden terecht moeten komen).
    private static final String DIR_NAME = "/Users/bart/Dropbox/Hanze/thema2.3/oop3/week4/jsonbook/";

    public static void main(String[] args) {
        //read_demo();
        //write_demo();
        //read_demo_gson();
        write_demo_gson();
    }

    /*
    Data lezen door gebruik te maken van de org.json.simple-package.
    Omdat voor deze package alle data die in het json-bestand staat als Object's wordt gezien,
    moeten we de compiler expliciet vertellen wat we verwachten dat er voor data in het bestand
    staat. Dat doen we door hieronder de hele tijd te casten naar JSONArray of JSONObject.
     */

    private static void read_demo() {
        // We maken eerst een parse aan, die de gegeven data voor ons parseert. Dit kan buiten het
        // try-block omdat dat in de regel wel goed zal gaan.
        JSONParser parser = new JSONParser();
        String filename = DIR_NAME+ "trump.json";

        // Omdat die Parser geen AutoClosable is, kunnen we hier geen gebruik maken van een
        // try-with-resource-constructie.
        try {
            // Het geparseerde resultaat is voor Java een Object, dus om de compiler duidelijk te
            // maken dat we te maken hebben met een JSONObject moeten we het expliciet casten. We
            // gebruiken overigens een standaard FileReader() om de data binnen te laden.
            JSONObject obj = (JSONObject) parser.parse(new FileReader(filename));

            // In het JSONObject obj zit een array van objecten, die "nodes" als key heeft.
            JSONArray medewerkers = (JSONArray) obj.get("nodes");

            // we itereren hier overheen met een Iterator van JSONObject's. Dat moeten we ook weer
            // expliciet aangeven.
            Iterator<JSONObject> itr = medewerkers.iterator();
            JSONObject foo;
            while (itr.hasNext()) {
                foo = itr.next();
                System.out.println(foo.get("label") + ": " + foo.get("notes"));
            }
        } catch (IOException e) {
            System.out.println("Er ging iets mis met lezen van het bestand...");
            e.printStackTrace();
        }catch (ParseException e) {
            System.out.println("Er ging iets mis met het parseren van het bestand.");
            e.printStackTrace();
        }
    }

    /*
    Data als json wegschrijven door gebruik te maken van org.json.simple. Je ziet dat we hier te maken
    hebben met JSONObject's en JSONArray's; deze komen beide uit de simple-library en je hebt geen idee
    wat voor soort data er in deze Collections te vinden is. Voor de compiler zijn het alemaal objecten.

    Het voorbeeld is een auteur die verschillende boektitels op zijn of haar naam heeft. De algemene
    structuur hiervan is al volgt:

      {
        <string:auteur_naam>:
            { "titels": [<string:boektitel>+] }
        ...
      }
     */
    private static void write_demo() {
        // https://stackoverflow.com/a/18336207
        // obj is de array van het hoogste niveau
        JSONArray obj = new JSONArray();

        // Hieronder maken we twee nieuwe objecten aan, die we beide met een auteur en een array
        // van titels zullen vullen (in de code hieronder)
        JSONObject foo = new JSONObject();
        JSONObject bar = new JSONObject();

        // De array van titels van de eerste auteur:
        JSONArray titels = new JSONArray();
        titels.add("De afvallige");
        titels.add("De dwaas van Palmyra");
        titels.add("Het fluwelen labyrinth");
        titels.add("De ommegang");
        foo.put("auteur","Jan van Aken");
        foo.put("titels", titels);
        // resultaat: { "titels":["titel1", "titel2", "titel3", ...] }

        // De array van titels van de tweede auteur:
        JSONArray titels2 = new JSONArray();
        titels2.add("Heren van de thee");
        titels2.add("Sleuteloog");
        titels2.add("Oeroeg");
        titels2.add("De verborgen bron");
        bar.put("auteur","Hella Haasse");
        bar.put("titels", titels2);
        // De vorm van dit resultaat is van dezelfde vorm als in de foo.put hierboven.

        // Nu voegen we de beide objecten foo en bar toe aan het object van op het hoogste niveau,
        // voorzien van de naam van de auteur als key (en de lijst van titels dus als value)
        obj.add(foo);
        obj.add(bar);

        // en wegschrijven. Let op de try-with-resource-constructie hieronder.
        String filename = DIR_NAME + "titels.json";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(obj.toJSONString());
        } catch (IOException e) {
            System.out.println("Falen met schrijven");
            e.printStackTrace();
        }
    }

    /*
    Lezen door gebruik te maken van de com.google.gson library. Deze library maakt gebruik van
    standaard Java-constructies en is wat slimmer om te bepalen wat voor datatypen er in het
    databestand zitten:

        Each time gson sees a {}, it creates a Map (actually a gson StringMap )
        Each time gson sees a '', it creates a String
        Each time gson sees a number, it creates a Double
        Each time gson sees a [], it creates an ArrayList

    Omdat dit is ingebakken, hoeven we niet, zoals bij org.json.simple, de hele tijd dingen naar
    iets te casten in de hoop dat dat goed gaat. In deze constructie gaan we er van uit dat de json
    eruitziet zoals we verwachten en dat het de juiste datatypen doorgeeft aan de afvangende objecten.
     */

    private static void read_demo_gson() {
        String filenname = DIR_NAME + "remarque.json";

        // JsonReader is een AutoClosable, dus we kunnen fijn gebruik maken van een try-with-resource-
        // constructie.
        try (JsonReader reader = new JsonReader(new FileReader(filenname));) {
            // https://google.github.io/gson/apidocs/
            // This method deserializes the Json read from the specified parse tree
            // into an object of the specified type.
            // Die fromJson-methode vereist twee parameters: een reader die het bestand heeft
            // ingelezen, en een java-datatype waar de geparseerde data in moet worden opgevangen.
            // In dit geval dus een Map (zie ook het datatype van de variabele data).
            Map<String, List<String>> data = new Gson().fromJson(reader, Map.class);

            // we printen even de hele data uit
            System.out.println(data);

            // en halen de array van titels van Remarque op als List<String>. Merk op dat we in dit
            // geval geen expliciete typecasting hoeven toe te passen.
            List<String> titels = data.get("Remarque");
            titels.forEach( System.out::println );

        } catch (FileNotFoundException e) {
            System.out.println("Bestand niet gevonden");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Er ging iets mis met het lezen");
            e.printStackTrace();
        }
    }

    /*
    Het schrijven met com.google.gson is ook wat makkelijker dan met org.json.simple, omdat we
    ook in dit geval gebruik kunnen maken van native Java-Collection's. De inhoud daarvan kunnen
    we doorgeven aan een GsonBuilder. die de serialisatie van de Collection naar het juiste
    json-formaat regelt. En we kunnen bij die Builder ook aangeven of hij de data leesbaar of juist
    minified moet opslaan.
    De GsonBuilder maakt overigens gebruik van het builder-pattern.
     */
    private static void write_demo_gson() {
        // We maken eenzelfde soort Collection aan als in het lees-voorbeeld, waarbij de
        // key een String is en de value een List<String>.
        Map<String, List<String>> data = new HashMap<>();
        List<Titels> titels_1 = new ArrayList<>();

        titels_1.add("Der Weg Zurück");
        titels_1.add("Im Westen nichts neues");
        titels_1.add("Drei Kamaraden");
        titels_1.add("Der Feind");
        data.put("Remarque", titels_1); // Alle titels van Remarque die we willen opslaan.

        List<String> titels_2 = new ArrayList<>();
        titels_2.add("Microserves");
        titels_2.add("Miss Wyoming");
        titels_2.add("JPod");
        titels_2.add("Girlfriend in a Coma");
        data.put("Douglas Coupland", titels_2);

        String filenname = DIR_NAME + "titels.json";
        // we openen een filewriter
        try (FileWriter file = new FileWriter(filenname)) {
            // Hier maken we een nieuwe GsonBuilder aan, die verantwoordelijk is voor de serialisatie
            // van de data (de Map die we hierboven hebben aangemaakt) naar json.
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // en het uiteindelijke wegschrijven gebeurt weer met Java zelf.
            file.write(gson.toJson(data));
            System.out.println("JSON object geschreven naar bestand " + filenname);
        } catch (IOException e) {
            System.out.println("Er ging iets mis met het schrijven van het bestand.");
            e.printStackTrace();
        }
    }
}
