package json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;

import org.json.simple.JSONArray;;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
Deze klasse demonstreert het werken met JSON in java.
Ik maak hier gebruik van orj.json, wat niet de beste implementatie van JSON in Java is. Zie hiervoor

    https://github.com/fabienrenaud/java-json-benchmark

Voor de volledigheid heb ik hier ook een demo.json bestand aan toegevoegd. Het generieke formaat hiervan is

    [
        {"id":<id>, "artikel":<artikel_id>, "page":<page_num>, "quote":<long_text>},
    ]

Van belang is dat een JSONArray altijd één of meer JSONObject's bevat; daarom moet je eerst de array ophalen
en dan daarbinnen de objecten. Ik itereer over deze objecten heen door middel van een Iterator en door middel
van een lambda.
 */


public class Demo {
	public static void main(String[] args) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		String data = "";
		// de data haal ik van mijn locale machine, maar je kunt natuurlijk ook eenvoudig het bijgevoegde
        // json-bestand lezen.
		data = getData("http://localhost/~bart/demo.json");

		// We parsen de gegeven data en maken daar dan een JSONArray van. Op dat moment zitten er allemaal
        // JSONObject's in die obj.
		JSONArray obj = (JSONArray) parser.parse(data);

		// Itereren met een Iterator:
        // zie ook http://stackoverflow.com/questions/4296496/type-safety-warning-with-json-iterator

//		Iterator<JSONObject> itr = obj.iterator();
//		while (itr.hasNext()) System.out.println(itr.next());

        // Itereren met een lambda:
        obj.forEach( o -> System.out.println(o));

	}

	/*
	Lezen van data van een een remote source. Geen tentamenstof, maar wel nuttig om even te besturen.
	 */

	static String getData(String url) throws IOException {
		InputStream str = new URL(url).openStream();
		String rv;

		BufferedReader rd = new BufferedReader(new InputStreamReader(str, Charset.forName("UTF-8")));
		StringBuilder builder = new StringBuilder();
		int input;
		while ((input = rd.read()) != -1) {
			builder.append((char)input);
		}
		rv = builder.toString();

		return rv;
	}
}
