// https://projecteuler.net/problem=113
import java.math.BigInteger;

public class PE113 {
	public static void main(String[] args) {
		long count = 0;
		for(int i = 1; i <= 100; i++) {
			// For any given number n, there are a maximum of 8 additions between digits
			// in order to keep that number classified as Increasing (e.g. 123456789).
			// (The maximums number of operations is 8 since there are no leading zeros)
			count += binomial(8 + i, i);
			// For any given number n, there are a maximum of 9 subtractions between digits
			// in order to keep that number classified as Decreasing (e.g. 9876543210).
			// (The maximums number of operations is 9 since there can be trailing zeros)
			count += binomial(9 + i, i);
		}
		// Subtract 900 from the final count because of the "flat" numbers which contain
		// no operations between digits (e.g. 222222) of which there are 100 for each number.
		// Additionally, there are 100 numbers where two neighboring digits can cancel each
		// other out to produce a "flat-bouncy" number (e.g. 11181111).
		System.out.println(count - 900 - 100);
	}
	// n choose k (https://en.wikipedia.org/wiki/Binomial_coefficient)
	public static long binomial(int n, int k) {
		return factorial(n).divide(factorial(n - k).multiply(factorial(k))).longValue();
	}
	public static BigInteger factorial(int n) {
		BigInteger product = BigInteger.ONE;
		for(int i = 2; i <= n; i++) {
			product = product.multiply(BigInteger.valueOf(i));
		}
		return product;
	}
}