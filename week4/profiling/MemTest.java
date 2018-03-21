import java.util.*;
 
public class MemTest {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		//List<Integer> l = new LinkedList<>(); // check de heap site om de verschillen te zien.
		for(int i=0; i<100_000; i++) {
			l.add(new Integer(i));
		}
		
	}
}
