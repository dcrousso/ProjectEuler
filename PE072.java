// https://projecteuler.net/problem=72
public class PE072 {
	public static void main(String[] args) {
		long sum = 0;
		int[] totients = totients(1000000);
		for(int i = 2; i < totients.length; i++) {
			sum += totients[i];
		}
		System.out.println(sum);
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