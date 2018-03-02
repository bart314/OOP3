package multithreading.part2;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.util.stream.IntStream;

/*

Deze klasse maakt geen gebruik van de static TextArea uit TextView. Merk op dat we nu bij de constructor een
TextArea als formele parameter verwachten, die we doorsturen naar de verschillende Runnables. Het voordeel
van deze constructie is dat het voor de gebruikende klassen niet uitmaakt hoe of wat die TextArea voor concrete
implementatie is. Het enige wat voor deze dingen van belang is, is dat het iets is waar we naartoe kunnen schrijven.
Een nog betere implementatie zou hier een interface verwachten.

Zie overigens het commentaar in de klasse TaskThreadDemo1
 */

public class TaskThreadDemo2 {
	// STAP 2
	public TaskThreadDemo2(TextArea textArea) {
		Runnable printA = new PrintChar('a', 100, textArea);
		Runnable printB = new PrintChar('b', 100, textArea); 
		Runnable print100 = new PrintNum(100, textArea);
		
		// Create threads
		Thread thread1 = new Thread(printA); 
		Thread thread2 = new Thread(printB); 
		Thread thread3 = new Thread(print100);
		
		// Start threads
		thread1.start();
		thread2.start();
		thread3.start();
	}


	static class PrintChar implements Runnable {
		private char charToPrint;
		private int times;
		private TextArea ta; // onze lokale verwijzing naar de textarea waarin geschreven moet worden.


        public PrintChar(char c, int t, TextArea ta) {
            charToPrint = c;
            times = t;
            this.ta = ta;
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
        We hoeven nu geen gebruik meer te maken van een concrete implementatie van die TextArea in de klasse
        TextView, omdat deze Runnable zelf beschikking heeft over de TextArea waarin geschreven moet worden.
         */

        @Override
        public void run() {
            Platform.runLater( () -> {
                for (int i=0;i<times;i++) {
                    this.ta.appendText(Character.toString(charToPrint));
                }
            });
        }
	}


	static class PrintNum implements Runnable {
		private int lastNum;
		private TextArea ta;
		
		public PrintNum(int n, TextArea ta) {
			lastNum = n;
			this.ta = ta;
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

		@Override
		public void run() {
			IntStream.range(0, lastNum).forEach( nr -> {
				Platform.runLater( () -> this.ta.appendText(Integer.toString(nr)) );
			});
		}
	}

}












