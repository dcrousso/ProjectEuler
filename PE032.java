// https://projecteuler.net/problem=32
import java.util.Arrays;

public class PE032 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i < 10000; i++) {
			for(int j = 1; j <= i; j++) {
				String n = "" + i + j + (i / j);
				if(i % j == 0 && isPandigital(n)) {
					sum += i;
					break;
				}
			}
		}
		System.out.println(sum);
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