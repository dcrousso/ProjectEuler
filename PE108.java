// https://projecteuler.net/problem=108
public class PE108 {
	public static void main(String[] args) {
		// For more explanation, see
		// https://en.wikipedia.org/wiki/Divisor_function#Properties
		// From the examples, it can be seen that x and y must be greater than n.
		// Therefore, x = n + i and y = n + j.
		// Plugging this back in, (1 / n) = (1 / (n + i)) + (1 / (n + j)).
		// (1 / n) = (2n + i + j) / ((n + i)(n + j))
		// 2n^2 + ni + nj = n^2 + ni + nj + ij
		// n^2 = ij
		// Assuming i <= j (gathered from examples), i^2 <= n^2.
		// This means that the number of values of i represents the
		// number of divisors of n^2 from [1, n].
		int n = 1;
		while(countDivisors(n) <= 1000) {
			n++;
		}
		System.out.println(n);
	}
	// Each distinct pair of ij is a solution to n^2.
	// We must divide by 2, however, to remove double counting
	// (if n has x divisors, then n * n has 2x + 1 divisors as
	// the divisor n^2 will not be counted twice).
	public static int countDivisors(int n) {
		int count = 1;
		for(int i = 2; i * i <= n; i++) {
			int exponent = 1;
			while(n % i == 0) {
				exponent += 2;
				n /= i;
			}
			count *= exponent;
		}
		// Account for remaining prime factor from above while loop
		if(n != 1) {
			count *= 3; // Additional solution added (2(1) + 1 = 3)
		}
		return (count + 1) / 2;
	}
}