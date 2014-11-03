// https://projecteuler.net/problem=40
public class PE040 {
	public static void main(String[] args){
		StringBuilder nums = new StringBuilder();
		for(int i = 1; nums.length() <= 1000000; i++) {
			nums.append(i);
		}
		int product = 1;
		for(int i = 0; i < 6; i++) {
			int d = Character.getNumericValue(nums.charAt((int) Math.pow(10, i) - 1));
			if(d != 0) {
				product *= d;
			}
		}
		System.out.println(product);
	}
}