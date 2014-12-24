// https://projecteuler.net/problem=66
import java.math.BigInteger;

public class PE066 {
	public static void main(String[] args) {
		// For more explanation, see
		// http://mathworld.wolfram.com/PellEquation.html
		int smallestD = 0;
		BigInteger largestX = BigInteger.ZERO;
		for(int n = 0; n <= 1000; n++){
			BigInteger sqrt = BigInteger.valueOf((int) Math.sqrt(n));
		    if(sqrt.pow(2).compareTo(BigInteger.valueOf(n)) != 0) {	
		    	BigInteger m = BigInteger.ZERO;
		    	BigInteger d = BigInteger.ONE;
		    	BigInteger a = sqrt;
		    	BigInteger x = a, x0 = BigInteger.ONE, tempx = x0;
		    	BigInteger y = BigInteger.ONE, y0 = BigInteger.ZERO, tempy = y0;
			    while(x.pow(2).subtract(y.pow(2).multiply(BigInteger.valueOf(n))).compareTo(BigInteger.ONE) != 0) {
			        m = d.multiply(a).subtract(m);
			        d = BigInteger.valueOf(n).subtract(m.pow(2)).divide(d);
			        a = sqrt.add(m).divide(d);
			        tempx = x0; // Save previous x & y (i.e. i - 1)
			        tempy = y0;
			        x0 = x; // Save current x & y (i.e. i)
			        y0 = y;
			        x = x.multiply(a).add(tempx); // Set next x & y (i.e. i + 1) using
			        y = y.multiply(a).add(tempy); // continued fraction expansion
			    }
			 
			    if (x.compareTo(largestX) > 0) {
			    	largestX = x;
			    	smallestD = n;
			    }
		    }
		}
		System.out.println(smallestD);
	}
}