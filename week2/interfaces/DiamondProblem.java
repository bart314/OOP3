package interfaces;

interface Foo {
    default String getLongDescription() {
        return "Lange beschrijving gekregen door de interface Foo.";
    }
}

interface Bar {
    default String getLongDescription() {
        return "Deze string komt bij Bar vandaan...";
    }
}


class DiamondProblem implements Foo, Bar {
    /*
     de methode getLongDescription is zowel gedefinieerd in de
     interfaces Foo en Bar, dus we moeten in deze klasse aangeven
     welke van beide we willen gebruiken. Als we dat niet doen,
     krijgen we een compile error.

     Let ook op de interessante syntax: Foo.super.method()
    */

    @Override
    public String getLongDescription() {
        return Foo.super.getLongDescription();
    }


    public static void main(String[] args) {
        var d = new DiamondProblem();
        d.getLongDescription();
    }
}
