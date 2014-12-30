// https://projecteuler.net/problem=119
import java.util.Arrays;
import java.math.BigInteger;

public class PE119 {
	public static void main(String[] args) {
		BigInteger[] a = new BigInteger[100]; // In case terms are found out of order
        int i = 0;
        for(int sum = 2; sum < 400 && i < 100; sum++) {
            BigInteger number = BigInteger.valueOf(sum);
            for(int power = 2; power < 100 && i < 100; power++) { // Power is most likely less than a Googol
            	number = number.multiply(BigInteger.valueOf(sum));
                if(digitSum(number) == sum) {
                    a[i] = number;
                    i++;
                }
            }
        }
        Arrays.sort(a);
        System.out.println(a[29]);
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