package decorator;

/*
Het fundamentele principe achter het decorator pattern is dat een bepaalde klasse, de *Component*, in runtime wordt
uitgebreid door een diversiteit aan decorerende klassen, de *Decorators*. Om dit voor elkaar te krijgen moeten zowel
de Component als de Decorators dezelfde interface implementeren.

Wanneer een Decorator vanuit een client (Demo in dit voorbeeld) wordt aangeroepen, delegeert deze eerst dezelfde
functionaliteit naar de Component en voegt er daarna zijn specifieke eigen functionaliteit aan toe. Zie het commentaar
bij de twee verschillende subklassen.

Deze klasse, ClearText, is de Component in dit voorbeeld. De twee subklassen van EncryptionDecorator zijn de
concrete Decorators.
 */

public class ClearText implements Encryptable {
	private String txt;
	
	ClearText(String value) {
		txt = value;
	}

	@Override
	public String getData() {
		return txt;
	}
}
