// https://projecteuler.net/problem=100
public class PE100 {
	public static void main(String[] args) {
		// For more explanation, see
		// https://en.wikipedia.org/wiki/Diophantine_equation#External_links
		// http://www.alpertron.com.ar/QUAD.HTM
		// Solution is such that (blue / discs)((blue - 1) / (discs - 1)) = 1/2
		// Solving the above yields 2blue^2 - 2blue  - discs^2 + discs = 0
		long blue = 15;
        long discs = 21;
        while(discs < Math.pow(10, 12)){
            long btemp = 3 * blue + 2 * discs - 2;
            long ntemp = 4 * blue + 3 * discs - 3;
            blue = btemp;
            discs = ntemp;
        }
        System.out.println(blue);
	}
}