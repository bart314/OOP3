package builder;

@SuppressWarnings("unused")
public class Computer {
	private String merknaam;
	private String typenummer;
	private double snelheid;
	private int schermgrootte;
	
	private Computer(ComputerBuilder builder) {
		this.merknaam = builder.merknaam;
		this.typenummer = builder.typenummer;
		this.snelheid = builder.snelheid;
		this.schermgrootte = builder.schermgrootte;
	}
	
	//Doe je ding met je computer.
	
	public static class ComputerBuilder {
		private String merknaam;
		private String typenummer;
		private double snelheid;
		private int schermgrootte;
		
		ComputerBuilder setMerknaam(String val) {
			merknaam = val;	
			return this;
		}
		
		ComputerBuilder setTypenummer(String val) {
			typenummer = val;
			return this;
		}
		
		ComputerBuilder setSnelheid(int val) {
			snelheid = val;
			return this;
		}
		
		ComputerBuilder setSchermgrootte(int val) {
			schermgrootte = val;
			return this;
		}

		Computer build() {
			return new Computer(this);
		}
	}
}
