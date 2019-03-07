package strategy;

public class Mersenne implements PrimeGiver {

	@Override
	public boolean isPrime(int foo) {
		int powTwo = 2;

		while( powTwo <= foo ) {
			powTwo *= 2;
			if( powTwo - foo == 1 )	return true;
		}
		
		return false;
	}
}