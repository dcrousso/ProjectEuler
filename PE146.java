// https://projecteuler.net/problem=146
import java.math.BigInteger;

public class PE146 {
	public static void main(String[] args) {
		long sum = 0;
		for(long n = 10; n < 150000000; n+=10) {
			long s = n * n;
			if(s % 3 != 0 && s % 7 != 0 && s % 9 != 0 && s % 13 != 0 && s % 27 != 0) {
				if(hasConsecutivePrimes(s)) {
					sum += n;
				}
			}
		}
		System.out.println(sum);
	}
	public static boolean hasConsecutivePrimes(long s) {
		// Removed checks for 15 and 25 as they would also be divisible by 5
		int[] consecutive = new int[] {1, 3, -5, 7, 9, -11, 13, -17, -19, -21, -23, 27};
		BigInteger n = BigInteger.valueOf(s);
		for(int i = 0; i < consecutive.length; i++) {
			boolean probable = n.add(BigInteger.valueOf(Math.abs(consecutive[i]))).isProbablePrime(1);
			if((consecutive[i] > 0 && !probable) || (consecutive[i] < 0 && probable))	{
				return false;
			}
		}
		return true;
	}
}