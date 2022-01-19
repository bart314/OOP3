package group;

public interface GroupState {
    void work(Group ctx);
    void revert(Group ctx);
    void commit(Group ctx);
}

class SpecificationState implements GroupState {

    @Override
    public void work(Group ctx) {
        System.out.println("Projectgroep is specificaties aan het bepalen");
    }

    @Override
    public void revert(Group ctx) {
        throw new IllegalStateException("Er is geen vorige state...");
    }

    @Override
    public void commit(Group ctx) {
        System.out.println("Opstellen van specs is nu  wel klaar. ");
        System.out.println("Nu gaan we lekker programmeren!");
        ctx.setState(new DevelopState());
    }

    @Override
    public String toString() {
        return "We zijn nog bezig met requirements op te stellen.";
    }
}

class DevelopState implements GroupState {

    @Override
    public void work(Group ctx) {
        System.out.println("Still crunching code.");
        System.out.println("Pulling all-nighters; bring on the pizza and the coffee!!");
    }

    @Override
    public void revert(Group ctx) {
        System.out.println("Oh oh, specs are not complete yet!");
        System.out.println("We gaan terug naar de drawingboard");
        ctx.setState(new SpecificationState());
    }

    @Override
    public void commit(Group ctx) {
        System.out.println("Code is wel zo'n beetje klaar. Maar eens gaan kijken of het ook voldoet aan de specs");
        System.out.println("(Dit is natuurlijk een ideale situatie; dit gebeurt in het echt zelden");
        ctx.setState(new ValideState());
    }

    @Override
    public String toString() {
        return "Nog steeds druk aan het programmeren.";
    }

}

class ValideState implements GroupState {

    @Override
    public void work(Group ctx) {
        System.out.println("Still validating...");
        System.out.println("Pakken de volgende spec en kijken of de code daar aan voldoet.");

    }

    @Override
    public void revert(Group ctx) {
        System.out.println("Uh oh, we zijn een bepaalde requirement vergeten. Terug naar het programmeren!");
        ctx.setState(new DevelopState());
    }

    @Override
    public void commit(Group ctx) {
        System.out.println("Nou, lijkt allemaal wel ok te zijn.");
        System.out.println("Ik zeg checken of we iets kunnen verbeteren");
        ctx.setState(new EvaluateState());
    }

    @Override
    public String toString() {
        return "Project wordt momenteel gevalideerd.";
    }

}

class EvaluateState implements GroupState {

    @Override
    public void work(Group ctx) {
        System.out.println("Nog steeds code review");
        System.out.println("Alle code is slecht en zou verbeterd moeten worden");
    }

    @Override
    public void revert(Group ctx) {
        System.out.println("Zo'n erge refactoring gevonden dat we dit eigenlijk niet kunnen opleveren.");
        System.out.println("We gaan terug naar de ontwikkelfase");
        ctx.setState(new DevelopState());
    }

    @Override
    public void commit(Group ctx) {
        System.out.println("Alles check! Ik zeg opleveren die handel.");
        ctx.setState(new EndState());
    }

    @Override
    public String toString() {
        return "Project zit in de evuatiefase.";
    }
}

//SINKHOLE STATE
class EndState implements GroupState {
    @Override
    public void work(Group ctx) {
        System.out.println("Man, dit project is allang afgerond.");
    }

    @Override
    public void revert(Group ctx) {
        System.out.println("Man, dit project is allang afgerond.");
    }

    @Override
    public void commit(Group ctx) {
        System.out.println("Man, dit project is allang afgerond.");
    }

    @Override
    public String toString() {
        return "Project is afgerond.";
    }
}

