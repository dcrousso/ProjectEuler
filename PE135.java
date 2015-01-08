// https://projecteuler.net/problem=135
public class PE135 {
	public static void main(String[] args) {
		// In the example 34^2 - 27^2 - 20^2 = 27,
		// it can be seen that this equation is an Arithmatic Progression.
		// https://en.wikipedia.org/wiki/Arithmetic_progression
		// Following this form, the equation can be rewritten as
		// (z + 2c)^2 - (z + c)^2 - z^2 = n or 3c^2 + 2cz - z^2 = n.
		// Factoring this gives (3d - z)(d + z) = n
		// Using the substitutions u = 3d - z and v = d + z,
		// d = (u + v)/4 and z = (3v - u)/4     (this also gives n = uv)
		// From this, u + v and 3v - u must both be evenly divisible by 4
		// Lastly, 3v must be greater than u in order for z to be positive
        int[] solutions = new int[1000000];
        for(int u = 1; u < 1000000; u++) {
            for(int v = 1; u * v < 1000000; v++) {
                if((u + v) % 4 == 0 && (3 * v - u) % 4 == 0 && 3 * v  > u) {
                    solutions[u * v]++;                                       
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < solutions.length; i++) {
        	if(solutions[i] == 10) {
        		count++;
        	}
        }
        System.out.println(count);
	}
}