package factory;

/*
Deze interface wordt door de concrete Factory's geïmplementeerd. Afhankelijk van het type Document dat
gevraagd wordt (door de Client, de Demo-klasse in dit voorbeeld) geven de concrete Factory's een ander
soort Document terug.
Om een wildgroei aan klassen in deze package te voorkomen, heb ik zowel de interface als de implementerende
klassen even in hetzelfde bestand gezet. En het maakt het misschien ook wel wat duidelijker om dit allemaal
bij elkaar te hebben.

Het is van belang op te merken dat alléén bij de concrete Factory's hieronder een referentie gemaakt wordt
naar de concrete Document-klassen; overals elders in de code wordt gebruik gemaakt van de Factory, die
verantwoordelijk is voor het teruggeven van het juiste type document.
*/

interface DocumentFactory {
	
	Document makeDocument();

}

class JSONFactory implements DocumentFactory {

	@Override
	public Document makeDocument() {
		System.out.println("Let's make an awesome JSON document.");
		return new JSONDocument();
	}
	
}


class HTMLFactory implements DocumentFactory {

	@Override
	public Document makeDocument() {
		System.out.println("This is making a HTML document.");
		return new HTMLDocument();
	}
	
}


class TEXFactory implements DocumentFactory {

	@Override
	public Document makeDocument() {
		System.out.println("This to to make a TeX Document");
		return new TEXDocument();
	}
	
}