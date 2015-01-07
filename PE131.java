// https://projecteuler.net/problem=131
public class PE131 {
	public static void main(String[] args) {
		// Starting equation: n^3 + n^2 * p = k^3
		// n^3 * (1 + p / n) = k^3
		// n^3 * (p + n) / n = k^3
		// n * cuberoot(p + n) / cuberoot(n) = k 
		// If n = u^3 and p + n = v^3, then p = v^3 - u^3 (substitution)
		// Rewriting the difference of cubes, p = (v - u)(v^2 + uv + u^2)
		// Since (v - u) is a factor and p is an integer prime number,
		// (v - u) must be equal to 1, meaning that v and u are consecutive
		// Re-substituting this gives the equation p = (u + 1)^3 - u^3
		int count = 0;
		int prime = 0;
		int u = 1;
		while(prime < 1000000) {
			prime = (int) (Math.pow(u + 1, 3) - Math.pow(u, 3));
		    if(isPrime(prime)) {
		    	count++;
		    }
		    u++;
		}
		System.out.println(count);
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
}