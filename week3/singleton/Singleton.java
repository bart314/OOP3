package singleton;

import java.util.Random;

/*
Dit is de meest gebruikte vorm van een Singleton. Een private constructor en een static
instantievariabele (waarom static?) die een referentie bevat naar het object dat van deze
klasse gemaakt is.
 */

public class Singleton {
    private static Singleton instance;
    private String demoString;

    public static Singleton getInstance() {
        // we kijken hier of het veld instance al gevuld is. Als dat niet het geval is,
        // maken we hem hier aan. In beide gevallen wordt dit veld teruggegeven. Dit is
        // een techniek die bekend staat onder de term lazy instantiation.
        //
        //    https://en.wikipedia.org/wiki/Lazy_initialization
        //
        // Als dit object nooit wordt aangevraagd, is het ook niet nodig hem te creëren.

        if (instance ==null) instance = new Singleton();
        return instance;
    }

    public String getString() {
        return this.demoString;
    }

    // De private constructor. Voor de demo wordt hier even een willekeurige String aan
    // gekoppeld, om eenvoudig duidelijk te kunnen maken dat het object dat door de methode
    // getInstance() wordt teruggegeven steeds hetzelfde is.
    private Singleton() {
        this.demoString = Demo.getRandomString();
    }
}
