// https://projecteuler.net/problem=120
public class PE120 {
	public static void main(String[] args) {
		// When expanding and simplifying the equation
		// for various values of n, a pattern emerges:
		// n=1 -> 2a							| 2a
		// n=2 -> 2a^2 + 2						| 2
		// n=3 -> 2a^3 + 6a						| 6a
		// n=4 -> 2a^4 + 12a^2 + 2				| 2
		// n=5 -> 2a^5 + 20a^3 + 10a			| 10a
		// n=6 -> 2a^6 + 30a^4 + 30a^2 + 2		| 2
		// n=7 -> 2a^7 + 42a^5 + 70a^3 + 14a	| 14a
		// When looking for the remainder, only values less than a^2 matter.
		// This leaves only the right column of values.
		// For even values of n, there will be a remainder of 2 as every power of a is
		// evenly divisible by 2 (we can ignore this since we are looking for the maximum
		// remainder for each value of a).
		// For odd values of n, the remainder is equal to 2na.
		// Setting this equal to the remainder gives: 2na = r mod a^2.
		// If 2na = a^2 (this will be the minimum value of r, that being 0), n = a/2.
		// The maximum value of r, however, will result when n is largest, meaning the
		// closest integer value less than a, which results in n = (a-1)/2.
		// Substituting this n into the mod equation above gives r = 2a(a-1)/2.
		int r = 0;
        for (int a = 3; a <= 1000; a++) {
        	r += (a * 2) * ((a - 1) / 2);
        }
        System.out.println(r);
	}
}