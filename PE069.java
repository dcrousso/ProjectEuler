// https://projecteuler.net/problem=69
public class PE069 {
	public static void main(String[] args) {
		double max = 0;
		int maxN = 0;
		int[] totients = totients(1000000);
		for(int n = 1; n < totients.length; n++) {
			double fraction = (double) n / totients[n];
			if(fraction > max) {
				max = fraction;
				maxN = n;
			}
		}
		System.out.println(maxN + " : " + max);
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
}