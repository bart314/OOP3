package sorting;

public class Developer implements Comparable<Developer> {
    String name;
    int age;

    Developer (String name, int age) {
        this.name = name;
        this.age = age;
    }

    int getAge() { return this.age; }
    
    String getName() { return this.name; }

    @Override
    public String toString() {
        return("name = " + this.name + " age = " + this.age);
    }


    /*
    De methode int compareTo(T o) wordt gedefinieerd door de interface Comparable. Hiermee geven we aan dat de klasse
    Developer vergeleken kan worden met andere Developers (vandaar die Generic in de interface-definitie hierboven).
    Op een abstracte manier werkt deze methode als volgt:

  	     a.compare(b)
		     return 0 iff a.equals(b)
				  (<0) -1 iff a < b
				  (>0) 1 iff a > b

	Dus we kunnen binnen deze methode aangeven of het object dat wordt meegestuurd (die b in het voorbeeld hierboven)
	hoger of lager in de lijst moet komen (of op dezelfde positie). Java (en vergelijkbare talen) hebben een low-level
	implementatie van die sortering, die gebruik maakt van verschillende algoritmen en afhankelijk van de context een
	selectie doet. Zie de onderstaande link voor een discussie hierover:

	https://www.quora.com/What-sorting-algorithm-is-used-by-Javas-Collections-sort-and-why

	Het voordeel van deze manier van werken is dat je de verantwoordelijkheid van het sorteren belegt bij de klasse
	waar het om gaat (Developer in dit geval). Eventuele cliënten hoeven alleen maar sort() aan te roepen op een
	collectie van deze objecten en hoeven zich niet druk te maken over de sortering zelf.

	Zie verder ook het commentaar in de klasse SortingDemo.
	*/


	@Override
	public int compareTo(Developer dev) {
	    // het sorteren gaat in principe op basis van de naam van de Developer. Omdat dit een eenvoudige String is,
        // kunnen we daarvan eenvoudig de methode compareTo(String o) gebruiken.
        // zie https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#compareTo-java.lang.String-
        //
        // Als we willen kunnen we natuurlijk ook op een ander veld van Developer sorteren.

		return this.getName().compareTo(dev.getName());
	}
}
