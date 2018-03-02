package multithreading.part2;

import java.util.stream.IntStream;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import javax.xml.soap.Text;

/*
Deze klasse is een refactoring van de originele ThreadDemo-klasse van Blackboard.
 */

public class TaskThreadDemo1 {
	// STAP 2
	public TaskThreadDemo1() {
		Runnable printA = new PrintChar('a', 100);
		Runnable printB = new PrintChar('b', 100);
		Runnable print100 = new PrintNum(100);
		
		// Create threads
		Thread thread1 = new Thread(printA); 
		Thread thread2 = new Thread(printB); 
		Thread thread3 = new Thread(print100);
		
		// Start threads
		thread1.start();
		thread2.start();
		thread3.start();
	}

    /*
    Eén van de twee Runnables. De details die ik in deze klasse beschrijf gelden ook voor de andere Runnable die
    hieronder staat. In die tweede gebeurt nog wel iets interessants, dus check het specifieke commentaar daar ook
    nog even (bij de methode run() ).
    */

	static class PrintChar implements Runnable {
		private char charToPrint;
		private int times;

        public PrintChar(char c, int t) {
            charToPrint = c;
            times = t;
        }

        /*
        *** ORIGINELE CODE ***
        Deze run-methode is de methode zoals die in de orinele opgave stond. Hier wordt het te printen character een-
        voudig naar de console geschreven. De opgave is dus om deze naar de textArea van de TextView-klasse te laten
        schrijven. Ik heb de methode hier laten staan voor referentie-doeleinden.

        @Override
        public void run() {
            for (int i=0; i<times; i++) {
                System.out.println(Character.toString(charToPrint));
            }
        }
        */

        /*
        *** EERSTE POGING ***
		De eerste methode die je zou kunnen overwegen om dit probleem op te lossen is door gebruik te maken van de static
		public TextArea in de TextView-klasse. Omdat dit een klasse-variabele is, kunnen we die via de klasse opvragen. Zie
		ook de documentatie daar.

		Als je dit op deze manier modelleert, krijg je echter een IllegalStateException: Not on FX application thread;
		Dat houdt in dat de thread waarop de javafx-applicatie draait niet zonder meer benaderbaar is vanuit de thread
		waarop je deze run()-methode aanroept. Omdat je geen controle hebt over wanneer welke thrad actief is en wanneer
		deze op de achtergrond draait, kun je er niet zomaar van uitgaan dat de communicatie tussen deze twee vanzelf
		goed gaat.

        @Override
        public void run() {
            for (int i=0;i<times;i++) {
                TextView.textArea.appendText(Character.toString(charToPrint));
            }
        }
        */

        /*
        *** TWEEDE POGING ***
        Om het bovenstaande probleem op te lossen, moet je gebruik maken van de constructie Platform.runLater(). Deze
        zorgt ervoor dat datgene wat je gerund wilt hebben als het ware op een queue wordt gezet, zodat de controle van
        het runnen wordt gedelegeerd aan hetzelfde systeem als dat de threads controlleert. Zie ook de documentatie van
        deze methode op Oracle:

        https://docs.oracle.com/javase/8/javafx/api/javafx/application/Platform.html#runLater
        */

        @Override
        public void run() {
            Platform.runLater( () -> {
                for (int i=0;i<times;i++) {
                    TextView.textArea.appendText(Character.toString(charToPrint));
                }
            });
        }
	}


	static class PrintNum implements Runnable {
		private int lastNum;
		
		public PrintNum(int n) {
			lastNum = n;
		}

		/*
		*** ORIGINELE CODE ***
		@Override
        public void run() {
		    for (int i=0;i<lastNum; i++) {
		        System.out.println(Integer.toString(i));
            }
        }
        */

		/*
		De ondestaande methode lijkt misschien een valide herschrijving van de bovenstaande run, maar het probleem
		is dat de variabele i niet bekend is binnen de scope van de lambda. Elke lambda-expressie is zijn eigen
		object, dus met z'n eigen scope en variabelen. Om een variabele te gebruiken van de 'enclosing scope', moet
		deze variabel 'effectively final' zijn: dat wil zeggen dat je hem binnen de lambda niet verandert (feitelijk
		alsof je het sleutelwoord 'final' erbij hebt gezet).

		@Override
        public void run() {
			for (int i=0;i<lastNum; i++) {
				Platform.runLater( () -> {
					ta.appendText(Integer.toString(i));
				});
			}
        }
        */

		/*
		Om dit probleem op te lossen, kun je een stream maken van Integers. Daarbij itereer je dan niet over de
		verzameling zelf, maar creëren een nieuwe stream van integers waar ja dan wél overheen kunnen loopen.
		Binnen die loop is het nummer van de iteratie vanzelfsprekend wel bekend.

		https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
		 */

		@Override
		public void run() {
			IntStream.range(0, lastNum).forEach( nr -> {
				Platform.runLater( () -> TextView.textArea.appendText(Integer.toString(nr)) );
			});
		}
	}

}












