// https://projecteuler.net/problem=35
public class PE035 {
	public static void main(String[] args){
		int count = 0;
		for(int i = 2; i < 1000000; i++) {
			if(isPrime(i) && isCircular(i)) {
				count++;
			}
		}
		System.out.println(count);
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
	
	public static boolean isCircular(int num) {
		String s = Integer.toString(num);
		for (int i = 0; i < s.length(); i++) {
			if (!isPrime(Integer.parseInt(s.substring(i) + s.substring(0, i)))) {
				return false;
			}
		}
		return true;
	}
}