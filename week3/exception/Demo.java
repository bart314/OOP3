package exception;

import org.omg.SendingContext.RunTime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.MissingResourceException;

/*
Deze klasse demonstreert verschillende manieren van werken met Exceptions.
Bestudeer de verschillende methoden, en ook de uitgecommentarieerde niet-compilerende
methoden hieronder.

Van belang is het onderscheid tussen checked Exceptions en RuntimeExceptions. Elke checked
Exception vereist een zogenaamde catch or declare: je moet die Exception's ofwel afvangen
binnen een try/catch-blok ofwel in de signature van de betreffende methode meenemen.
 */

public class Demo {

    // Elke checked Exception die niet in de methode wordt afgevangen, moet worden opgenomen
    // in de signature van de methode.
    public void demo0() throws IOException {
        Path p = Paths.get("/Users/docent/Desktop/demo.txt");
        String text = new String(Files.readAllBytes(p));
        LocalDate d = LocalDate.parse(text);
    }


    // Exception's van je af van specifiek naar algemeen, dus catch (Exception e) komt
    // altijd als laatste blok (als -ie al voorkomt).
    // De methode hieronder heeft behoorlijk wat duplicate code. In de methode demo2() is
    // is dat verwijderd, maar wel op een behoorlijk grove manier. De methode demo3() is
    // wat dat betreft nog de beste. Let ook op de manier hoe je van een checked Exception
    // een RunTimeException kunt maken (zodat je niet al je signatures hoeft aan te passen
    // maar de fouten wel ergens hoog in je stack trace kun opvangen).
    public void demo1() {
        try {
            Path p = Paths.get("/Users/docent/Desktop/demo.txt");
            String text = new String(Files.readAllBytes(p)); // throws IOException (en nog een paar andere)
            LocalDate d = LocalDate.parse(text); // throws DateTimeParseException
            System.out.println(d);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void demo2() {
        try {
            Path p = Paths.get("/Users/docent/Desktop/demo.txt");
            String text = new String(Files.readAllBytes(p));
            LocalDate d = LocalDate.parse(text);
            System.out.println(d);
        } catch (Exception e) {
            // Afvangen van een algemene Exception is bad practice
            // https://stackoverflow.com/questions/114658/catching-base-exception-class-in-net
            // (voorbeeld in C#, maar hetzelfde geldt voor Java).
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void demo3() {
        try {
            Path p = Paths.get("/Users/docent/Desktop/demo.txt");
            String text = new String(Files.readAllBytes(p));
            LocalDate d = LocalDate.parse(text);
            System.out.println(d);
        } catch (DateTimeParseException | IOException e) {
            // multi-catch block. Let op de syntax hierboven en de locatie van de variabele e.
            // https://docs.oracle.com/javase/8/docs/technotes/guides/language/catch-multiple.html
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /*
    De onderstaande twee methoden compileren niet; ik heb ze om die reden uitgecommentarieerd. Bedenk
    waar de fout zit.
    De tweede van deze voorbeelden is wel erg vergezocht, maar als exercitie is het niet slecht om eens
    na te gaan waar de fouten zitten (tip: het zijn er vier).
     */

    /*
    public void doesNotCompile1() {
        try {
            Path p = Paths.get("/Users/docent/Desktop/demo.txt");
            String text = new String(Files.readAllBytes(p));
            LocalDate d = LocalDate.parse(text);
            System.out.println(d);
        } catch (Exception | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void doesNotCompile2() {
        try {
            //
        } catch (FileNotFoundException | IllegalStateException e) {
        } catch (InputMismatchException e |MissingResourceException e){
        } catch(IndexOutOfBoundsException | ArrayIndexOutOfBoundsException e){
        } catch(FileNotFoundException | IllegalArgumentException e) {
        } catch (Exception e) {
        } catch (IOException e) {
    }
    */


}
