package generics;

/*
De klassen in deze package demonstreren de werking van generics en vormen daarmee een
voorbereiding op de uitwerking van het iterator-pattern (zie het iterator-package).

    https://docs.oracle.com/javase/tutorial/extra/generics/index.html

Generics vormen een methode om het data-type dat je in een collectie of een container kunt
stoppen zeker te stellen. Zonder gebruik van generics zou een container (in pseudo-code) er
als volgt uit kunnen zien:

1.      class Container:
2.          private Object contents;
3.          public Object getContent(): return this.contents;


Een client van deze container zou hier wel een willekeurig object in kunnen stoppen, maar als
deze dit weer terug wil krijgen, is het datatype verloren. Je zou dan iets krijgen als het
onderstaande:

4.      class Client:
5.          Container.add(new Olifant());
6.
7.          // en dan verderop
8.          Olifant result = (Olifant)Container.getContent()

Die cast op regel 8 kán natuurlijk in runtime een IllegalCastException gooien, terwijl het in compile-time
wel zou werken – de compiler kan niet bepalen of het concrete type wat er in die container zit wel of geen
Olifant is.

Om dit te voorkomen zijn in java 5 die generics geïntroduceerd. Hiermee kun je de compiler vertellen wat voor
datatypen je in een container of een collectie hebt zitten. In het eerste voorbeeld hieronder, void demo1(),
maken we twee keer een SimpleKrat: één waar Olifant'en in kunnen en één waar Muis'en in kunnen. Zie het
commentaar in SimpleKrat voor meer toelichting. In void demo2() maken we gebruik van een uitgebreidere
versie van SimpleKrat om duidelijk te maken dat je in je klasse-definitie niet beperkt bent tot één generic.

Generics werken alleen tijdens compile-time: ze vormen een mechanisme om het statische datatype
van variabelen te garanderen. Op de achtergrond worden alle T in de verschillende klassen met
Object, dat wil zeggen dat na het compileren al je generics gewoon Objecten zijn (dit is overigens
java-specifiek: er zijn talen die anders werken).

De compiler voert de onderstaande cast uit.

    Olifant foo = (Olifant)olifantSimpleKrat.leeg();

Die cast gaat altijd goed, omdat je in compile-time het type wat je in je container of je
collectie hebt zitten hebt aangegeven.
Onthoudt: in run-time zijn het allemaal objecten. Deze techniek staat bekend als *type erasure*

Een gevolg van type erasure is dat je een aantal zaken niet met generics kunt doen (OCP p.113):

    - Er is geen constructor new T(): dit zou niets anders zijn dan new Object().
    - Je kunt geen array maken van het statische type, omdat dat gewoon een array van Object's zou zijn.
    - Je kunt geen gebruik maken van instanceof. Ook dit is logisch, omdat ArrayList<String> en
      ArrayList<Integer> voor de compiler beide hetzelfde zijn (namelijk ArrayList<Object>).
    - Je kunt geen primitief datatype gebruiken als generic (maar je kunt natuurlijk wel altijd een
      wrapper-klasse gebruiken, mocht je dit nodig hebben).
    - Omdat T altijd gelinkt is aan een specifieke, concrete instantie van de klasse is het niet
      mogelijk om een statische variabele van het type T te hebben (static T foo werkt niet).

Er zit niets runbaars in deze package: het gaat vooral om de syntax en de infrastructuur.
 */

public class Demo {
    static void demo1() {
        //We maken twee instanties van de klasse SimpleKrat: één waar olifanten in kunnen en
        //één voor muizen. De generic in SimpleKrat vangt het type op dat wordt meegegeven.
        SimpleKrat<Olifant> olifantSimpleKrat = new SimpleKrat<>();
        SimpleKrat<Muis> muisSimpleKrat = new SimpleKrat<>();

        olifantSimpleKrat.vullen(new Olifant());
        muisSimpleKrat.vullen(new Muis());
        // De onderstaande regel compileert niet, omdat we een Olifanten in een muiskrat kunnen stoppen.
        //muisSimpleKrat.vullen(new Olifant());

        Muis muis = muisSimpleKrat.leeg();
        Olifant olifant = olifantSimpleKrat.leeg();

    }














    static void demo2() {
        Olifant olifant = new Olifant();
        Integer kratSize = 8_123_432;

        BetterKrat<Olifant, Integer> betterOlifantKrat = new BetterKrat<>(olifant, kratSize);
    }
}
