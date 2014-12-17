// https://projecteuler.net/problem=65
import java.math.BigInteger;

public class PE065 {
	public static void main(String[] args) {
		BigInteger d = BigInteger.ONE;
		BigInteger n = BigInteger.valueOf(2);
        for (int i = 2; i <= 100; i++) {
        	int c = (i % 3 == 0) ? 2 * (i / 3) : 1;
        	BigInteger temp = d;
            d = n;                
            n = d.multiply(BigInteger.valueOf(c)).add(temp);                                
        }            
        System.out.println(digitSum(n));
	}
	public static int digitSum(BigInteger n) {
		int sum = 0;
		while(n != BigInteger.ZERO) {
			BigInteger[] m = n.divideAndRemainder(BigInteger.TEN);
			sum += m[1].intValue();
			n = m[0];
		}
		return sum;
	}
}