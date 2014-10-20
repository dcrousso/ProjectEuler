// https://projecteuler.net/problem=23
public class PE023 {
	public static void main(String[] args){
		int sum = 0;
		boolean[] abundant = new boolean[28124];
		for(int i = 0; i < abundant.length; i++) {
			abundant[i] = isAbundant(i);
		}
		for(int i = 1; i < abundant.length; i++) {
			if(!isSumOfAbundant(abundant, i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
	public static boolean isAbundant(int n) {
		int sum = 0;
		for(int i = 1; i < Math.floor(n / 2) + 1; i++){ 
			if(n % i == 0) {
				sum += i;
			}
		}
		return sum > n;
	}
	
	public static boolean isSumOfAbundant(boolean[] abundant, int n) {
		for(int i = 0; i < n; i++) {
			if(abundant[i] && abundant[n - i]) {
				return true;
			}
		}
		return false;
	}
}