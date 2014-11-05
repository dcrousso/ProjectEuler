// https://projecteuler.net/problem=41
public class PE041 {
	public static void main(String[] args){
		int largest = 0;
		int i = 987654321;
		while(largest == 0) {
			if(isPandigital(i) && isPrime(i) && i > largest) {
				largest = i;
			}
			i-=2;
		}
		System.out.println(largest);
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
	public static boolean isPandigital(int n) {
		for(int i = n; i > 0; i /= 10) {
			for(int j = i / 10; j > 0; j /= 10) {
				if(i % 10 == 0 || j % 10 == 0 || i % 10 == j % 10) {
					return false;
				}
			}
		}
		return true;
	}
}