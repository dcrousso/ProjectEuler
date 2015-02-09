// https://projecteuler.net/problem=249
public class PE249 {
	public static void main(String[] args) {
		long mod = 10000000000000000L; // 16 digits
		boolean[] isPrime = listPrimality(12500000);
		long[] numSubsetsWithPrimeSum = new long[isPrime.length];
		numSubsetsWithPrimeSum[0] = 1;
		int sumPrimes = 0;
		for(int i = 0; i < 5000; i++) {
			if(isPrime[i]) {
				// Since i starts at 0, j must start at a maximum value of the sum of all the 
				// primes seen so far (sumPrimes) and move down (decrease) to i.
				sumPrimes += i;
				for(int j = sumPrimes; j >= i; j--) {
					// The length of the current subset is equal to the sum of the previous subsets
					numSubsetsWithPrimeSum[j] += numSubsetsWithPrimeSum[j - i];
					numSubsetsWithPrimeSum[j] %= mod; // Limit to last 16 digits
				}
			}
		}
		
		long sum = 0;
		for(int i = 0; i < numSubsetsWithPrimeSum.length; i++) {
			if(isPrime[i]) {
				sum = (sum + numSubsetsWithPrimeSum[i]) % mod; // Limit to last 16 digits
			}
		}
		System.out.println(sum);
	}
	public static boolean[] listPrimality(int n) { 
		// https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
		boolean[] isPrime = new boolean[n];
		if(n >= 2) {
			isPrime[2] = true;
		}
		for(int i = 3; i < n; i += 2) {
			isPrime[i] = true;
		}
		for(int i = 3; i * i < n; i += 2) {
			if(isPrime[i]) {
				for(int j = i * 2; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		return isPrime;
	}
}