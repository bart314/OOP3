package carfactory;


public abstract class AbstractCarFactory {
    /*
     Eventuele extra methoden die door de concrete factories geïmplementeerd zouden moeten worden
     moet je in deze klasse definiëren. Door gebruik te maken van het keywordt 'abstract' geef je de
     signature van de methoden aan, die vervolgens door de compiler kan worden opgepikt, bijvoorbeeld:

     abstract String getLongDescription();
     abstract boolean getSteeringWheelPosition();

     Vóór Java 8 was dit de enige manier waarop je dit kon doen. Dit had als nadeel dat elke klasse die
     overerfde van deze klasse deze specifieke methoden moest implementeren, wat nogal eens tot veel
     boilerplate-code leidde. Ook is er het probleem dat een klasse maar van één klasse kan overerven,
     dus als je wat complexere dingen wilde doen, kreeg je relatief snel een behoorlijk complexe
     hiërarchie.

     Zie de opmerkingen bij InterfaceCarFactory...
    */

    @SuppressWarnings("Duplicates")
    public static Car buildCar(int t, int loc) {
        Car car = null;

        CarType type = CarType.values()[t];
        Location location = Location.values()[loc];

        switch(location){
            case EU:
                car = EUCarFactory.buildCar(type);
                break;
            case ASIA:
                car = AsiaCarFactory.buildCar(type);
                break;
            default:
                car = DefaultCarFactory.buildCar(type);
        }

        return car;
    }



}