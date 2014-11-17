// https://projecteuler.net/problem=53
import java.math.BigInteger;

public class PE053 {
	public static void main(String[] args) {
		int count = 0;
		for(int n = 1; n <= 100; n++) {
			for(int r = 0; r <= n; r++) {
				BigInteger f = factorial(n, r + 1).divide(factorial(n - r, 2));
				if(f.compareTo(new BigInteger("1000000")) > 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	public static BigInteger factorial(int n, int r) {
		BigInteger sum = BigInteger.ONE;
		for(int i = r; i <= n; i++) {
			sum = sum.multiply(BigInteger.valueOf(i));
		}
		return sum;
	}
}