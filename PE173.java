// https://projecteuler.net/problem=173
public class PE173 {
	public static void main(String[] args) {
		int count = 0;
		// One million tiles means that each side can be a maximum of 250000 tiles long (four sides)
		// A side of 250001, however, uses exactly one million tiles if the ring is one tile in width
		for(int outer = 3; outer <= 250001; outer++) {
			// Starts at n - 2 because the inner square must be one smaller from all sides
			// e.g: one square from the left and one square from the right = total length minus 2
			for(int inner = outer - 2; inner >= 1; inner -= 2) {
				// Make sure that less than 1000000 tiles are used
				if(((long) outer * outer) - ((long) inner * inner) > 1000000) {
					break;
				}
				count++;
			}
		}
		System.out.println(count);
	}
}