// https://projecteuler.net/problem=3
public class PE003 {
	public static void main(String[] args){
		long num = 600851475143L;
		long largest = 0;
		for(long i = 3; i * i < num; i += 2) {
			if(num % i == 0 && isPrime(i)){
				if(i > largest) {
					largest = i;
				}
			}
		}
		System.out.println(largest);
	}
	
	public static boolean isPrime(long n) {
		if(n % 2 == 0) {
			return false;
		}
		for(long i = 3; i * i < n; i += 2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}