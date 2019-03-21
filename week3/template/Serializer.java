package template;

import java.util.HashMap;
import java.util.Map;

public abstract class Serializer {
	protected Map<String, String> data;
	protected String sendableData;
	
	void makeConnection() {
		data = new HashMap<>();
		System.out.println("Making database connection.");
	}
	
	void getData() {
		data.put("locus", "woord");
		data.put("zwitserland", "dal");
		data.put("thee", "theepot");
		data.put("gerotzooi", "gehannes");
		data.put("een", "de");
		data.put("fietspomp", "fietsventiel");
		data.put("thee", "茶");
		data.put("chinees", "中文电影");
	}
	
	abstract void serializeData();
	
	public void sendData() {
		System.out.println("Sending data");
		System.out.println(sendableData);
	}	
}
