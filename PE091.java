// https://projecteuler.net/problem=91
public class PE091 {
	public static void main(String[] args) {
		int count = 0;
		for(int x1 = 0; x1 <= 50; x1++) {
			for(int y1 = 0; y1 <= 50; y1++) {
				for(int x2 = 0; x2 <= 50; x2++) {
					for(int y2 = 0; y2 <= 50; y2++) {
						if(x1 * y2 < x2 * y1 && isRightTriangle(x1, y1, x2, y2)) { //To prevent duplicates, angle (x1 / y1) must be less than angle (x2 / y2)
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
	}
	
	public static boolean isRightTriangle(int x1, int y1, int x2, int y2) {
		int dx = x2 - x1;
		int dy = y2 - y1;
		int p1 = x1*x1 + y1*y1;
		int p2 = x2*x2 + y2*y2;
		int pd = dx*dx + dy*dy;
		return p1 + p2 == pd || p1 + pd == p2 || p2 + pd == p1; //Possible variations of Pythagorean theorem
	}
}