// https://projecteuler.net/problem=323
public class PE323 {
	public static void main(String[] args) {
		// For more explanation, see
		// https://en.wikipedia.org/wiki/Expected_value#Univariate_discrete_random_variable.2C_countable_case
		// https://en.wikipedia.org/wiki/Cumulative_distribution_function#Definition
		double sum = 0, p = 1;
		for (int n = 1; n * p > Math.pow(10, -11); n++) {
			// Each increment of n corresponds to a change in one bit, which is
			// represented by shifting from 0 to 1 or vice versa.
			// As such, the probability of that individual shift is equal to the
			// probability of the newly incremented n minus the probability of
			// the preceding (decremented) value of n (n - 1).
			p = probability(n) - probability(n - 1);
			// The expected value of N for which n becomes all 1's can then be
			// calculated by taking the sum of all (n * p) from [1, ∞] (or until
			// the value of p becomes insignificantly small).
			sum += n * p;
		}
		System.out.println(String.format("%.10f", sum));
	}
	// Given that n is a 32-bit integer, the probabilities are as follows:
	// For any digit, the chance of 0 is ((1/2) ^ n) and 1 is (1 - ((1/2) ^ n)).
	// For the number n the chance that all digits
	// are 1 is (1 - ((1/2) ^ n)) ^ 32 (32 bits in the number).
	// At the same time, there is an equal probability
	// that all the digits will be 0.
	// Therefore, the probability that any number n will have all digits be 0's
	// or 1's can be represented by ((1 - ((1/2) ^ n)) ^ 32).
	// (Uses (2 ^ -n) instead of ((1/2) ^ n) to prevent decimal overflow)
	public static double probability(int n) {
		return Math.pow(1 - Math.pow(2, -n), 32);
	}
}