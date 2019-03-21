package template;

import java.util.Arrays;

import org.json.JSONArray;

public class JSONSerializer extends Serializer {

	@Override
	void serializeData() {
		JSONArray array = new JSONArray(Arrays.asList(data));
		sendableData = array.toString();
	}
	

}
