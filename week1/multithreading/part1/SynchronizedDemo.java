package multithreading.part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

    /*
    Deze code demonstreert de werking van synchronized. Als je met meerdere threads dezelfde resource wilt gebruiken,
    loop je kans dat updates of reads niet doen wat je verwacht dat ze doen.

        Thread 1     Resource    Thread 2
           |            |           |
       1   |  <------R  |           |
       2   |            | R------>  |
           |            |           |
       3   |  W------>  |           |
           |            |           |
       4   |            | <------W  |
           |            |           |
           |            |           |

    In het plaatje hierboven lezen zowel Tread 1 (op moment 1) als Thread 2 (op moment 2) de gedeelde resource.
    Op moment 3 schrijft Thread 1 iets naar die resource terug, maar die update wordt overschreven doordat Thread 2 op
    moment 4 iets anders naar diezelfde resource schrijft. Deze situatie staat bekend onder de naam *lost update*.

    Om dit te voorkomen moet je aangeven dat die resource synchronized is. Dat kan op verschillende manieren.
     */

    /*
    Overigens komt het te vaak voor dat sum na de run ondanks de synchronized toch nog minder dan 1000 is. Dat kan
    alleen maar te maken hebben met de implementatie van de Threads door het operating system. Ik kan het zelf niet
    reproduceren, dus het is lastig om hier iets zinnigs over te zeggen.
    java version "1.8.0_25"
    Java(TM) SE Runtime Environment (build 1.8.0_25-b17)
    Java HotSpot(TM) 64-Bit Server VM (build 25.25-b02, mixed mode)
    OS-X 10.9.5
     */

public class SynchronizedDemo {
    private static final int nrThreads = 1000;
    static Integer sum = 0;

    // main entry point
    public static void main (String[] args) {
        /*
        We maken duizend Threads aan die allemaal 1 bij de variabele sum optellen. In principe zou aan het eind van de
        rit die variabele dus de waarde 1000 moeten hebben. Maar als we die sum niet synchronized maken, is er een
        gerede kans dat het optellen door een Thread niet is doorgevoerd, of wordt overschreven door een andere
        Thread.
        Om dit te voorkomen moeten we in de run-methode binnen de Thread de resource (sum) synchronized maken.
         */

        ExecutorService executor = Executors.newFixedThreadPool(nrThreads);
        for (int x = 0; x < nrThreads; x++) {
            executor.execute(new addOneSafe());
        }

        while(executor.isTerminated() ) {
        }        
        executor.shutdown();
        
        System.out.print("sum = " + sum);
    }


    static class addOneSafe implements Runnable {
        // Binnen deze methode synchronizeren we de variabele sum, zodat die gelockt wordt op het moment dat een
        // Tread daar naartoe wil schrijven.
        @Override
        public void run() {
            synchronized (sum) {
                sum++;
            }
        }
    }

    static class addOneNotSafe implements Runnable {
        // Deze methode telt 1 op bij de sum, maar zonder dat die resource gelockt is op het moment dat er een Thread
        // naartoe schrijft.
        public void run(){
            sum++;
        }
    }
}