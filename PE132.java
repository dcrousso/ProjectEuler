// https://projecteuler.net/problem=132
import java.math.BigInteger;

public class PE132 {
	public static void main(String[] args) {
		// For more explanation, see
		// http://en.wikipedia.org/wiki/Repunit#Definition
		int sum = 0;
		int count = 0;
		int i = 2;
		while(count < 40) {
			if(repunitMod(1000000000, i) == 0) {
				sum += i;
				count++;
			}
			i = nextPrime(i);
		}
		System.out.println(sum);
	}
	public static long repunitMod(int k, int m) {
		BigInteger modPow = BigInteger.TEN.modPow(BigInteger.valueOf(k), BigInteger.valueOf(m * 9));
		return modPow.subtract(BigInteger.ONE).divide(BigInteger.valueOf(9)).longValue();
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