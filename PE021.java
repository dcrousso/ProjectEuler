// https://projecteuler.net/problem=21
public class PE021 {
	public static void main(String[] args){
		int sum = 0;
		for(int i = 0; i < 10000; i++) {
			if(i != divisors(i) && i == divisors(divisors(i))) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	public static int divisors(int n) {
		int sum = 0;
		for(int i = 1; i < n; i++) {
			if(n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
}