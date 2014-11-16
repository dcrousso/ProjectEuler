// https://projecteuler.net/problem=52
import java.util.Arrays;

public class PE052 {
	public static void main(String[] args) {
		int i = 1;
		while(true) {
			if(sameDigits(i)) {
				System.out.println(i);
				break;
			}
			i++;
		}
	}
	public static boolean sameDigits(int n) {
		char[] c = Integer.toString(n).toCharArray();
		Arrays.sort(c);
		for(int i = 2; i <= 6; i++) {
			char[] mc = Integer.toString(n * i).toCharArray();
			Arrays.sort(mc);
			if(!new String(c).equals(new String(mc))) {
				return false;
			}
		}
		return true;
	}
}