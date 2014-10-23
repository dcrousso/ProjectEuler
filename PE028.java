// https://projecteuler.net/problem=28

public class PE028 {
	public static void main(String[] args){
		int count = 0, left = 1, right = 1;
		for(int i = 1; i <= 1001; i++) {
			if(i < 1001) {
				left += 2 * i;
				count += left;
			}
			right += 4 * Math.floor(i / 2);
			count += right;
		}
		System.out.println(count);
	}
}