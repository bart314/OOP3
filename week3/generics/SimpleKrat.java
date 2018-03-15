package generics;

import java.util.ArrayList;

/*
Dit is een eenvoudige generieke container. De klasse weet niet wat voor soort datatype er in hem wordt
opgeslagen, en is daar eigenlijk ook niet in geïnteresseerd. Wanneer een client (de Demo-klasse in deze
package) een instantie van SimpleKrat aanmaakt, geeft hij daarbij aan wat voor soort type hierin wordt
opgeslagen (String, Integer, Olifant, Muis, ...). Op dat moment heeft het concrete object van deze klasse
die specifieke waarvoor voor de generic T.

Het is dus logisch dat het veld kratinhoud hier van het type T is: dat kan immers van alles zijn. Maar we
zien in de methoden leeg() en vullen() dat hier een T wordt teruggegeven, respectievelijk wordt meegegeven.
Dat is logisch, omdat datgene wat je teruggeeft of opslaat van hetzelfde type moet zijn als wat je in het
veld kratinhoud hebt opgeslagen.

Je kunt voor de generic eigenlijk alles gebruiken wat je wilt. Er is wel een conventie die in de java
documentatie wordt gehanteerd (en dus de de facto standaard is, OPC p.110):

    - E voor een element
    - K voor een sleutel (Key)
    - V voor een waarde (Value)
    - N voor een nummer
    - T voor een data-type (Type)
    - S, U, V, enzovoort voor als je nog meer generieke datatypen hebt

 */
public class SimpleKrat<T> {
    private T kratinhoud;

    public T leeg() {
        return this.kratinhoud;
    }

    public void vullen(T t) {
        kratinhoud = t;
    }

}
