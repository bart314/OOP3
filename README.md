# OOP3
Voorbeeldcode en uitwerkingen voor OOP3 (thema 2.3)

Deze repository bevat de meest interessante voorbeeldcode en uitwerkingen die gedemonstreerd zijn tijdens de lessen OOP3. De klassen zijn voorzien van uitgebreid commentaar om te verduidelijken wat er gebeurt en waarom. Per week volgt hieronder een korte omschrijving van de packages en de meest voor de hand liggende volgorde om de code te bestuderen.

## week 2
**1. package decorator*<br/>
Een eenvoudige uitwerking van decorator met betrekking tot EAS en DES encryptie van een plain text string. Overigens zit de echte encryptie hier niet in; het gaat om de infrastructuur van hoe deze verschillende klassen met elkaar samenwerken.

**2. package observer*<br/>
Een korte implementatie van verschillende klassen die de wijzigingen van bepaalde beursgenoteerde bedrijven bijhouden. Overigens zonder GUI: het gaat hier om de manier waarop de data tussen deze klassen wordt overgestuurd.

**3. package factory*<br/>
Verschillende typen documenten worden hier door een factory aan een client overgedragen. Die client is niet geïnteresseerd in de manier waarop deze documenten worden aangemaakt of zelfs maar wat voor soort document het is. Het gaat er hier om dat het een document is, het type is verder niet relevant.

**4. package state*<br/>
Een implementatie van een state-machine (een cola-verkoopmachine).

**5. package singleton*<br/>
Voorbeelden van hoe je de creatie van je objecten kunt controlleren vanuit de klasse zelf.  


## week 1
**1. package multithreading**<br/>
Hierin staan twee uitgebreide voorbeelden van multithreading: een eenvoudig tekstueel voorbeeld en een voorbeeld met een GUI (JavaFX). Hierin wordt ook de communicatie tussen verschillende threads verduidelijkt, alsmede het gebruik van een gedeelde resource (met synchronized).

**2. package sorting**<br/>
Verschillende manieren om klassen te sorteren, waarbij gebruik gemaakt wordt van de interfaces *Comparable* en *Comparator*. 

**3. package follower**<br/>
Een (relatief onbeschreven) javafx-voorbeeld waarbij een eenvoudige iteratie omgezet wordt in een lambda-expressie. Hierbij wordt gebruik gemaakt van methoden en technieken die in de package *multithreading* beschreven zijn.
