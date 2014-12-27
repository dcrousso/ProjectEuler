// https://projecteuler.net/problem=104
import java.math.BigInteger;
import java.util.Arrays;

public class PE104 {
	public static void main(String[] args) {
		BigInteger prev = BigInteger.ONE;
		BigInteger fibonacci = BigInteger.ONE;
		int n = 2;
		while(true) {
			fibonacci = fibonacci.add(prev);
			prev = fibonacci.subtract(prev);
			n++;
						
			String f = fibonacci.toString();
			if(f.length() >= 9 && isPandigital(f.substring(0, 9)) && isPandigital(f.substring(f.length() - 9))) {
				break;
			}
		}
		System.out.println(n);
	}
	public static boolean isPandigital(String n) {
		char[] c = n.toCharArray();
		Arrays.sort(c);
		return new String(c).equals("123456789");
	}
}