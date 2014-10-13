// https://projecteuler.net/problem=5
public class PE005 {
	public static void main(String[] args){
		int i = 20;
		while(!isDivisible(i)) {
			i++;
		}
		System.out.println(i);
	}
	
	public static boolean isDivisible(int n) {
		for(int i = 1; i < 20; i++) {
			if(n % i != 0) {
				return false;
			}
		}
		return true;
	}
}