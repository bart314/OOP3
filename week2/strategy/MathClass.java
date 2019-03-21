package strategy;

public class MathClass {
	private PrimeGiver primeGiver;
	
	public void setPrimeGiver(PrimeGiver pg) {
		primeGiver = pg;
	}
	
	public boolean isPrime(int check) {
		return primeGiver.isPrime(check);
	}
}
