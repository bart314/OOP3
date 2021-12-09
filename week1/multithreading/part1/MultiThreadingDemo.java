package multithreading.part1;

/*
Deze eenvoudige klasse demonstreert de werking van Threads. We maken hierin twee objecten aan die allebei een bepaald
aantal keer een bepaalde string uitprinten ("dingen" en "aardappelen"). Als je dit runt, zul je zien dat deze twee
woorden door elkaar in de console verschijnen, zonder dat je controle hebt over wanneer wat verschijnt of zonder dat
er twee keer hetzelfde patroon uitkomt (anders dan door toeval). De kernel van het OS geeft de threads om en om de
voorrang.
De algemene structuur hiervan zie je in de main. Je maakt een Runnable object die je vervolgens aan een nieuw Thread-
object meegeeft. Daarna start je die thread op. Je roept dus nooit direct de methode run() aan op de Runnable zelf:
dat is de verantwoordelijkheid van die Thread.

Bekijk ook de documentatie van Runnable en van Thread op oracle:

  - https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html
  - https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html
 */

public class MultiThreadingDemo {
    // main entry point
	public static void main(String[] args) {
	    // Twee runnable objecten. Ze krijgen de string mee die ze moeten uitprinten en hoe vaak. Om de twee Threads
        // visueel duidelijk van elkaar te kunnen onderscheiden geef ik ze ook een aantal spaties mee dat ze moeten
        // printen voordat ze het woord uitprinten.
		Runnable r1 = new Runner("dingen", 100, 0);
		Runnable r2 = new Runner("aardappelen", 75, 8);

		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);

		th1.start();
		th2.start();
	}


	// Elke klasse die je door een Thread wilt laten runnen, moet de interface Runnable implementeren. Dit omdat de
    // Thread intern de methode run() aanroept, en dan moet je wel zeker weten dat die er is.
	static class Runner implements Runnable {
		private String printable;
		private int numberOfTimes;
		private int spaces;

		public Runner (String foo, int times, int s) {
			printable = foo;
			numberOfTimes = times;
			spaces = s;
		}


		@Override
		public void run() {
			for (int i=0; i<numberOfTimes; i++) {
				System.out.println(" ".repeat(spaces));
				System.out.println(String.format("Running and printing %s.",printable));
			}
		}
	}

}
