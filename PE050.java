// https://projecteuler.net/problem=50
import java.util.ArrayList;

public class PE050 {
	public static void main(String[] args){
		int longestChain = 0;
		int longestNum = 0;
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		int p = 3;
		while(p < 1000000) {
			primes.add(p);
			p = nextPrime(p);
		}
		
		for(int i = 0; i < primes.size(); i++) {
			int sum = 0;
			int j = i;
			while(sum < primes.get(primes.size() - 1)) {
				sum += primes.get(j);
				if(sum > longestNum && j - i> longestChain && isPrime(sum)) {
					longestNum = sum;
					longestChain = j - i;
				}
				j++;
			}
		}
		System.out.println(longestNum + " : " + longestChain);
	}
	
	public static boolean isPrime(int n) {
		if(n == 2) {
			return true;
		}
		if(n == 1 || n % 2 == 0) {
			return false;
		}
		for(int i = 3; i * i <= n; i += 2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int nextPrime(int n) {
		int i = n + 2;
		while(!isPrime(i)) {
			i+=2;
		}
		return i;
	}
}