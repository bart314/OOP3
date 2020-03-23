package carfactory;

enum Location {
    DEFAULT, EU, ASIA
}

enum CarType {
    SMALL, SEDAN, LUXURY
}

abstract class Car {

    public Car(CarType model, Location location){
        this.model = model;
        this.location = location;
    }

    protected abstract void construct();

    private CarType model = null;
    private Location location = null;


    @Override
    public String toString() {
        return "Model- "+model + " built in "+location;
    }
}


class LuxuryCar extends Car{
    public LuxuryCar(Location location)
    {
        super(CarType.LUXURY, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building luxury car");
        //add accessories
    }
}


class SmallCar extends Car {

    SmallCar(Location location) {
        super(CarType.SMALL, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building small car");
        // add accessories
    }
}


class SedanCar extends Car {

    SedanCar(Location location) {
        super(CarType.SEDAN, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building sedan car");
        // add accessories
    }
}