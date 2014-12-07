// https://projecteuler.net/problem=92
public class PE092 {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 1; i < Math.pow(10, 7); i++) {
			if(is89Repeat(i)) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static boolean is89Repeat(int x) {
		if(x == 89) {
			return true;
		} else if (x == 1) {
			return false;
		} else return is89Repeat(sumSquareDigits(x));
	}
	
	public static int sumSquareDigits(int x) {
		int sum = 0;
		while (x != 0) {
			sum += Math.pow(x % 10, 2);
			x /= 10;
		}
		return sum;
	}
}