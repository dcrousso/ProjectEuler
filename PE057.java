// https://projecteuler.net/problem=57
import java.math.BigInteger;

public class PE057 {
	public static void main(String[] args){
		BigInteger n = BigInteger.ZERO;
		BigInteger d = BigInteger.ONE;
		int count = 0;
		for(int i = 0; i < 1000; i++) {
			BigInteger temp = d.multiply(new BigInteger("2")).add(n);
			n = d;
			d = temp;
			if(n.add(d).toString().length() > d.toString().length()) {
				count++;
			}
		}
		System.out.println(count);
	}
}