// https://projecteuler.net/problem=94
public class PE094 {
	public static void main(String[] args) {
		long sum = 0;
		long a = 2, b = 1; // Smallest possible triangle
		// For more explanation, see
		// https://en.wikipedia.org/wiki/Pell%27s_equation#Additional_solutions_from_the_fundamental_solution
		while(2 * a + 1 < Math.pow(10, 9)){
			for(int i = 0; i <= 1; i++) {
				int offset = (int) Math.pow(-1, i); // 1 or -1
			    long almostEquilateral = 2 * a + offset;
			    long area = b * (a + 2 * offset);		 
			    if(almostEquilateral % 3 == 0 && area % 3 == 0 && area > 0) {
			        sum += almostEquilateral + offset;
			    }
			}
		    long temp = a;
		    a = a * 2 + b * 3;
		    b = b * 2 + temp;
		}
		System.out.println(sum);
	}
}