// https://projecteuler.net/problem=97
import java.math.BigInteger;

public class PE097 {
	public static void main(String[] args) {
		BigInteger nonMersenne = BigInteger.valueOf(2).pow(7830457);
		nonMersenne = nonMersenne.multiply(BigInteger.valueOf(28433));
		nonMersenne = nonMersenne.add(BigInteger.ONE).mod(BigInteger.TEN.pow(10));
		System.out.println(nonMersenne);
	}
}