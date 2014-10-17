import java.math.BigInteger;

// https://projecteuler.net/problem=20
public class PE020 {
	public static void main(String[] args){
		BigInteger num = factorial(100);
		int sum = 0;
		while(num.compareTo(BigInteger.ZERO) != 0) {
			BigInteger[] digit = num.divideAndRemainder(BigInteger.TEN);
			sum += digit[1].intValue();
			num = digit[0];
		}
		System.out.println(sum);
	}
	
	public static BigInteger factorial(int n) {
		BigInteger bi = BigInteger.ONE;
		for(int i = 1; i <= n; i++) {
			bi = bi.multiply(BigInteger.valueOf(i));
		}
		return bi;
	}
}