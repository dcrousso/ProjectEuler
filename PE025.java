// https://projecteuler.net/problem=25
import java.math.BigInteger;

public class PE025 {
	public static void main(String[] args){
		BigInteger num = BigInteger.ONE, prev = BigInteger.ZERO, temp = BigInteger.ZERO;
		int count = 1;
		while(num.toString().length() < 1000) {
			temp = num;
			num = num.add(prev);
			prev = temp;
			count++;
		}
		System.out.println(count);
	}
}