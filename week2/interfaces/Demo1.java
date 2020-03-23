package interfaces;


interface DemoInterface {
    // een interface kan ook velden bevatten
    int demo = 7;
    String omschrijving = "DemoInterface";

    // methode-definities zoals we gewend zijn
    String demofunction();
    void dingendoen(int a, int b);

    // maar je kunt ook standaard-implementatie hebben in je interface
    // zowel op object-niveau
    default String getLongDescription() {
        return String.format("Call vanuit de interface... %s", toString());
    }

    // als op het klasse-niveau
    static String getInterfaceDescription() {
        return "Een methode vanuit de interface die een string teruggeeft...";
    }

}


class Demo implements DemoInterface {
    private int tot;

    @Override
    public String demofunction() {
        return "Demo implements DemoInterface";
    }

    @Override
    public void dingendoen(int a, int b) {
        // maak ook gebruik van het veld in de geïmplementeerde interface
        this.tot = a + b + demo;
    }

    int getTotal() {
        return tot;
    }

    public static void main(String[] args) {
        // standaard gebruik van een interface
        DemoInterface d = new Demo();
        System.out.println(d.demofunction());
        d.dingendoen(3,4);

        // maar ook methoden aanspreken die in de interface zijn gedefinieerd
        System.out.println(d.getLongDescription());

        // of methoden op de interface zelf...
        System.out.println(DemoInterface.getInterfaceDescription());
    }
}
