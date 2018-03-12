package factory;

/*
Dit is de interface die door alle document-klassen wordt geïmplementeerd. Daardoor weten alle clients dat de
concrete klassen die ze terugkrijgen van de betreffende Factory's wat ze er wel en niet mee kunnen doen.
*/

public interface Document {
	public void open();
	public void close();
	public void save(String filename);
}

