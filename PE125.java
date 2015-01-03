// https://projecteuler.net/problem=125
import java.util.Set;
import java.util.HashSet;

public class PE125 {
	public static void main(String[] args){
		Set<Integer> nums = new HashSet<Integer>();
		for(int i = 1; i <= 10000; i++) {
			int sum = i * i;
			int j = i + 1;
			while(sum < 100000000) {
				sum += j * j;
				if(isPalindrome(String.valueOf(sum))) {
					nums.add(sum);
				}
				j++;
			}
		}
		long sum = 0;
		for(int n : nums) {
			sum += n;
		}
		System.out.println(sum);
	}
	public static boolean isPalindrome(String n) {
		String s1 = n.substring(0, (int) n.length() / 2);
		String s2 = n.substring(n.length() % 2 == 0 ? n.length() / 2 : (n.length() + 1) / 2, n.length());
		s2 = new StringBuilder(s2).reverse().toString();
		if(s1.equals(s2)) {
			return true;
		}
		return false;
	}
}