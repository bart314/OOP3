package decorator;

/*
Dit is een implementatie van de discussie op http://bit.ly/2mjNwXA
De gedachte achter het decorator pattern (https://en.wikipedia.org/wiki/Decorator_pattern):

    - Responsibilities should be added to (and removed from) an object dynamically at run-time.
    - A flexible alternative to subclassing for extending functionality should be provided.

De module ondersteunt een encryptie in DES of in AES. Je kunt een stuk platte
tekst versleutelen via één van deze twee algoritmen, of via een combinatie hiervan.
Als je hiervoor overerving zou gebruiken, zou je vier verschillende objecten moeten
maken: AES, DES, AES+DES en DES+AES. En als er meer algoritmen ondersteund moeten
worden, moet je navenant meer objecten maken.

De oplossing is gelegen in compositie (favour composition over inheritance). Door
gebruik te maken van het decorator-pattern kun je in run-time verschillende composities
maken – en je kunt het ook eenvoudig weer uit elkaar trekken.

Behalve deze klasse bevat deze package vier klassen en één interface. De klasse ClearText
is als het ware de basisklasse, die kan worden 'gedecoreerd' met een EASDecorator of met
een DESDecorator. Deze beide decorators zijn weer subklassen van EncryptionDecorator.

Merk op dat EncryptionDecorator de interface Encryptable *implementeert* én een veld van
het type EncryptionDecorator *bevat*. Deze decorator *is* dus een Enctryptable (is-a)
en *heeft* dus een Encryptable (has-a). Dit is een fundamenteel gegeven voor dit pattern.

Bestudeer de verschillende klassen en het daarbij gegeven commentaar voor de duidelijkheid.
Een andere uitwerking van hetzelfde pattern vind je in de package Pizza.
*/

public class Demo {
	public static void main(String[] args) {
	    // We maken een object met platte tekst. Omdat de klasse ClearText de interface
        // Encryptable implementeert, kunnen we dit gebruiken als statisch datatype.
		Encryptable demo = new ClearText("Een stuk platte tekst...");
		System.out.println(demo.getData());

		// Dat object dat we net hebben gemaakt, kunnen we decoreren met een AESDecorator.
        // Dat ding verwacht bij z'n constructie een Encryptable, wat de klasse ClearText
        // toevallig ook nog is.
		EncryptionDecorator aes = new AESDecorator(demo);
		System.out.println(aes.getData());

		// Dat object kunnen we op zijn beurt weer decoreren met een DESDecorator. Ook
        // dat ding verwacht bij z'n constructor een Encryptable, wat ook die andere
        // decorator is (daarom moeten al die decorators dezelfde interface implementeren).
		EncryptionDecorator des = new DESDecorator(aes);
		System.out.println(des.getData());	
	}
}
