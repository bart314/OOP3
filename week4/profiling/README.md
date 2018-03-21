##Profiling##
De klassen in deze package kun je gebruiken om hprof uit te proberen, zoals ook tijdens de les is gedemonstreerd. Het is makkelijker om dit via de command line te doen dan via een IDE zoals Intellij, omdat je dan meer controle hebt over wat er gebeurt (en je geen gedoe hebt met packages).

Compileer de klassen met javac:

$ javac Fibon.java
$ javac MemTest.java

Run de programma's en check de output (die ik hier heb meegegeven met de agentlib):

java -agentlib:hprof=file=cpu_times.txt,cpu=times Fibon
java -agentlib:hprof=file=heap_sites.txt,heap=sites MemTest


