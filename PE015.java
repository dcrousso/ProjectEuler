// https://projecteuler.net/problem=15
import java.math.BigInteger;

public class PE015 {
	public static void main(String[] args){
		int moves = 40;
		int right = 20;
		
		//										 moves!
		// Combinations(moves, right) = -------------------------
		//								right! * (moves - right)!
		System.out.println(factorial(moves).divide(factorial(right).multiply(factorial(moves-right))));
	}
	public static BigInteger factorial(int n) {
		BigInteger bi = BigInteger.ONE;
		for(int i = 1; i <= n; i++) {
			bi = bi.multiply(BigInteger.valueOf(i));
		}
		return bi;
	}
}