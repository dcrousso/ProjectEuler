// https://projecteuler.net/problem=127
import java.util.Arrays;

public class PE127 {
	public static void main(String[] args){
		long result = 0;
		long[] rads = new long[120001];
		Arrays.fill(rads, 1);
		for(int i = 2; i <= 120000; i++) {
			if(rads[i] == 1) {
				for(int j = i; j <= 120000; j += i) {
					rads[j] *= i;
				}
			}
		}
		for (int a = 1; a < 120000; a++) {
		    for (int b = a + 1; b < 120000 - a; b++) { // Compute every b greater than a and less than 12000, leaving room for c
		        if (rads[a] * rads[b] * rads[a + b] < a + b && gcd(a, b) == 1) {
		        	result += a + b;
		        }
		    }
		}
		System.out.println(result);
	}
	public static int gcd(int n, int m) {
		if(m == 0) {
			return n;
		}
		return gcd(m, n % m);
	}
}