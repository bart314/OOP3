package fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
Sinds versie 7 kent Java try-with-resources. De syntax hiervan is als volgt:

1.      try (r = Resource):
2.          doe je dingen met r
3.      catch (Ex e):
4.          doe dingen met e
5.      finally:
6.          dingen opruimen

Een checked Exception die door de Resource in regel 1 kan worden geworpen, vereist nog steeds
een catch or declare, maar in alle gevallen wordt de resource impliciet voor je afgesloten. De
scope van de Resource r is in dit voorbeeld alleen maar regel 2, dus je hebt daar geen beschikking
over binnen je catch- of je finally-blok; dit is een verandering ten opzichte van de klassieke
methode, waar je de variabelen declareert buiten de scope van de try, omdat je die in het finally-
blok wilt kunnen adresseren (om hem te sluiten bijvoorbeeld).

Om in een try-with-resource gebruikt te kunnen worden, moeten Resource de interface AutoClosable
implementeren:

        https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html

Op die manier kun je dus ook je eigen Resources creëren (bijvoorbeeld wanneer je met een database-
connectie werkt).

Omdat we hier toch met 1.8 werken, heb ik ook het printen en dergelijke in een lambda gezet. Het is
van belang dat je deze syntax begrijpt en kunt lezen en toepassen.
 */

public class DemoTryWithResources implements FileDemo {
    public void directoryListing() {
        // try with resource
        String path = "/Users/docent/Desktop/";
        try (Stream<Path> stream = Files.list(Paths.get(path))) {
            // lambda voor het uitprinten
            stream.forEach(f -> System.out.println(f));
        } catch (IOException e) {
            System.out.println("Er ging iets mis met het lezen van de directory.");
            e.printStackTrace();
        }
    }


    public void listFileContents() {
        String filename = "/Users/docent/Desktop/demo.txt";
        Path path = Paths.get(filename);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            // lambda voor het uitprinten
            reader.lines().forEach(l -> System.out.println(l));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeToFile () {
        String filename = "/Users/docent/Desktop/schrijven_java8.txt";
        Path path = Paths.get(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("A28 bij Leusden dicht nadat vrachtwagen viaduct ramt.\n");
            writer.write("NAVO en EU uiten zorgen over zenuwgasaanval Russische spion.\n");
            writer.write("Rusland zal direct reageren als VS Syrië bestookt met aanvallen.\n");
            writer.write("Video Dronebeelden tonen hoe wolkenkrabber Kentucky wordt opgeblazen.\n");
        } catch (IOException e) {
            System.out.println("Er ging iets fout bij het wegschrijven");
            e.printStackTrace();
        }
    }

}
