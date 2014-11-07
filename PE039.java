// https://projecteuler.net/problem=39
public class PE039 {
	public static void main(String[] args) {
		int maxSolutions = 0;
		int maxNum = 0;
		for(int p = 1; p <= 1000; p++) {
			int count = 0;
			for(int a = 1; a <= p; a++) {
				for(int b = a; b <= p; b++) {
					int c = p - b - a;
					if(a * a + b * b == c * c) {
						count++;
					}
				}
			}
			if(count > maxSolutions) {
				maxSolutions = count;
				maxNum = p;
			}
		}
		System.out.println(maxNum);
	}
}