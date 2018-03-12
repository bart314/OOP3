package decorator;

public class AESDecorator extends EncryptionDecorator {
	private String AESDecrypted;
	
	public AESDecorator(Encryptable txt) {
		super(txt);
		AESDecrypted = "\n\tAES Encrypted";
		System.out.println("AES Decorator created.");
	}

	// Deze methode wordt door de client (Demo in dit voorbeeld) aangeroepen. Deze vraagt eerst de algemene
	// functionaliteit van de Component aan (dat gebeurt in dit specifieke geval via de superklasse) en voegt er
	// vervolgens zijn eigen functionaleit aan toe.
	@Override
	public String getData() {
		String rv = super.getData();
		return rv + this.AESDecrypted;
		
	}

	@Override
	String showDecriptedData() {
		return null;
	}

}
