// https://projecteuler.net/problem=225
public class PE225 {
	public static void main(String[] args) {
		int count = 0;
		int i = -1; // Equivalent to i = 1 since the next operation is i+=2
		while(count < 124) {
			i += 2;
			if(!cycleIsDivisible(i)) {
				count++;
			}
		}
		System.out.println(i);
	}
	public static boolean cycleIsDivisible(int mod) {
		// Floyd's cycle-finding algorithm (modified for tribonacci)
		// (https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare)
		int[] slow = {1 % mod, 1 % mod, 1 % mod};
		int[] fast = {1 % mod, 1 % mod, 1 % mod};
		while(true) {
			// At some point slow was evenly divisible by mod, meaning that
			// there is a value for which mod divides evenly along the chain
			if(slow[0] == 0 || slow[1] == 0 || slow[2] == 0) {
				return true;
			}
			slow = next(slow, mod); // Advance slow by one value
			fast = next(next(fast, mod), mod); // Advance fast by two values
			// If slow and fast are equal, the cycle slow repeats
			if(slow[0] == fast[0] && slow[1] == fast[1] && slow[2] == fast[2]) {
				return false;
			}
		}
	}
	public static int[] next(int[] n, int mod) {
		int temp = (n[0] + n[1] + n[2]) % mod;
		n[0] = n[1];
		n[1] = n[2];
		n[2] = temp;
		return n;
	}
}