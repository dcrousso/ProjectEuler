// https://projecteuler.net/problem=4
public class PE004 {
	public static void main(String[] args){
		int largest = 0;
		for(int i = 100; i < 1000; i++) {
			for(int j = i; j < 1000; j++) {
				if(isPalindrome(i * j) && i * j > largest) {
					largest = i * j;
				}
			}
		}
		System.out.println(largest);
	}
	
	public static boolean isPalindrome(int n) {
		int i = 0, j = n;
		while(j > 0) {
			i = (i * 10) + (j % 10);
			j /= 10;
		}
		if(i == n) {
			return true;
		} else {
			return false;
		}
	}
}