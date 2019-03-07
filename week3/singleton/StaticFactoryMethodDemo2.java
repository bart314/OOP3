package singleton;

import java.util.ArrayList;
import java.util.Random;

/*
 Een voordeel van static factory methods is dat je controle hebt over de hoeveelheid
 objecten die er van een klasse gemaakt kunnen worden. Dit is feitelijk hetzelfde
 als bij de Singleton, alleen gaat het nu om een beperkt aantal, maar meer dan één.
 In dit voorbeeld kunnen er tien objecten van deze klasse gemaakt worden: dit aantal
 is gegeven in het private veld int max_num.
*/

public class StaticFactoryMethodDemo2 {
    private static ArrayList<StaticFactoryMethodDemo2> _instances;

    static {
        _instances = new ArrayList<>();
    }

    private static int max_num = 10;
    private String demoString;

    public static StaticFactoryMethodDemo2 getNextInstance() {
        StaticFactoryMethodDemo2 rv;

        if (_instances.size() < max_num) {
            rv = new StaticFactoryMethodDemo2();
            _instances.add(rv);
        } else {
            Random r = new Random();
            rv = _instances.get( r.nextInt(_instances.size()) );
        }

        return rv;
    }

    private StaticFactoryMethodDemo2 () {
        this.demoString = getRandomString();
    }

    public String getDemoString() {
        return demoString;
    }

    private String getRandomString() {
        Random r = new Random();
        String rv = "";

        //loop for fill up 10 characters
        for (int i=0; i<10; i++) {
            char randomadd = (char)(r.nextInt(26) + 'A');
            rv +=randomadd;
        }

        return rv;
    }
}
