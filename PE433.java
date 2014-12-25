// https://projecteuler.net/problem=433
public class PE433 {
	public static void main(String[] args) {
		int limit = 5000000;
		long steps = 0;
		for(int x = 1; x <= limit; x++) {
			for(int y = 1; y <= limit; y++) {
				steps += euclid(x, y);
			}
		}
		System.out.println(steps);
	}
	public static long euclid(int x, int y) {
		long steps = 0;
		while(y != 0) {
			int temp = y;
			y = x % temp;
			x = temp;
			steps++;
		}
		return steps;
	}
}