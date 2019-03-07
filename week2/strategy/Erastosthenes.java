package strategy;

public class Erastosthenes implements PrimeGiver {
	@Override
	public boolean isPrime(int test) {
		if (test==1) return false;
		if (test==2) return true;

		int upperBoundSquareRoot = (int) Math.sqrt(test);

		for (int i=2; i<=upperBoundSquareRoot; i++) {
			if (test%i==0) return false;
		}
		
		return true;
	}

}
