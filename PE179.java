// https://projecteuler.net/problem=179
public class PE179 {
	public static void main(String[] args) {
		int[] spf = listSmallestPrimeFactors((int) Math.pow(10, 7));
		int[] numDivisors = new int[spf.length];
		numDivisors[1] = 1;
		for(int i = 2; i < numDivisors.length; i++) {
			// Modified form of Euclid's GCD Algorithm
			// https://en.wikipedia.org/wiki/Euclidean_algorithm
			// Finds number of factors of i by continually dividing by
			// the smallest prime factor of i (spf[i])
			int p = spf[i];
			int exp = 1;
			int j = i;
			while(j % p == 0) {
				j /= p;
				exp++;
			}
			numDivisors[i] = exp * numDivisors[j];
		}
		int count = 0;
		for(int i = 1; i < Math.pow(10, 7); i++) {
			if(numDivisors[i - 1] == numDivisors[i]) {
				count++;
			}
		}
		System.out.println(count);
	}
	public static int[] listSmallestPrimeFactors(int n) {
		// Modified Sieve of Eratosthenes
		int[] spf = new int[n];
		for(int i = 2; i < spf.length; i++) {
			if(spf[i] == 0) {
				for(int j = i; j < n; j += i) {
					if(spf[j] == 0) {
						spf[j] = i;
					}
				}
			}
		}
		return spf;
	}
}