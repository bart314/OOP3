package observer;

//import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
Deze klasse is de Observable waaraan alle Observers gekoppeld zijn. Hij heeft een interne lijst van alle objecten
die geïnteresseerd zijn in de status-updates hiervan (die ArrayList<Observer> observers). Elke keer als dit object
het nodig vindt, wordt zijn interne methode void notifyObservers() aangeroepen, die over deze lijst heen itereert
en van elke Observer de methode void update() aanroept. Hij kan dit doen, omdat deze methode in de interface
Observer is gedefinieerd.

Het is van belang op te merken dat Observable een Interface is, en geen (abstracte) klasse. Binnen hetzelfde
programma kunnen immers meerdere Observable's bestaan, die verder geen enkele functionaliteit delen. Zo houdt deze
klasse waarden bij van een stock exchange, maar je kunt je ook voorstellen dat er Observables zijn die met de GUI
van doen hebben.
 */


public class StockGrabber implements Observable, Runnable {
    private ArrayList<Observer> observers = new ArrayList<>();
    private HashMap<String, Integer> vals = new HashMap<>();
    private Random random = new Random();

    // Bij het aanmaken van deze Observable wordt de lijst van Observer's geïnitialiseerd.
    public StockGrabber(){
        observers = new ArrayList<Observer>();
    }

    // Deze methode wordt gebruikt om Observables aan de lijst toe te voegen.
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    // Deze methode wordt gebruikt om Observables van de lijst te verwijderen (die heb ik in deze implementatie
    //niet gemaakt.
    public void unregister(Observer newObserver) {
        // TODO
    }

    // Elke keer als er een nieuwe prijs wordt bepaald, wordt de methode notifyObservers aangeroepen.
    public void setPrice(String what, int howmuch) {
        vals.put(what, howmuch);
        notifyObserver();
    }

    // Dit is de main gist van deze klasse. Elke Observer wordt op de hoogte gesteld van de wijzigingen in de status
    // van de lokale variabelen. De waarden van deze variabelen (de HashMap<String, Integer> vals) worden bij de
    // update meegstuurd: dit is een implementatiekeuze (een ontwerpbeslissing). Je kunt er ook voor kiezen de
    // Observers zelf de data op te laten halen. Het voordeel van die implementatie is dat er minder data heen en
    // weer wordt gestuurd. Het voordeel van deze implementatie is dat je minder calls over en weer hebt...
    public void notifyObserver() {
        // TODO: omzetten naar Lambda...?
        for(Observer observer : observers) {
            observer.update(vals);
        }
    }

    // Deze methode komt van Runnable, omdat dit ding in een separate Thread moet draaien (dat was althans de opgave)
    @Override
    public void run() {
        String what;
        Integer val;

        while (true) {
            what = getNewInterest();
            val = getNewValue();
            setPrice(what, val);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                //pass, maar dit is geen python.
            }
        }
    }

    private Integer getNewValue () {
        return random.nextInt(1000);
    }

    private String getNewInterest() {
        String what = "";
        int newStock = random.nextInt(120);
        if (newStock<30) what = "APPL";
        else if (newStock<60) what = "IBM";
        else what = "TESLA";

        return what;
    }



}
