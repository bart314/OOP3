package decorator;

/*
Deze abstracte klasse is de superklasse van de twee Decorators in dit voorbeeld. Van belang is op te merken dat
dit zowel een Encryptable *is* als een Encrytable *heeft* (is-a en has-a). Dit is noodzakelijk om de Component (de
klasse ClearText) in runtime uit te kunnen breiden met specifieke functionaliteit.
 */

abstract class EncryptionDecorator implements Encryptable {
	protected Encryptable clearTxt;

	public EncryptionDecorator(Encryptable txt) {
		this.clearTxt = txt;
		System.out.println("superclass EncryptionDecorator created.");
	}

	// Deze methode roept de algemene functionaliteit van de Component aan en retourneert dit aan de specifieke
    // implementaties, die er hun eigen functionaliteit aan toevoegen.
	public String getData() {
		return this.clearTxt.getData();
	}

	// De echte implementatie van een encryptie en decryptie is 'left as an exercise to the reader'...
	abstract String showDecriptedData();
}
