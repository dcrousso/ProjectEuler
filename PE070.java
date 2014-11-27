// https://projecteuler.net/problem=70
import java.util.Arrays;

public class PE070 {
	public static void main(String[] args) {
		double min = 10;
		int minN = 0;
		int[] totients = totients(9999999);
		for(int n = 2; n < totients.length; n++) {
			double fraction = (double) n / totients[n];
			if(fraction < min && sameDigits(n, totients[n])) {
				min = fraction;
				minN = n;
			}
		}
		System.out.println(minN + " : " + min);
	}
	
	public static int[] totients(int n) {
		int[] totients = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			totients[i] = i;
		}
		for(int i = 2; i <= n; i++) {
			if(totients[i] == i) {
				for(int j = i; j <= n; j += i) {
					totients[j] = totients[j] / i * (i - 1);
				}
			}
		}
		return totients;
	}
	
	private static boolean sameDigits(int n, int tN) {
		char[] ndigits = Integer.toString(n).toCharArray();
		char[] tNdigits = Integer.toString(tN).toCharArray();
		Arrays.sort(ndigits);
		Arrays.sort(tNdigits);
		return Arrays.equals(ndigits, tNdigits);
	}
}