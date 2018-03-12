package factory;

public class HTMLDocument implements Document {

	@Override
	public void open() {
		System.out.println("Using a browser to open the html-document.");
	}

	@Override
	public void close() {
		System.out.println("What does it mean to close an html-document...?");
	}

	@Override
	public void save(String filename) {
		System.out.println("Saving the html on your local storage as "+filename);
	}

}
