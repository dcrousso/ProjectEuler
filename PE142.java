// https://projecteuler.net/problem=142
public class PE142 {
	public static void main(String[] args) {
		long a, // x + y
			 b, // x - y
			 c, // x + z
			 d, // x - z
			 e, // y + z
			 f; // y - z
		// x = (a + b)/2
		// y = (e + f)/2
		// z = (c - d)/2
		long xyz = 0;
		long i = 4;
		while(xyz == 0) {
			a = i * i;
			for(long j = 3; j < i && xyz == 0; j++) {
				c = j * j;
				f = a - c; // y - z = (x + y) - (x + z) = a - c
				if(f > 0 && isSquare(f)) {
					// In order for (e + f) to be evenly divisible by 2, (e + f) must be even.
					// Since e = a - d and f = a - c, d and c must both be even or odd.
					for(long k = (c % 2 == 1) ? 1 : 2; k < j && xyz == 0; k += 2) {
						d = k * k;
						e = a - d; // y + z = (x + y) - (x - z) = a - d
						b = c - e; // x - y = (x + z) - (y + z) = c - e
						if(b > 0 && e > 0 && isSquare(b) && isSquare(e)) {
							long x = (a + b) / 2;
							long y = (e + f) / 2;
							long z = (c - d) / 2;
							xyz = x + y + z;
						}
					}
				}
			}
			i++;
		}
		System.out.println(xyz);
	}
	// Simply for ease of use
	public static boolean isSquare(long n) { 
		long root = (long) Math.sqrt(n);
		return (root * root == n);
	}
}