package builder;

import builder.Computer.ComputerBuilder;

public class Demo {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Computer foo = new ComputerBuilder()
				.setMerknaam("Huawei")
				.setTypenummer("AS400")
				.setSnelheid(400)
				.setSchermgrootte(30)
				.build();
	}
}
