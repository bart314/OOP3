package state;

/*
Deze klasse is de zogenaamde *context klasse*. Deze klasse definieert geen directe interactie, maar delegeert deze
naar de diverse States. Op deze manier is het gedrag van de machine onafhankelijk gemaakt van de verschillende
statussen. Hierdoor kun je eenvoudig statussen toevoegen of verwijderen, zonder dat je de bestaande statussen of de
context klasse aan hoeft te passen.

Natuurlijk is het wel zo dat als de machine zelf wordt uitgebreid zodat deze bijvoorbeeld ook munten van twintig
cent accepteert, je de State-interface (en dus ook de States zelf) zult moeten aanpassen. Maar dat is ook logisch,
want een dergelijke verandering vertelt iets over hoe de machine zelf werkt.

 */



public class ColaMachine {
    // Een privaat veld waarin we bijhouden in welke status de machine zich momenteel bevindt.
    // Als de machine wordt opgestart, wordt dit veld op 'StartState' gezet.
	private State curState;
	
	ColaMachine() {
		setState(new StartState());
	}

	/*
	De machine accepteert munten. Afhankelijk van de staat waarin deze zich nu bevindt, moet er iets
	gebeuren. Dat wat er precies moet gebeuren, wordt echter gedelegeerd aan de concrete State-klassen; dat gebeurt
	in de methode hieronder. Deze methode wordt aangeroepen vanaf de command-line interface die in Demo is
	opgetuigd.
	 */
	void insertMoney(int howMuch) {
		System.out.println("Received " + howMuch);
		if (howMuch==50) curState.insertFiftyCents(this);
		else if (howMuch==100) curState.insertOneEuro(this);
		else System.out.println("Coin rejected.");
	}
	
	void giveStatus(String feedback) {
		System.out.println(feedback);
	}
	
	void giveCola() {
		System.out.println("Lekker veel suiker en caffeïne; enjoy");
		System.out.println("Saldo: weer nul.");
		System.out.println("Werp geld in:");
		
	}
	
	void returnMoney(int amount) {
		System.out.println("Geld terug: " + amount);
	}

	// De getters en setters van het private veld state worden aangeroepen door de concrete State-klassen.
	void setState (State newState) {
		curState = newState;
	}
	
	State getState() {
		return curState;
	}
	

}
