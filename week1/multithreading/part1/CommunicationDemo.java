package multithreading.part1;
import java.util.LinkedList;
import java.util.Queue;

/*
Deze klasse demonstreert de communicatie tussen verschillende Threads die gebruik maken van dezelfde shared resource.
Als voorbeeld van die resource wordt gebruik gemaakt van een Queue<Integer>. De eerste Thread, de Producer, stopt er
getallen in die de tweede Thread, de Consumer, er weer uit haalt. Om de demonstratie te vereenvoudigen zeggen we dat
de Queue vol is wanneer er vier elementen in zitten (een waarde die wordt bijgehouden in de variabele int qSize).

Wanneer de queue vol zit, wacht de Producer totdat de Consumer hem weer heeft leeggemaakt. Dit wachten gebeurt met de
methode *queue.wait()*. Als de queue dan weer helemaal leef is, verstuurt de Consumer een methode *queue.notify*.
Hierdoor worden alle objecten die op deze queue zitten te wachten (in ons geval is dat er maar één, die Producer, maar
het kunnen er vanzelfsprekend veel meer zijn) ervan op de hoogte gesteld dat de queue weer beschikbaar is.

Een goeie verdere uitleg van dit principe is te vinden op http://www.baeldung.com/java-wait-notify.
Zie ook de documentatie van Queue<E> en van LinkedList<E> op oracle:

  https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
  https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html

*/


public class CommunicationDemo {
    // de grootte van de queue
	static final int qSize = 4;

	// main entry point
	public static void main(String args[]) {
	    // de shared resource. We gebruiken een interface om onze intentie duidelijk te maken; als concrete
        // implementatie hebben we een LinkedList.
		final Queue<Integer> sharedQ = new LinkedList<>();

		// De twee Runnables. Beide krijgen een pointer naar dezelfde queue mee, die ze in hun interne logica
        // gebruiken. Er wordt in deze twee objecten dus geen kopie van de data gemaakt.
		Runnable producer = new Producer(sharedQ);
		Runnable consumer = new Consumer(sharedQ);

		new Thread(producer).start();
		new Thread(consumer).start();
	}

	static class Producer implements Runnable {
		private final Queue<Integer> sharedQ;

		Producer(Queue<Integer> sharedQ) {
			this.sharedQ = sharedQ;
		}
		
		@Override
		public void run() {
			int i=0;
			// Deze lus loopt oneindig; je kunt dit natuurlijk aanpassen naar je eigen wensen (maar zie ook de break-
            // condition in de consumer-klasse).
			while(++i>0) {

			    // de sharedQ moet synchronized zijn. Je kunt wel een wait/notify doen op een asynchrone queue, maar
                // dat is natuurlijk zinloos.
				synchronized (sharedQ) {
                    // de queue is vol
                    while (sharedQ.size() >= qSize) try {
                        System.out.println("Queue is full, waiting");
                        sharedQ.wait(); // Deze thread (de Producer) wacht totdat de queue weer leeg is.
                    } catch (InterruptedException ex) { // die wait() methode gooit een CheckedException.
                        ex.printStackTrace();
                    }

                    // als er niets aan de hand is, stoppen we gewoon het volgende getal in de queue en laten
                    // we eventuele andere threads (de Consumer in dit voorbeeld) weten dat er weer wat in de queue
                    // staat om geconsumeerd te worden.
					System.out.println("producing : " + i);
					sharedQ.add(i);
					sharedQ.notify();
				}
			}
		}
	}

	static class Consumer implements Runnable {
		private final Queue<Integer> sharedQ;

		Consumer(Queue<Integer> sharedQ) {
			this.sharedQ = sharedQ;
		}

		@Override
		public void run() {
			while(true) {
				synchronized (sharedQ) {
					// Deze thread blijft wachten totdat de queue ongelijk is aan nul.
					while (sharedQ.size() == 0) {
						try {
							System.out.println("        Queue is empty, waiting"); // even wat spaties toegevoegd
                            // omdat deze wait() blijft hangen totdat er vanuit een andere thread een notify wordt
                            // gegeven, wordt deze while-lus feitelijk maar één keer uitgevoerd.
							sharedQ.wait();
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}

					// Als we hier komen, is de queue dus gegarandeerd niet leeg en kunnen we er dus een element
                    // uit halen en uitprinten. Op dat moment is er ook weer ruimte voor nieuwe elementen, dus
                    // sturen we gelijk een notify() door, om de producer hiervan op de hoogte te stellen.
					int number = sharedQ.poll();
					System.out.println("        consuming : " + number );
					sharedQ.notify();

					//termination condition; die heb ik er voor deze demonstratie uit gehaald.
//					if(number == 3) break; 
				}
			}
		}
	}
}
