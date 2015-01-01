// https://projecteuler.net/problem=123
import java.math.BigInteger;

public class PE123 {
	public static void main(String[] args) {
		int prime = 71059; // 7037th Prime Number
		int n = 7037;
		BigInteger r = BigInteger.ZERO;
		while(r.compareTo(new BigInteger("10000000000")) < 0) {
			// From Problem 120, r = 2na
			r = BigInteger.valueOf(prime).multiply(BigInteger.valueOf(n * 2));
			prime = nextPrime(prime);
			n++;
		}
        System.out.println(n);
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
		int i = n + 2;
		while(!isPrime(i)) {
			i+=2;
		}
		return i;
	}
}