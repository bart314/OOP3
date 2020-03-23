package carfactory;

import java.util.Scanner;

/**
 * Voorbeeld gebaseerd op
 * https://howtodoinjava.com/design-patterns/creational/implementing-factory-design-pattern-in-java/
 *
 * Wel de nodige aanpassingen daarop doorgevoerd.
 */

public class Runner {
    private static boolean isValidInteger(String s) {
        try {
            int i = Integer.parseInt(s);
            if (i<1 || i>3) return false;
        } catch (Exception e) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println("Welkom bij de abstracte car factory. Maak hieronder uw keuze:");
        while (true) {
            Scanner scanner = new Scanner (System.in);

            System.out.println("Wat voor soort auto?");
            System.out.println("  [1] klein\n  [2] sedan\n  [3] luxe uitvoering");
            String val = scanner.next();
            if (!isValidInteger(val)) {
                System.out.println("Voer een getal tussen 1 en 3 in.");
                continue;
            }
            int type = Integer.parseInt(val)-1;

            System.out.println("Waar moet -ie gemaakt worden?");
            System.out.println("  [1]  Standaard\n  [2]  Europa\n  [3]  Azië");
            val = scanner.next();
            if (!isValidInteger(val)) {
                System.out.println("Voer een getal tussen 1 en 3 in.");
                continue;
            }
            int loc = Integer.parseInt(val)-1;

            Car c = InterfaceCarFactory.buildCar(type, loc);
            System.out.println(c);

        }
    }
}
