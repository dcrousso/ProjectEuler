// https://projecteuler.net/problem=75
public class PE075 {
	public static void main(String[] args) {
		int[] triangles = new int[1500001];
		int result = 0;
		// For greater explanation, see:
		// https://en.wikipedia.org/wiki/Pythagorean_triple#Generating_a_triple
		for(int m = 2; m * m < 1500000; m++) { 
		    for(int n = 1; n < m; n++) {
		        if((n + m) % 2 == 1 && gcd(n, m) == 1) {
		            int p = 2 * m * (m + n);
		            while(p <= 1500000){
		                triangles[p]++;
		                if(triangles[p] == 1) {
		                	result++;
		                } else if(triangles[p] == 2) { // For L values with more than 1 solution
		                	result--;
		                }
		                p += 2 * m * (m + n); // All multiples of base value
		            }
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