// https://projecteuler.net/problem=30

public class PE030 {
	public static void main(String[] args){
		int total = 0;
		for(int i = 2; i < 1000000; i++) {
			int sum = 0, num = i;
			while (num > 0) {
				int digit = num % 10;
				sum += Math.pow(digit, 5);
				num /= 10;
			}
			if(i == sum) {
				total += i;
			}
		}
		System.out.println(total);
	}
}