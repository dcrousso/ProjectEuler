// https://projecteuler.net/problem=137
public class PE137 {
	public static void main(String[] args) {
		// At first, I used a Fibonacci Power Series
		// (https://en.wikipedia.org/wiki/Fibonacci_number#Power_series)
		/*
		long n = 0;
		int count = 0;		 
		while(count < 15) {
			n++;
		    long radicand = (5 * n * n) + (2 * n) + 1;		 
		    if(Math.sqrt(radicand) % 1 == 0) {
		        count++;
		    }
		}
		System.out.println(n);
		*/
		// but this caused problems after the 10th golden nugget, where n overflowed.
		// Coincidentally, each nugget up until that point could be found by
		// multiplying the Fibonacci numbers corresponding to 2n and 2n + 1
		// (I stumbled on this because I was playing around with Fibonacci numbers since
		// they were used so heavily in the problem)
		// Nugget #1  = 2   -> F(2) * F(3) = 1 * 2  = 2
		// Nugget #2  = 15  -> F(4) * F(5) = 3 * 5  = 15
		// Nugget #3  = 104 -> F(6) * F(7) = 8 * 13 = 104
		// Nugget #15 = F(30) * F(31)
        System.out.println(fibonacci(30) * fibonacci(31));
	}
	public static long fibonacci(long n) {
		// For more explanation, see
		// http://mathworld.wolfram.com/BinetsFibonacciNumberFormula.html
        double rootFive = Math.sqrt(5);
        return (long) ((Math.pow(1 + rootFive, n) - Math.pow(1 - rootFive, n)) / (Math.pow(2, n) * rootFive));             
    }
}