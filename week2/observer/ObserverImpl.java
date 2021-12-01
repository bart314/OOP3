package observer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Deze klasse vormt de basis-klasse van alle objecten die op de hoogte gehouden moeten worden van een andere klasse.
Objecten die van deze klasse aangemaakt worden, zijn Observers; de klasse waarvan ze op de hoogte gehouden moeten
worden is de Observable.
De enige methode die in de Interface Observer is gedefinieerd, is de methode void update(). De Observable roept op
bepaalde momenten (bijvoorbeeld wanneer zijn interne locale variabelen veranderen) van al zijn Observers deze methode
op. Het staat deze objecten dan vrij om hiermee te doen wat ze willen.

Het is van belang te realiseren waarom de Observer een interface is en geen specifieke klasse: de Observers kunnen
immers allemaal verschillende dingen doen, zonder dat er iets gemeenschappelijks hieraan is. Zo zou het ene object
een grafische weergave kunnen geven van een stuk data, terwijl een ander object waarden wegschrijft naar een
logbestand.
 */

public class ObserverImpl implements Observer {
    private String interest;

    /*
    Bij het aanmaken van een Observer meldt deze zichzelf aan bij de Observable (de StockGrabber in dit voorbeeld).
    In dit specifieke geval wordt ook een String meegegeven die aangeeft waarin het object geïnteresseerd is.
     */
    public ObserverImpl(Observable stockGrabber, String interest) {
        this.interest = interest;
        stockGrabber.register(this);
    }

    //Deze methode wordt vanuit de Observable waaraan deze Observer is gekoppeld aangeroepen. Afhankelijke van
    //welke data er wordt meegestuurd, wordt er al dan niet een waarde afgedrukt.
    @Override
    public void update(Map<String, Integer> values) {
        Integer val = values.get(interest);
        if (val != null) System.out.println(interest + ", waarde: " +val);
    }
}