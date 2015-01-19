// https://projecteuler.net/problem=174
public class PE174 {
	public static void main(String[] args) {
		// Same logic as Problem 173, but using an array to count the number of
		// possible distinct Laminae and counting the how many of those have less than 10
		int[] ways = new int[1000000];
		for(int outer = 3; outer <= 250001; outer++) {
			for(int inner = outer - 2; inner >= 1; inner -= 2) {
				long numTiles = ((long) outer * outer) - ((long) inner * inner);
				if(numTiles > 1000000) {
					break;
				}
				ways[((int)numTiles) - 1]++;
			}
		}
		int count = 0;
		for(int i = 0; i < ways.length; i++) {
			if (ways[i] >= 1 && ways[i] <= 10) {
				count++;
			}
		}
		System.out.println(count);
	}
}