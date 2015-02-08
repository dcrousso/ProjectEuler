// https://projecteuler.net/problem=243
import java.math.BigInteger;

public class PE243 {
	public static void main(String[] args) {
		// For more explanation, see
		// http://mathworld.wolfram.com/TotientFunction.html (12)
		BigInteger numerator = BigInteger.ONE;
		BigInteger denominator = BigInteger.ONE;
		BigInteger targetNumerator = BigInteger.valueOf(15499);
		BigInteger targetDenominator = BigInteger.valueOf(94744);
		int result = -1;
		int prime = 2;
		while(result < 0) {
			numerator = numerator.multiply(BigInteger.valueOf(prime - 1));
			denominator = denominator.multiply(BigInteger.valueOf(prime));
			// So long as (numerator / denominator) is less than (targetNumerator / targetDenominator), continue
			// (greater explanation in comments below)
			if(numerator.multiply(targetDenominator).compareTo(denominator.multiply(targetNumerator)) < 0) {
				for(int i = 1; i <= prime; i++) {
					// Rearranging (n / d) = (targetNumerator / targetDenominator) into
					// (n * targetDenominator) = (d * targetNumerator) and for (n / d) to be smaller,
					// n > targetNumerator and d < targetDenominator (one of the two could also be equal), leaving
					// the result when cross multiplying to be (n * targetDenominator) > (d * targetNumerator)
					BigInteger n = numerator.multiply(BigInteger.valueOf(i));
					BigInteger d = denominator.multiply(BigInteger.valueOf(i)).subtract(BigInteger.ONE);
					if(n.multiply(targetDenominator).compareTo(d.multiply(targetNumerator)) < 0) { 
						result = d.intValue();
						break;
					}
				}
			}
			prime = nextPrime(prime);
		}
		System.out.println(result + 1);
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
	public static int nextPrime(int n) {
		if(n == 2) {
			return 3;
		}
		int i = n + 2;
		while(!isPrime(i)) {
			i+=2;
		}
		return i;
	}
}