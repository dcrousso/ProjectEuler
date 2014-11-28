// https://projecteuler.net/problem=71
public class PE071 {
	public static void main(String[] args) {
		int numerator = 0;
		double fraction = 0;
		for(int d = 2; d <= 1000000; d++) {
			int n = Math.round(d * 3 / 7);
			if(d % 7 == 0) {
				n--;
			}
			double f = (double) n / d;
			if(f > fraction) {
				numerator = n;
				fraction = f;
			}
		}
		System.out.println(numerator);
	}
}