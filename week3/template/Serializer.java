package template;

import java.util.HashMap;
import java.util.Map;

public abstract class Serializer {
	protected Map<String, String> _data;
	protected String _sendableData;
	
	void makeConnection() {
		_data = new HashMap<>();
		System.out.println("Making database connection.");
	}
	
	void getData() {
		_data.put("locus", "woord");
		_data.put("zwitserland", "dal");
		_data.put("thee", "theepot");
		_data.put("gerotzooi", "gehannes");
		_data.put("een", "de");
		_data.put("fietspomp", "fietsventiel");
		_data.put("thee", "茶");
		_data.put("chinees", "中文电影");
	}
	
	abstract void serializeData();
	
	public void sendData() {
		System.out.println("Sending data");
		System.out.println(_sendableData);
	}	
}
