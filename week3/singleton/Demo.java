package singleton;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/*
De klassen in deze package demonstreren de werking van het Singleton-pattern:

    - https://en.wikipedia.org/wiki/Singleton_pattern

Omdat je door gebruik te maken van de een private constructor het aanmaken van objecten
delegeert aan de klasse zelf, kun je ook andere spannende dingen hiermee doen. Zie hiervoor
het commentaar in de klassen StaticFactoryMethodDemo1 en StaticFactoryMethodDemo2, en de
demo-methode hieronder.

*/

public class Demo {

    public static void main(String[] args) {
        demo2();
    }

    public static void demo1() {
        // twee separate variabelen, maar toch verwijzen ze naar hetzelfde object.
        Singleton foo = Singleton.getInstance();
        Singleton bar = Singleton.getInstance();

        System.out.println(foo.getString());
        System.out.println(bar.getString());
        System.out.println(bar==foo);
    }

    /*
    Je kunt er op eenzelfde manier ook voor zorgen dat er maar een beperkt aantal objecten
    van de klassen kan worden aangemaakt. Zo vragen we hieronder dertig keer dezelfde methode
    op, maar de betreffende klasse is zo geprogrammeerd dat er maar tien instanties van het
    ding aangemaak kunnen worden. Dus in plaats van de (wellicht) verwachte dertig elementen,
    zitten er aan het eind van deze methode maar tien elementen in de HashSet (die verschillende
    foo's geven na tien keer een String terug die al in de HashSet zit, en een HashSet kan geen
    dubbele waarden bevatten).
     */
    public static void demo2() {
        Set<String> vals = new HashSet<>();
        StaticFactoryMethodDemo2 foo;

        for (int i=0; i<30; i++) {
            foo = StaticFactoryMethodDemo2.getNextInstance();
            vals.add(foo.getDemoString());
        }

        System.out.println("Aantal elementen in de lijst: " +vals.size());
        System.out.println("Hier komen de waarden:");
        vals.stream().forEach( v -> System.out.println(v));
    }

    public static String getRandomString() {
        Random r = new Random();
        String rv = "";

        //loop for fill up 10 characters
        for (int i = 0; i < 10; i++) {
            char randomadd = (char) (r.nextInt(26) + 'A');
            rv += randomadd;
        }

        return rv;
    }
}
