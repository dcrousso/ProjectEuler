// https://projecteuler.net/problem=139
public class PE139 {
	public static void main(String[] args) {
		// For more explanation, see
		// https://en.wikipedia.org/wiki/Formulas_for_generating_Pythagorean_triples#Generating_triples_when_one_side_is_known
		long count = 0;
		for(long m = 2; m * m < 100000000; m++) {
		    for(long n = 1; n < m; n++) {
		        if((n + m) % 2 == 1 && gcd(n, m) == 1) {
					long a = 2 * m * n;
					long b = (m * m) - (n * n);
					long c = (m * m) + (n * n);
					long perimeter = a + b + c;
					if(c % (b - a) == 0) { // b - a (side length of the hole) must evenly multiply into c (side length of the square)
						count += 100000000 / perimeter; // Same as multiplying p times k through 100000000
					}
		        }
		    }
		}
		System.out.println(count);
	}
	public static long gcd(long n, long m) {
		if(m == 0) {
			return n;
		}
		return gcd(m, n % m);
	}
}