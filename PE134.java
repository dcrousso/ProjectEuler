// https://projecteuler.net/problem=134
public class PE134 {
	public static void main(String[] args) {
		// Let p1 and p2 be two primes.
		// The number ending with p1 that is also divisible by p2 can be
		// expressed as n = (coefficient)(multiple) + p1, where n % p2 = 0 and
		// (coefficient) is at a minimum (e.g. p1 = 19, p2 = 23, (coefficient) = 12,
		// (multiple) = 100, and n = 1219).
		// This equation can be rearranged to form (coefficient) = (-p1 * (multiple)^-1) % p2
		// which gives the correct solution for the smallest value of (coefficient).
		long sum = 0;
		int[] primes = listPrimes(2000000); // Lists all primes under 2000000 (should find 1000000 primes)
		for(int i = 2; primes[i] <= 1000000; i++) {
			int p1 = primes[i];
			int p2 = primes[i + 1];
			int multiple = 1;
			while(multiple < p1) {
				multiple *= 10;
			}
			long coefficient = ((p2 - p1) * extendedGCD(multiple % p2, p2)[0]) % p2;
			if(coefficient < 0) { // Modulo does not always return positive
				coefficient += p2; // Pushes result of mod to positive value
			}
			sum += (coefficient * multiple) + p1;
		}
		System.out.println(sum);
	}
	private static long[] extendedGCD(long a, long b) {
		// Extended Euclidean Algorithm:
		// If z is the GCD between a and b, there exists two
		// polynomials x and y such that ax + by = z.
        long x = 0;
        long y = 1;
        long z = b;
        long[] result = new long[] {1, 0, a};
        long temp;
        while(z > 0) {
            long quotient = result[2] / z;

            temp = x;
            x = result[0] - (quotient * x);
            result[0] = temp;

            temp = y;
            y = result[1] - (quotient * y);
            result[1] = temp;
            
            temp = z;
            z = result[2] % z;
            result[2] = temp;
        }
        return result;
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