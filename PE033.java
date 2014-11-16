// https://projecteuler.net/problem=33
public class PE033 {
	public static void main(String[] args) {
		int productN = 1, productD = 1;
		for(int d = 11; d < 100; d++) {
			for(int n = 10; n < d; n++) {
				float f = (float) n / d;
				if(f < 1) {
					int digit = sameDigit(n, d);
					if(digit > 0) {
						String removedN = String.valueOf(n).replaceFirst(String.valueOf(digit), "");
						String removedD = String.valueOf(d).replaceFirst(String.valueOf(digit), "");
						float removedF = (float) Integer.valueOf(removedN) / Integer.valueOf(removedD);
						if(removedF == f) {
							productN *= n;
							productD *= d;
						}
					}
				}
			}
		}
		System.out.println(productD / gcd(productN, productD));
	}
	
	public static int sameDigit(int numerator, int denominator) {
		String n = String.valueOf(numerator);
		String d = String.valueOf(denominator);
		for(int i = 0; i < n.length(); i++) {
			for(int j = 0; j < d.length(); j++) {
				if(n.charAt(i) == d.charAt(j)) {
					return n.charAt(i) - '0';
				}
			}
		}
		return -1;
	}
	
	public static int gcd(int x, int y) {
		while(y != 0) {
			int z = x % y;
			x = y;
			y = z;
		}
		return x;
	}
}