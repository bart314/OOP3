package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingDemo {

	// Main entry point
	public static void main(String[] args) {
	    // We hebben een List met Developers; die lijst wordt hieronder (in de private method getDeveloper()) gevuld
        // met wat voorbeelddata.
		List<Developer> listDevs = getDevelopers();

		// Even over de List heen lopen om te kijken wat er in zit.
		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}

		/*
		Er zijn verschillende manieren om een lijst te sorteren. Je kunt natuurlijk zelf een ordering schrijven, maar
		dat kost veel tijd en kan behoorlijk complex worden. Java (en andere talen) hebben hier specifieke constructies
		voor, waarbinnen de optimalisatie op een behoorlijk laag niveau geregeld is.

		In Java hebben we twee interfaces hiervoor:

		 *** Comparable<T> ***
		 https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html

		 Deze interface heeft één methode: int compareTo(T o). Klassen die deze interface implementeren, moeten in deze
		 methode aangeven hoe objecten van deze klasse zich verhouden tot andere objecten van dezelfde klasse. Dus als je
		 bijvoorbeeld die Developers hebt, dan moet je aangeven of de ene Developer hoger of lager is dan een andere Developer
		 die daarmee vergeleken wordt.
		 Bekijk verder het commentaar in de compareTo-methode in Developer.

		 *** Comparator<T> ***
		 Comparator<T>: https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html

		 Dit is een zogenaamde *functionele interface*, wat betekent dat we hem kunnen gebruiken binnen een lambda-
		 expressie. Deze interface is een stuk uitgebreider dan de Comparable, maar in principe werkt hij hetzelfde.
		 Het enige relatief grote verschil met Comparable (behalve dat dit een functionele interface is), is dat deze
		 gebruik wordt binnen de cliënten van het object dat je wilt sorteren. De methode die je hiervoor moet gebruiken
		 is int compare(T o1, T o2), die min of meer hetzelfde werkt als de methode compareTo in Comparabel. Zie hiervoor
		 ook het commentaar in Developer.
		 */

		// We kunnen de lijst op verschillende manieren sorteren. Hieronder worden er drie uitgewerkt. Bestudeer de
        // code om er een idee bij te krijgen.

        // 1. traditioneel met een inner anonymous object
        // Merk op dat we hierbij niet de waarde van de List hoeven terug te geven aan een variabele: het sorteren
        // gebeurt op de lijst zelf.
        listDevs.sort(new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        // 2. We kunnen ook gebruik maken van de static method sort() in de java.util.Collections-package. Deze maakt
        // gebruik van de methode compareTo() die we in Developer hebben gedefinieerd. Dit kan dus alleen maar als de
        // objecten die in die lijst zitten allemaal Comparable zijn.
        Collections.sort(listDevs);

//      // 3. De manier die we bij voorbeeld 1 hebben laten zien, kunnen we ook herschrijven als een lambda-expressie
        // (feitelijk kan dat altijd waar je gebruik maakt van een anonymous inner class). Omdat we het sorteren in
        // dat geval delegeren naar een Stream van de List, moeten we het na het sorteren we verzamelen en in een nieuwe
        // variabele zetten.

		listDevs = listDevs.stream()
			.sorted( (dev1, dev2) -> dev1.getName().compareTo(dev2.getName() ))
			.collect( Collectors.toList());


		System.out.println("");
		System.out.println("After Sort");
		
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}
	}


	private static List<Developer> getDevelopers() {
		List<Developer> result = new ArrayList<>();

		result.add(new Developer("Henk", 33));
		result.add(new Developer("Tanja", 25));
		result.add(new Developer("Peter", 24));
		result.add(new Developer("Karel", 26));

		return result;
	}
}
