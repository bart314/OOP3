package strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PrimesTest {
	strategy.MathClass tester;

	@Before
	public void setUp() {
		tester = new MathClass();
	}

	@Test
	public void test() {
//		tester.setPrimeGiver(new Erastosthenes());
//		checkNormalPrimes();
		
//		tester.setPrimeGiver(new Mersenne());
//		checkMersennePrimes();
		
//		DEMO add a new PrimerGiver.
		tester.setPrimeGiver(new HardCoded());
		checkNormalPrimes();
	}
	
	
	private void checkNormalPrimes() {
		assertTrue(tester.isPrime(2));
		assertTrue(tester.isPrime(31));
		assertTrue(tester.isPrime(73));
		assertTrue(tester.isPrime(65537));

		assertFalse(tester.isPrime(4));
		assertFalse(tester.isPrime(86));
		assertFalse(tester.isPrime(512));
		assertFalse(tester.isPrime(65536));
	}

	
	private void checkMersennePrimes() {
		assertTrue(tester.isPrime(3));
		assertTrue(tester.isPrime(7));
		assertTrue(tester.isPrime(31));
		assertTrue(tester.isPrime(127));

		assertFalse(tester.isPrime(5));
		assertFalse(tester.isPrime(28));
		assertFalse(tester.isPrime(1234));
		assertFalse(tester.isPrime(65536));
	}
}
