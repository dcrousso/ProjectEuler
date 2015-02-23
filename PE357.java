// https://projecteuler.net/problem=357
public class PE357 {
	public static void main(String[] args) {
		long sum = 0;
		boolean[] isPrime = listPrimality(100000000);
		for(int n = 0; n < isPrime.length - 1; n++) {
			if(divisorsCreatingPrimes(n, isPrime)) {
				sum += n;
			}
		}
		System.out.println(sum);
	}
	public static boolean divisorsCreatingPrimes(int n, boolean[] isPrime) {
		for(int d = 1; d * d <= n; d++) {
			if(n % d == 0 && !isPrime[d + (n / d)]) {
				return false;
			}
		}
		return true;
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