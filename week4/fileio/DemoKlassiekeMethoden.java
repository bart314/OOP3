package fileio;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

/*
Wanneer je met bestanden op de filesystem werkt, kunnen er eenvoudig fouten optreden. Je kunt proberen
een bestand te lezen dat niet bestaat of te schrijven in een directory waar je geen rechten op hebt.
Om die reden werpen de meeste methoden die hierop betrekking hebben een IOException, wat een checked
Exception is.

Om deze reden worden deze methoden geëncapsuleerd binnen een try-catch blok. Maar het is eveneens van
belang om de eventuele pointers naar de bestanden en directories op een goeie manier af te sluiten
als je ermee klaar bent. Om dit voor elkaar te krijgen, gebruik je (in Java vóór versie 7) een
finally-block, zoals in het derde voorbeeld hieronder.

Het is van belang dat je deze manier van werken kent en herkent, omdat dit nog heel veel voorkomt.
 */

public class DemoKlassiekeMethoden implements FileDemo {
    public void directoryListing() {
        // De methode list() in de klasse File werpt geen checked exception, daarom hoeven we dit
        // niet in een try-block te stoppen.
        String path = "/Users/docent/Desktop"; // <- YOUR PATH HERE
        String[] files = new File(path).list();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }


    public void listFileContents() {
        String filename = "/Users/docent/Desktop/demo.txt"; // <- YOUR FILE HERE
        BufferedReader reader = null;
        FileReader file = null;

        try {
            // FileReader werpt een FileNotFoundException, die we moeten afvangen.
            // https://docs.oracle.com/javase/7/docs/api/java/io/FileNotFoundException.html
            file = new FileReader(filename);
            reader = new BufferedReader(file);
            String line;

            // readLine() werpt een IOException die we ook moeten afvangen.
            // https://docs.oracle.com/javase/7/docs/api/java/io/IOException.html
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            file.close();
        } catch (IOException e) {
            // Omdat FileNotFoundException een subclasse is van IOException,volstaat het om alleen
            // de IOException op te vangen.
            e.printStackTrace();
        }

        // Als we hier komen hebben we de reader in theorie nog open staan. We kunnen die niet eenvoudig
        // afsluiten, omdat het sluiten hiervan ook weer een IOException kan werpen. Die zouden we dus
        // weer moeten afvangen of doorsturen. Gedoe.
    }

    public void writeToFile() {
        String filename = "/Users/docent/Desktop/schrijven_pre8.txt";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            writer.println("Allemaal interessante dingen");
            writer.println("Er wordt toch een hoop verteld op zo'n dag");
            writer.println("Het is maar goed dat die kerel die loonsverhoging niet krijgt.");
            writer.println("他们是学的电脑。");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Het sluiten van de writer kan in theorie wel zonder dat er een gecheckte Exception
            // wordt geworpen. We checken wel even of dat ding null is, anders krijgen we weer
            // een NullPointerException...
            if (writer != null) writer.close();
        }
    }
}
