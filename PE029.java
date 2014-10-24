// https://projecteuler.net/problem=29
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;


public final class PE029 {
	public static void main(String[] args) {
		Set<BigInteger> distinctPowers = new HashSet<BigInteger>();
		for (int a = 2; a <= 100; a++) {
			for (int b = 2; b <= 100; b++)
				distinctPowers.add(BigInteger.valueOf(a).pow(b));
		}
		System.out.println(Integer.toString(distinctPowers.size()));
	}
}