// https://projecteuler.net/problem=58
public class PE058 {
	public static void main(String[] args){
		int primes = 0;
		int s = 3;
		while((primes == 0 ? 1 : primes) * 10 >= 2 * s - 1) {
			for(int i = 1; i < 4; i++) {
				if(isPrime(s * s - i * (s - 1))) {
					primes++;
				}
			}
			s += 2;
		}
		System.out.println(s);
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