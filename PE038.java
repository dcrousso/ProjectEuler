// https://projecteuler.net/problem=38
import java.util.Arrays;

public class PE038 {
	public static void main(String[] args) {
		int largest = 0;
		for(int i = 1; i < 10000; i++) {
			String concatenation = "";
			for(int j = 1; concatenation.length() < 9; j++) {
				concatenation += i * j;
			}
			if(isPandigital(concatenation) && Integer.parseInt(concatenation) > largest) {
				largest = Integer.parseInt(concatenation);
			}
		}
		System.out.println(largest);
	}
	public static boolean isPandigital(String n) {
		if(n.length() < 9) {
			return false;
		}
		char[] c = n.toCharArray();
		Arrays.sort(c);
		return new String(c).equals("123456789");
	}
}