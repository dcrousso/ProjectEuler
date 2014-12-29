// https://projecteuler.net/problem=112
public class PE112 {
	public static void main(String[] args) {
		int bouncy = 0;
		int i = 100;
		while(bouncy * 100 < i * 99) {
			i++;
			if(isBouncy(i)) {
				bouncy++;
			}
		}
		System.out.println(i);
	}
	public static boolean isBouncy(int n) {
		boolean increasing = false;
		boolean decreasing = false;
		int lastDigit = n % 10;
		n /= 10;
		while(n > 0) {
			int digit = n % 10;
			if(digit > lastDigit) {
				decreasing = true;
			}
			if (digit < lastDigit) {
				increasing = true;
			}
			lastDigit = digit;
			n /= 10;
		}
		return increasing && decreasing;
	}
}