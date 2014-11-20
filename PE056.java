// https://projecteuler.net/problem=56
import java.math.BigInteger;

public class PE056 {
	public static void main(String[] args){
		int largest = 0;
		for(int a = 1; a < 100; a++) {
			for(int b = 1; b < 100; b++) {
				BigInteger n = new BigInteger(String.valueOf(a)).pow(b);
				String s = n.toString();
				int sum = 0;
				for(int i = 0; i < s.length(); i++) {
					sum += Character.getNumericValue(s.charAt(i));
				}
				if(sum > largest) {
					largest = sum;
				}
			}
		}
		System.out.println(largest);
	}
}