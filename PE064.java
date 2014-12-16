// https://projecteuler.net/problem=64
public class PE064 {
	public static void main(String[] args) {
		int result = 0;
		// For greater explanation, see:
		// https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Continued_fraction_expansion
        for(int n = 2; n <= 10000; n++) {
            int sqrt = (int) Math.sqrt(n);                                
            if(sqrt * sqrt != n) {
            	int m = 0;
            	int d = 1;
	            int a = sqrt;
	            int period = 0;
	            while(a != 2 * sqrt) {                
	                m = d * a - m;                    
	                d = (n - m * m) / d;
	                a = (sqrt + m) / d;
	                period++;
	            };
	            if (period % 2 == 1) {
	            	result++;
	            }
            }
        }
		System.out.println(result);
	}
}