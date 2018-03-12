package singleton;

/*
 Een voordeel van static factory methods is dat je met een duidelijke naam kunt aangeven
 wat voor object je terugkrijgt.
 Het voorbeeld is misschien wat vergezocht, maar je kunt je wellicht situaties indenken
 waarin iets vergelijkbaars wel handig is.
*/

public class StaticFactoryMethodDemo1 {
    private String adres;
    private String woonplaats;

    // Deze methode kun je gebruiken als je wel een woonplaats weet, maar bij het
    // aanmaken van het object het adres wilt meegeven.
    public static StaticFactoryMethodDemo1 standaardWoonplaats(String adres) {
        StaticFactoryMethodDemo1 rv = new StaticFactoryMethodDemo1();
        rv.adres = adres;
        rv.woonplaats = "Groningen";
        return rv;
    }
    // Deze methode kun je gebruiken als je wel een adres weet, maar bij het
    // aanmaken van het object het woonplaats wilt meegeven.
    public static StaticFactoryMethodDemo1 standaardAdres(String woonplaats) {
        StaticFactoryMethodDemo1 rv = new StaticFactoryMethodDemo1();
        rv.woonplaats = woonplaats;
        rv.adres = "Zernikeplein 11";
        return rv;
    }


    private StaticFactoryMethodDemo1() {
        // pass, maar dit is geen Python...
    }
}
