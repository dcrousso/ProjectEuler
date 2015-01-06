// https://projecteuler.net/problem=130
public class PE130 {
	public static void main(String[] args){
		int n = 91;
		int count = 0;
		int sum = 0;
		while(count < 25) {
			if(!isPrime(n) && gcd(n, 10) == 1) { // n must be odd in order to prevent 2 as a common factor
				int x = 1;
	            int k = 1;
	            while(x != 0) {
	                x = (x * 10 + 1) % n; // Long division using remainders
	                // Without using remainders, x quickly grows larger than the max value of Long
	                k++;
	            }
	            if((n - 1) % k == 0) {
	            	sum += n;
	            	count++;
	            }
			}
			n += 2;
		}
		System.out.println(sum);
	}
	public static int gcd(int n, int m) {
		if(m == 0) {
			return n;
		}
		return gcd(m, n % m);
	}
	public static boolean isPrime(int n) {
		if(n == 2) {
			return true;
		}
		if(n == 1 || n % 2 == 0) {
			return false;
		}
		for(int i = 3; i * i <= n; i += 2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}