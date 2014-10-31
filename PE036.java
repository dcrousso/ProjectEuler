// https://projecteuler.net/problem=36
public class PE036 {
	public static void main(String[] args){
		int sum = 0;
		for(int i = 0; i < 1000000; i++) {
			if(isPalindrome(Integer.toString(i)) && isPalindrome(Integer.toString(i, 2))) {
				sum += i;
			}
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