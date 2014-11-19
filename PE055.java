// https://projecteuler.net/problem=55
import java.math.BigInteger;

public class PE055 {
	public static void main(String[] args){
		int count = 0;
		for(int i = 0; i < 10000; i++) {
			if(isLychrel(i)) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static boolean isLychrel(int n) {
		int count = 0;
		BigInteger i = BigInteger.valueOf(n);
		while(count < 50) {
			i = i.add(new BigInteger(reverseNum(i.toString())));
			if(isPalindrome(i.toString())) {
				return false;
			}
			count++;
		}
		return true;
	}
	
	public static boolean isPalindrome(String n) {
		String s1 = n.substring(0, (int) n.length() / 2);
		String s2 = n.substring(n.length() % 2 == 0 ? n.length() / 2 : (n.length() + 1) / 2, n.length());
		s2 = new StringBuilder(s2).reverse().toString();
		if(s1.equals(s2)) {
			return true;
		}
		return false;
	}
	
	public static String reverseNum(String n) {
		char[] d = n.toCharArray();
		String s = "";
		for(int i = d.length - 1; i >= 0; i--) {
			s += d[i];
		}
		return s;
	}
}