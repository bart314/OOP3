package template;

import com.thoughtworks.xstream.XStream;

public class XMLSerializer extends Serializer {

	@Override
	void serializeData() {
		XStream xs = new XStream();
		_sendableData = xs.toXML(_data);
	}
}
