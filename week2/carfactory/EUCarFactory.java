package carfactory;

public class EUCarFactory {
    public static Car buildCar(CarType model) {
        Car car = null;

        switch (model) {
            case SMALL:
                car = new SmallCar(Location.EU);
                break;

            case SEDAN:
                car = new SedanCar(Location.EU);
                break;

            case LUXURY:
                car = new LuxuryCar(Location.EU);
                break;

            default:
                //throw some exception
                break;
        }
        return car;
    }
}