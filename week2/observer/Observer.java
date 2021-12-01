package observer;

import java.util.HashMap;
import java.util.Map;

// Zie het commentaar in de klasse StockApp.

public interface Observer {
    
    public void update(Map<String, Integer> values);
 
}
