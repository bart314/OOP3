package observer;

import java.util.HashMap;

// Zie het commentaar in de klasse StockApp.

public interface Observer {
    
    public void update(HashMap<String, Integer> values);
 
}
