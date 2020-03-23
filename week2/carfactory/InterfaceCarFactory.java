package carfactory;


public interface InterfaceCarFactory {
    /*
    Door gebruik te maken van de mogelijkheid die Java8 biedt om implementatie in een
    interface te zetten, kunnen we abstracte factory een interface maken, waarbij het
    daadwerkelijk aanmaken van een concrete factory in de interface gedaan wordt.

    Eventuele andere methode die die diverse factories individueel zouden moeten
    implementeren, definieer je vervolgens gewoon in deze interface, zoals je dat
    gewend bent:


    // String getLongDescription();
    // boolean getSteeringWheelPosition();

    Zie verder de opmerkingen bij AbstractCarFactory...
    */



    @SuppressWarnings("Duplicates")
    static Car buildCar(int t, int loc) {
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
