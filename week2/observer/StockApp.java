package observer;

/*
De klassen in deze package demonstreren de werking van het Observer pattern:

    https://nl.wikipedia.org/wiki/Observer_(ontwerppatroon)

Er zijn twee interfaces gedefinieerd: een Observer en een Observable. Klassen die de eerste van deze twee implementeren
worden op de hoogte gehouden van de klasse die de tweede implementeert. Zie het commentaar in de betreffende klassen
voor een uitgebreide uitleg.
 */

public class StockApp{
    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();

        ObserverImpl appobs = new ObserverImpl(stockGrabber, "APPL");
        ObserverImpl ibmobs = new ObserverImpl(stockGrabber, "IBM");
        ObserverImpl teslaobs= new ObserverImpl(stockGrabber, "TESLA");

        Thread t1 = new Thread(stockGrabber);
        t1.start();
    }
}
