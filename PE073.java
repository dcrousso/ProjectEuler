// https://projecteuler.net/problem=73
public class PE073 {
	public static void main(String[] args) {
		int count = 0;
		for(int d = 5; d <= 12000; d++) {
		    for(int n = d / 3; n < d / 2; n++) {
		        if(gcd(n, d) == 1) {
		        	count++;
		        }
		    }
		}
		System.out.println(count);
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}