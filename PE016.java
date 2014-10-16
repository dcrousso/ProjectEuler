// https://projecteuler.net/problem=16
import java.math.BigInteger;

public class PE016 {
	public static void main(String[] args){
		BigInteger power = new BigInteger("2");
		power = power.pow(1000);
		int sum = 0;
		while(power.compareTo(BigInteger.ZERO) != 0) {
			BigInteger[] digit = power.divideAndRemainder(BigInteger.TEN);
			sum += digit[1].intValue();
			power = digit[0];
		}
		System.out.println(sum);
	}
}