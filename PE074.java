// https://projecteuler.net/problem=74
import java.util.Set;
import java.util.HashSet;

public class PE074 {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 0; i < 1000000; i++) {
			if(getChainLength(i) == 60) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static int getChainLength(int n) {
		Set<Integer> chain = new HashSet<Integer>();
		while(!chain.contains(n)) {
			chain.add(n);
			n = digitFactorialSum(n);
		}
		return chain.size();
	}
	
	public static int digitFactorialSum(int n) {
		int[] digitFactorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
		int sum = 0;
		while(n != 0) {
			sum += digitFactorial[n % 10];
			n /= 10;
		}
		return sum;
	}
}