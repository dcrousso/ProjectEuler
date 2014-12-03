// https://projecteuler.net/problem=85
public class PE085 {
	public static void main(String[] args) {
		int closest = 0, area = 0;
		for (int w = 1; w * w <= 2000000; w++) {
			for (int h = 1; h * h <= 2000000; h++) {
				int numRects = w * (w + 1) * h * (h + 1) / 4;
				int diff = Math.abs(numRects - 2000000);
				if (diff < closest || closest == 0) {
					closest = diff;
					area = w * h;
				}
			}
		}
		System.out.println(area);
	}
}