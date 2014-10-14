// https://projecteuler.net/problem=7
public class PE007 {
	public static void main(String[] args){
		int count = 0, i = 1;
		while(count < 10001) {
			i++;
			if(isPrime(i)) {
				count++;
			}
		}
		System.out.println(i);
	}
	
	public static boolean isPrime(int n) {
		if(n % 2 == 0) {
			return false;
		}
		for(int i = 3; i * i < n; i += 2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}