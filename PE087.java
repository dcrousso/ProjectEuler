// https://projecteuler.net/problem=83
import java.util.HashSet;
import java.util.Set;

public class PE087 {
	public static void main(String[] args) {
		Set<Integer> sums = new HashSet<Integer>();
		sums.add(0);
		for(int i = 2; i <= 4; i++) {
			Set<Integer> increasedSums = new HashSet<Integer>();
			int prime = 2, power = 0;
			while(power < 50000000) {
				power = (int) Math.pow(prime, i);
				for(int s : sums) {
					if (s + power <= 50000000) {
						increasedSums.add(s + power);
					}
				}
				if(prime < 3) {
					prime++;
				} else {
					prime = nextPrime(prime);
				}
			}
			sums = increasedSums;
		}
		System.out.println(sums.size());
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