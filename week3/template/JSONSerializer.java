package template;

import java.util.Arrays;

import org.json.JSONArray;

public class JSONSerializer extends Serializer {

	@Override
	void serializeData() {
		JSONArray array = new JSONArray(Arrays.asList(_data));
		_sendableData = array.toString();
	}
	

}
