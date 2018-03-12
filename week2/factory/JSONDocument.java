package factory;

public class JSONDocument implements Document {

	@Override
	public void open() {
		System.out.println("Opening a json-document; probably via a network.");
	}

	@Override
	public void close() {
		System.out.println("Closing the json-document, and shutting down the network");
	}

	@Override
	public void save(String filename) {
		System.out.println("Saving the json-document as "+filename);
	}

}
