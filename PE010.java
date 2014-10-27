// https://projecteuler.net/problem=10
public class PE010 {
	public static void main(String[] args){
		long sum = 2;
		for(int i = 3; i < 2000000; i += 2) {
			if(isPrime(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	public static boolean isPrime(int n) {
		for(int i = 3; i * i <= n; i += 2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}