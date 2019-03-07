package factory;

/*
De klassen in deze package demonstreren de werking van het Factory Pattern:

    https://nl.wikipedia.org/wiki/Factory_(ontwerppatroon)

Er is een interface (of een abstracte klasse, maar in dit voorbeeld een interface) die aangeeft wat voor soort
typen de factory zoal kan maken. De verschillende conrete Factories implementeren deze interface en geven desgewenst
een concrete implementatie van dit soort type.

Het voordeel van dit patroon is dat er binnen de client (de Demo in dit voorbeeld) geen referentie bestaat naar een
concrete implementatie van een specifiek type. De client delegeert dit concrete geval naar de factory, die in runtime
veranderd kan worden.

In dit specifieke voorbeeld zijn er verschillende soorten Document's (zie de betreffende interface). Met een document
kun je verschillende dingen doen, maar bij verschillende concrete implementaties betekent dit iets anders (zie de
methoden in de verschillende klassen). Voor deze client is dat echter niet van belang: zolang de concrete
implementaties de juiste interface implementeren, kan ik hier eenvoudig (in runtime) switchen tussen
verschillende soorten documenten.

*/

public class Demo {
	public static void main(String[] args) {
        // Afhankelijk van wat ik op dit moment nodig heb, kan ik het concrete type van de variabele foo
        // makkelijk aanpassen. Het enige wat ik hoef te doen is de juiste Factory aanroepen, en de rest van de
        // code blijft onaangetast.
        // Ik kan ook eenvoudig een nieuw type Document toevoegen: daarvoor hoef ik hier feitelijk niets te
        // veranderen, behalve (opnieuw) de juiste Factory aanroepen.

		DocumentFactory factory = new TEXFactory();

		Document foo = factory.makeDocument();
		foo = factory.makeDocument();
		foo.open();
		foo.save("Nieuwe_naam");
		foo.close();
	}

}
