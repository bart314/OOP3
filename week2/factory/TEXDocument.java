package factory;

public class TEXDocument implements Document {

	@Override
	public void open() {
		System.out.println("Opening the TeX document in your favourite editor (vi of course).");
	}

	@Override
	public void close() {
		System.out.println("Closing the TeX document.");
	}

	@Override
	public void save(String filename) {
		System.out.println("Saving the TeX document as "+filename);
	}

}
