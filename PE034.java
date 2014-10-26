// https://projecteuler.net/problem=34
public class PE034 {
	public static void main(String[] args){
		int sum = 0;
		for (int i = 3; i < 10000000; i++) {
			int digitFactorial = 0, digit = i;
			while (digit != 0) {
				digitFactorial += factorial(digit % 10);
				digit /= 10;
			}
			if (i == digitFactorial) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
	public static int factorial(int num) {
		int sum = 1;
		for(int i = 1; i <= num; i++) {
			sum *= i;
		}
		return sum;
	}
}