// https://projecteuler.net/problem=301
public class PE301 {
	public static void main(String[] args) {
		// For more explanation, see
		// https://en.wikipedia.org/wiki/Nim#Mathematical_theory
		// https://en.wikipedia.org/wiki/Nim#Index-k_Nim
		int count = 0;
	    for(int i = 1; i <= Math.pow(2, 30); i++) {
	    	if((i ^ (i * 2) ^ (i * 3)) == 0) {
	    		count++;
	    	}
	    }
	    System.out.println(count);
	}
}