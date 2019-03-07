package strategy;

public class MathClass {
	PrimeGiver primeGiver;
	
	public void setPrimeGiver(PrimeGiver pg) {
		primeGiver = pg;
	}
	
	public boolean isPrime(int check) {
		return primeGiver.isPrime(check);
	}
}
