// https://projecteuler.net/problem=80
import java.math.BigInteger;

public class PE080 {
	public static void main(String[] args) {
		// For greater explanation, see:
		// https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#External_links
		// http://www.afjarvis.staff.shef.ac.uk/maths/jarvisspec02.pdf
		 int sum = 0;
         for(int i = 1; i <= 100; i++) {
        	 int sqrt = (int) Math.sqrt(i);
        	 if(sqrt * sqrt != i) {
        		 sum += digitSum(squareRoot(i));
        	 }
         }
        System.out.println(sum);
	}
	public static BigInteger squareRoot(int n) {
		BigInteger a = BigInteger.valueOf(n * 5);
		BigInteger b = BigInteger.valueOf(5);
		while (b.compareTo(BigInteger.TEN.pow(101)) < 0) {
		    if (a.compareTo(b) >= 0) {
		        a = a.subtract(b);
		        b = b.add(BigInteger.TEN);
		    } else {
		        a = a.multiply(BigInteger.valueOf(100));
		        b = b.divide(BigInteger.TEN).multiply(BigInteger.valueOf(100)).add(BigInteger.valueOf(5));                                        
		    }
		}
		
		return b.divide(BigInteger.valueOf(100));
    }
	public static int digitSum(BigInteger n) {
		int sum = 0;
		while(n != BigInteger.ZERO) {
			BigInteger[] m = n.divideAndRemainder(BigInteger.TEN);
			sum += m[1].intValue();
			n = m[0];
		}
		return sum;
	}
}