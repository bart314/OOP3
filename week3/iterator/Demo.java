package iterator;

import java.util.ArrayList;
import java.util.Iterator;

/*
De klassen in deze package demonstreren de uitwerking van de iterator-opdracht die op Blackboard staat.

    http://www.yegor256.com/2015/04/30/iterating-adapter.html

Hierbij wordt gebruik gemaakt van een ArrayList om een Stack te creëren. Een stack is (in de regel) een
LIFO-queue: elementen die het eerst op de Stack zijn geplaatst komen er als laatste weer uit.
 */

public class Demo {
    public static void main(String[] args) {
        // We maken een Stack van String's en stoppen daar drie waarden in. Als we ze er weer
        // uit halen, is het de bedoeling dat de zin die er als eerst is ingestopt als laatste
        // weer uit komt.
        NewStack<String> foo = new NewStack<>();

        foo.push("Onderste zin");
        foo.push("Middelste zin");
        foo.push("Bovenste zin");

        // We gebruiken een iterator om de waarden weer te laten zien.
        Iterator<String> itr = foo.iterator();
        while (itr.hasNext()) System.out.println(its.next());


        // Omdat onze Stack gebruik maakt van een Generic, kunnen we ook onze zelfgemaakte
        // datatypen in zetten. Bijvoorbeeld Person's:
        NewStack<Person> bar = new NewStack<>();
        Person p1 = new Person("Bart", "Sneek", 'V');
        Person p2 = new Person("Yfke", "Sneek", 'M');
        Person p3 = new Person("Trump", "Washington", 'I');

        // We pushen deze op een bijzondere manier op de Stack, om zeker te weten dat dit
        // een echte LIFO is.
        bar.push(p2);
        bar.push(p3);
        bar.push(p1);
        Iterator<Person> itr2 = bar.iterator();
        while(itr2.hasNext()) System.out.println(itr2.next());
    }
}
