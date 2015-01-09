// https://projecteuler.net/problem=136
public class PE136 {
	public static void main(String[] args) {
		// Adjusting the bounds from Problem 135
        int[] solutions = new int[50000000];
        for(int u = 1; u < 50000000; u++) {
            for(int v = 1; u * v < 50000000; v++) {
                if((u + v) % 4 == 0 && (3 * v - u) % 4 == 0 && 3 * v  > u) {
                    solutions[u * v]++;                                       
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < solutions.length; i++) {
        	if(solutions[i] == 1) {
        		count++;
        	}
        }
        System.out.println(count);
	}
}