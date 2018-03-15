package fileio;

/*
De klassen in deze package demonstreren de manier waarop je in Java met bestanden en directories
kun werken.
Er zijn twee verschillende vormen: één klassieke en één met try-with-resources. Zie het commentaar
in de betreffende klassen voor een toelichting hierop.

De beide klassen implementeren de interface FileDemo, die drie methoden definieert: één om de bestanden
in een directory weer te geven, één om de regels van een bestand weer te geven, en één om data naar
een bestand te schrijven.
 */

public class Demo {
    public static void main(String[] args) {
        FileDemo demo = new DemoTryWithResources();

        System.out.println("Directory Listing");
        System.out.println("=================");
        demo.directoryListing();
        System.out.println("");

        System.out.println("File contents");
        System.out.println("=============");
        demo.listFileContents();

        demo.writeToFile();
    }
}