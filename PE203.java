// https://projecteuler.net/problem=203
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class PE203 {
	public static void main(String[] args) {
		// For more explanation, see
		// https://en.wikipedia.org/wiki/Pascal%27s_triangle
		Set<Long> numbers = new HashSet<Long>();
		int max = 0;
		for (int n = 0; n <= 50; n++) {
			for(int k = 0; k <= n; k++) {
				long x = binomial(n, k);
				numbers.add(x);
				max = (int) Math.max(x, max);
			}
		}
		// Only need up to the squareroot of the largest number in pascal's triangle
		// as the largest possible value of a prime squared in [0, max] would be max.
		// Any value greater than that would not divide into n.
		long[] primesSquared = listPrimesSquared((int) Math.sqrt(max));
		long sum = 0;
		for(long n : numbers) {
			if(hasNoSquareDivisors(n, primesSquared)) {
				sum += n;
			}
		}
		System.out.println(sum);
	}
	// n choose k (https://en.wikipedia.org/wiki/Binomial_coefficient)
	public static long binomial(int n, int k) {
		return factorial(n).divide(factorial(n - k).multiply(factorial(k))).longValue();
	}
	public static boolean hasNoSquareDivisors(long n, long[] primesSquared) {
		for(int i = 0; i < primesSquared.length; i++) {
			if(n % primesSquared[i] == 0) {
				return false;
			}
		}
		return true;
	}
	public static long[] listPrimesSquared(int n) { 
		// https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
		boolean[] isPrime = new boolean[n];
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
		// Modified to store square of prime instead of just the prime
		long[] primesSquared = new long[count];
		for(int i = 0, j = 0; i < n; i++) {
			if(isPrime[i]) {
				primesSquared[j] = (long)i * i;
				j++;
			}
		}
		return primesSquared;
	}
	public static BigInteger factorial(int n) {
		BigInteger product = BigInteger.ONE;
		for(int i = 2; i <= n; i++) {
			product = product.multiply(BigInteger.valueOf(i));
		}
		return product;
	}
}