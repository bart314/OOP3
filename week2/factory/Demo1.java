package factory;

public class Demo1 {

    public static void main(String[] args) {
        // we zitten in een web-omgeving, halen json-data op en schrijven die weer weg

        Document jsonDocument = new JSONDocument();
        jsonDocument.open();
        jsonDocument.save("demo.json");
    }

}
