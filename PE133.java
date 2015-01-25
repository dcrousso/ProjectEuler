// https://projecteuler.net/problem=133
import java.math.BigInteger;

public class PE133 {
	public static void main(String[] args) {
		// For more explanation, see
		// http://en.wikipedia.org/wiki/Repunit#Definition
		int sum = 0;
		int[] primes = listPrimes(100000);
		// It's excessive, but if the given prime isn't a factor of Googol,
		// it probably won't be a factor of anything (larger or smaller)
		BigInteger k = BigInteger.TEN.pow(100);
		for(int i = 0; i < primes.length; i++){
			if(repunitMod(k, primes[i]) != 1) {
				sum += primes[i];
			}
		}
		System.out.println(sum);
	}
	public static long repunitMod(BigInteger k, int m) {
		return BigInteger.TEN.modPow(k, BigInteger.valueOf(m * 9)).longValue();
	}
	public static int[] listPrimes(int n) { 
		// https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
		boolean[] isPrime = new boolean[n * n];
		if(n >= 2) {
			isPrime[2] = true;
		}
		for(int i = 3; i < n; i += 2) {
			isPrime[i] = true;
		}
		for(int i = 3; i < Math.sqrt(n); i += 2) {
			if(isPrime[i]) {
				for(int j = i * 2; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		// Uses sieve to generate array of prime numbers from 2 to n
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(isPrime[i]) {
				count++;
			}
		}
		int[] primes = new int[count];
		for(int i = 0, j = 0; i < n; i++) {
			if(isPrime[i]) {
				primes[j] = i;
				j++;
			}
		}
		return primes;
	}
}