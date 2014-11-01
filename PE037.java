// https://projecteuler.net/problem=37
public class PE037 {
	public static void main(String[] args){
		int sum = 0, count = 0;
		for(int i = 11; count < 11; i+=2) {
			if(isPrime(i) && isTruncatable(i)) {
				sum += i;
				count++;
			}
		}
		System.out.println(sum);
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
	
	public static boolean isTruncatable(int num) {
		for (int i = 10; i <= num; i *= 10) {
			if (!isPrime(num % i)) {
				return false;
			}
		}
		for(int i = num; i > 0; i /= 10) {
			if(!isPrime(i)) {
				return false;
			}
		}
		return true;
	}
}