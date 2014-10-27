// https://projecteuler.net/problem=17
public class PE017 {
	public static void main(String[] args){
		int letters = 0;
		for(int i = 1; i < 1001; i++) {
			letters += countDigits(i);
		}
		System.out.println(letters);
	}
	public static int countDigits(int n) {
		int count = 0;
		if(n < 1000) {
			int ones = n % 10;				
			int tens = n / 10;
			if(n >= 100) {
				tens %= 10;
				int hundreds = n / 100;
				if(hundreds <= 2 || hundreds == 6) {
					count += 3;
				} else if(hundreds == 3 || hundreds == 7 || hundreds == 8) {
					count += 5;
				} else if(hundreds <= 5 || hundreds <= 9){
					count += 4;
				}
				count += 7;
				if(ones != 0 || tens != 0) {
					count += 3; //"and"
				}
			}
			if(tens == 1) {
				if(ones == 0) {
					count += 3;
				} else if(ones <= 2) {
					count += 6;
				} else if(ones <= 4|| ones >= 8) {
					count += 8;
				} else if(ones == 5 || ones == 6 ) {
					count += 7;
				} else if(ones == 7) {
					count += 9;
				}
			} else {
				if(tens != 0) {
					if(tens <= 3 || tens >= 8) {
						count += 6;
					} else if(tens <= 6) {
						count += 5;
					} else {
						count += 7;
					}
				}
				
				if(ones != 0) {
					if(ones <= 2 || ones == 6) {
						count += 3;
					} else if(ones == 3 || ones == 7 || ones == 8) {
						count += 5;
					} else if(ones <= 5 || ones <= 9){
						count += 4;
					}
				}
			}
		} else {
			count = 11;
		}
		return count;
	}
}