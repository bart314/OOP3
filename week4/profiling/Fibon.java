public class Fibon {
	public static void main(String[] args) {
		long result = fibonacci(30);
		System.out.println(result);
	}
		
	private static long fibonacci(int n) {
		if(n <= 1)
			return n;		
		else {
			long m = fibonacci(n - 1) + fibonacci(n - 2);
			return m;
		} 
	}
}
