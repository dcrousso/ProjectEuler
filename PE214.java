// https://projecteuler.net/problem=214
public class PE214 {
	public static void main(String[] args) {
		int[] totients = listTotients(40000000);
		int[] chains = new int[totients.length];
		chains[0] = 1;
		long sum = 0;
		// Each totient generates a decreasing chain compared to the previous totient
		for(int i = 1; i < totients.length; i++) {
			// Gets the chain length of the totient of i (a.k.a the next value in the chain)
			chains[i] = chains[totients[i]] + 1;
			// totients[i] is prime if it equals i - 1
			if(chains[i] == 25 && totients[i] == i - 1) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
	public static int[] listTotients(int n) {
		// Euler's Totient Function
		// (http://mathworld.wolfram.com/TotientFunction.html)
		int[] totients = new int[n];
		for(int i = 0; i < n; i++) {
			totients[i] = i;
		}
		for(int i = 2; i < n; i++) {
			if(totients[i] == i) { // totients[i] is prime
				for(int j = i; j < n; j += i) {
					totients[j] = (int)(totients[j] * (1 - (1 / (double)i)));
				}
			}
		}
		return totients;
	}
}