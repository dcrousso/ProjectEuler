// https://projecteuler.net/problem=9
public class PE009 {
	public static void main(String[] args){
		for(int c = 0; c < 998; c++) {
			for(int b = 0; b < c; b++) {
				for(int a = 0; a < b; a++) {
					if(a * a + b * b == c * c && a + b + c == 1000) {
						System.out.println(a * b * c);
					}
				}
			}
		}
	}
}