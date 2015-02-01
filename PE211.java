// https://projecteuler.net/problem=211
public class PE211 {
	public static void main(String[] args) {
		// For more explanation, see
		// https://en.wikipedia.org/wiki/Divisor_function#Properties
		int[] largestPrimeFactor = new int[64000000];
		// Sieve of Eratosthenes (modified to calculate largest prime factor of i)
		for(int i = 2; i * i <= largestPrimeFactor.length; i++) {
			if(largestPrimeFactor[i] == 0) {
				for(int j = i; j < largestPrimeFactor.length; j += i) {
					if(largestPrimeFactor[j] == 0) {
						largestPrimeFactor[j] = i;
					}
				}	
			}
		}
		long[] sigma2 = new long[largestPrimeFactor.length];
		sigma2[1] = 1;
		for(int i = 2; i < sigma2.length; i++) {
			long p = largestPrimeFactor[i];
			if(p == 0) {
				p = i; // Largest prime factor i of j
			}
			long partialSum = 1;
			int j = i;
			long k = p * p;
			while(j % p == 0) { // Calculates the power of p in sigma2[i]
				partialSum += k;
				j /= p;
				k *= p * p;
			}
			sigma2[i] = partialSum * sigma2[j];
		}
		long sum = 0;
		for(int i = 1; i < largestPrimeFactor.length; i++) {
			long sqrt = (long) Math.sqrt(sigma2[i]);
			if(sqrt * sqrt == sigma2[i]) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}