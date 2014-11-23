// https://projecteuler.net/problem=63
import java.math.BigInteger;

public class PE063 {
	public static void main(String[] args){
		int count = 0;
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 21; j++) {
				if (BigInteger.valueOf(i).pow(j).toString().length() == j) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}