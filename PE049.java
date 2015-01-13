// https://projecteuler.net/problem=049
import java.util.Arrays;

public class PE049 {
	public static void main(String[] args) {
		String concatenation = "";
		int[] primes = listPrimes(10000, 1488);
		for(int i = 0; i < primes.length; i++) { // First Prime (index)
	      	for(int j = i + 1; j < primes.length; j++) { // Second Prime (index)
	          	int k = primes[j] + (primes[j] - primes[i]); // Third prime
	          	if(k < 10000 &&  Arrays.binarySearch(primes, k) > -1) {
	              	if (isPermutation(primes[i], primes[j]) && isPermutation(primes[i], k)) {
	                  	concatenation = String.valueOf(primes[i]) + String.valueOf(primes[j]) + String.valueOf(k);
	                  	break;
	              	}
	            }
			}
			if(concatenation.length() > 0){
				break;
			}
		}
		System.out.println(concatenation);
	}
	public static int[] listPrimes(int n, int lowerBound) { 
		// https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
		boolean[] isPrime = new boolean[n];
		if(n >= 2)
			isPrime[2] = true;
		for(int i = 3; i < n; i += 2)
			isPrime[i] = true;
		for(int i = 3; i < Math.sqrt(n); i += 2) {
			if(isPrime[i]) {
				for(int j = i * 2; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		// Uses sieve to generate array of prime numbers from 2 to n
		int count = 0;
		for(int i = lowerBound; i < n; i++) {
			if(isPrime[i]) {
				count++;
			}
		}
		int[] primes = new int[count];
		for(int i = lowerBound, j = 0; i < n; i++) {
			if(isPrime[i]) {
				primes[j] = i;
				j++;
			}
		}
		return primes;
	}
	public static boolean isPermutation(int n, int m) {
		String sn = String.valueOf(n);
		String sm = String.valueOf(m);
		char[] cn = sn.toCharArray();
		char[] cm = sm.toCharArray();
		Arrays.sort(cn);
		Arrays.sort(cm);
		sn = new String(cn);
		sm = new String(cm);
		return sn.equals(sm);
	}
}