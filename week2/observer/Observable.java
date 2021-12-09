package observer;

// Zie het commentaar in de klasse ObserverImpl

public interface Observable {
    
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObservers();

}
