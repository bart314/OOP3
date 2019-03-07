package template;

public class Demo {
	public static void main(String[] args) {
		
		//het algoritme is steeds hetzelfde;
		//er zit een klein verschil in de uiteindelijke implementatie van serializeData,
		//maar dat hoeft deze client niet te weten.
		
		Serializer demo = new JSONSerializer();
		demo.makeConnection();
		demo.getData();
		demo.serializeData();
		demo.sendData();
	}
}
