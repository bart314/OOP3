package state;

import java.util.Scanner;

/*
De klassen in deze package demonstreren de werking van het State pattern:

    https://en.wikipedia.org/wiki/State_pattern

Het is een simulatie van een machine waar blikjes cola uit komen. Een blikje kost twee euro en de machine accepteert
munten van vijftig cent en van één euro. Elke keer dat iemand een muntje inwerpt, verandert de machine van status.
Hoe de machine reageert op een muntje, is afhankelijk van de status waarin deze zich op dat moment bevindt. Maar omdat
dat machine in elke status beide munten accepteert, moet voor elke status deze volledige interactie zijn gedefinieerd.

Dat wordt afgedwongen door de twee methoden in de State-interface. Elke State-klasse implementeert deze interface, dus
je kunt garanderen dat voor elke State deze interactie volledig is gedefinieerd. Zie het commentaar in de State-klasse.

Om het voorbeeld wat interactiever te maken, wordt gebruik gemaakt van een input-scanner.
 */


public class Demo {
	public static void main(String[] args) {
		ColaMachine machine = new ColaMachine();
		System.out.println("Welkom bij de awesome cola-machine.");
		System.out.println("Deze geweldige verfrissende drank nu voor slechts twee euro.");
		System.out.println("Dit ding accepteert munten van €0,50 (50) en €1,00 (100)");
		System.out.println("Gooi geld in:");

		while (true) {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			in = new Scanner(System.in);
			int foo = in.nextInt();

			machine.insertMoney(foo);
		}
	}

}
