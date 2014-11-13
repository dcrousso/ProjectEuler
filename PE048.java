// https://projecteuler.net/problem=48
import java.math.BigInteger;

public class PE048 {
	public static void main(String[] args) {
		BigInteger digits = BigInteger.ZERO;
		for(int i = 1; i < 1000; i++) {
			digits = digits.add(BigInteger.valueOf(i).modPow(BigInteger.valueOf(i), BigInteger.TEN.pow(10)));
		}
		System.out.println(digits.mod(BigInteger.TEN.pow(10)));
	}
}