// https://projecteuler.net/problem=138
public class PE138 {
	public static void main(String[] args) {
		// Starting with (b/2)^2 + h^2 = L^2 and h = b +- 1
		// Using substitution, L^2 = 5x^2 +- 4x + 1
		// This is a quadratic diophantine equation (similar to Problem 94)
		// Using http://www.alpertron.com.ar/QUAD.HTM to solve the positive version
		// (https://en.wikipedia.org/wiki/Diophantine_equation#External_links)
		long sum = 0;
		long x = 0;
		long y = -1;
		
		for(int i = 0; i < 12; i++) {
			long nx = (-9 * x) + (-4 * y) + 4; // Create new variables to avoid overflow
			long ny = (-20 * x) + (-9 * y) + 8;
			
			x = nx;
			y = ny;
			
			sum += Math.abs(y);
		}
		System.out.println(sum);
	}
}