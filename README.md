# OOP3
Voorbeeldcode en uitwerkingen voor OOP3 (thema 2.3)

Deze repository bevat de meest interessante voorbeeldcode en uitwerkingen die gedemonstreerd zijn tijdens de lessen OOP3. De klassen zijn voorzien van uitgebreid commentaar om te verduidelijken wat er gebeurt en waarom. Per week volgt hieronder een korte omschrijving van de packages en de meest voor de hand liggende volgorde om de code te bestuderen.

## week 4
**1. chart**<br/>
Voorbeeld van de manier waar je data uit de main-thread naar een data-klasse kunt pushen.

**2. chartexercise**<br/>
Deze opgave toont de manier waarop data in een FX-chart geplot kan worden. Er wordt gebruik
gemaakt van spurieuze data van de site <a href="http://www.tylervigen.com/spurious-correlations">http://www.tylervigen.com/spurious-correlations</a>. We correleren het aantal verdrinkingsdoden per jaar aan het
aantal films waarin Nicholas Cage in dat jaar heeft gespeeld.

**3. exception**<br/>
Deze klasse demonstreert verschillende manieren van werken met Exceptions.

**4. fileio**<br/>
De klassen in deze package demonstreren de manier waarop je in Java met bestanden en directories
kun werken. Er worden twee verschillende vormen besproken: één klassieke en één met try-with-resources.

**5. json**<br/>
Deze klasse demonstreert het werken met JSON in java. Hierbij wordt gebruik gemaakt van <a href="https://github.com/stleary/JSON-java">org.json</a> (<a href="http://central.maven.org/maven2/org/json/json/20180813/json-20180813.jar">Klik hier om de jar te downloaden</a>).

**6. jsonbook**<br/>
Deze klasse demonstreert het werken met json-bestanden, zowel het lezen als het schrijven. Er worden
hierin twee libraries bij geïntroduceerd: <a href="http://www.java2s.com/Code/Jar/j/Downloadjsonsimple11jar.htm">org.json.simple</a> en <a href="https://mvnrepository.com/artifact/com.google.code.gson/gson">google.gson</a>.

**7. profiling**<br/>
De klassen in deze package kun je gebruiken om <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/tooldescr008.html">hprof</a> uit te proberen.


## week 3
**1. package builder**<br/>
Een overgebleven pattern dat in HFDP slechts terzijde wordt genoemd (pp. 614-15), maar in het echt nog best vaak voorkomt.

**2. package command**<br/>
Een uitwerking van het command pattern aan de hand van Packman en Blinky.

**3. package generics**<br/>
Maak je eigen generic.

**4. package iterator**<br/>
Een uitgebreidere uitwerking van de iterator-opdracht van Blackboard, waarbij gebruik gemaakt wordt van generics (zoals besproken in de vorige package).

**5. package singleton**<br/>
Het singleton pattern uitgewerkt, en nog voorzien van wat andere voorbeelden waarbij het handig kan zijn om de constructie van je instanties *private* te maken.

**6. package state**<br/>
Het state pattern uitgewerkt aan de hand van een cola-verkoopmachine.

**7. package template**<br/>
Het loskoppelen van de implementatie van een functionaliteit en de benoeming ervan – aan de hand van serialisatie.

## week 2
**1. package decorator**<br/>
Een eenvoudige uitwerking van decorator met betrekking tot EAS en DES encryptie van een plain text string. Overigens zit de echte encryptie hier niet in; het gaat om de infrastructuur van hoe deze verschillende klassen met elkaar samenwerken.

**2. package factory**<br/>
Verschillende typen documenten worden hier door een factory aan een client overgedragen. Die client is niet geïnteresseerd in de manier waarop deze documenten worden aangemaakt of zelfs maar wat voor soort document het is. Het gaat er hier om dat het een document is, het type is verder niet relevant.

**3. package observer**<br/>
Een korte implementatie van verschillende klassen die de wijzigingen van bepaalde beursgenoteerde bedrijven bijhouden. Overigens zonder GUI: het gaat hier om de manier waarop de data tussen deze klassen wordt overgestuurd.

**4. package strategy**<br/>
Verschillende manieren om te bepalen of een getal een priemgetal is passeren hier de revue.


## week 1

**1. package follower**<br/>
Een (relatief onbeschreven) javafx-voorbeeld waarbij een eenvoudige iteratie omgezet wordt in een lambda-expressie. Hierbij wordt gebruik gemaakt van methoden en technieken die in de package *multithreading* beschreven zijn.

**2. package multithreading**<br/>
Hierin staan twee uitgebreide voorbeelden van multithreading: een eenvoudig tekstueel voorbeeld en een voorbeeld met een GUI (JavaFX). Hierin wordt ook de communicatie tussen verschillende threads verduidelijkt, alsmede het gebruik van een gedeelde resource (met synchronized).

**3. package sorting**<br/>
Verschillende manieren om klassen te sorteren, waarbij gebruik gemaakt wordt van de interfaces *Comparable* en *Comparator*.
