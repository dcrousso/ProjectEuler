// https://projecteuler.net/problem=109
import java.util.ArrayList;

public class PE109 {
	public static void main(String[] args) {
		int countMMD = 0;
		int countMHD = 0;
		int countHHD = 0;
		
		ArrayList<Integer> singles = new ArrayList<Integer>();
		for (int i = 1; i <= 20; i++) {
			for(int j = 1; j <= 3; j++) {
				singles.add(i * j);
			}
		}
		singles.add(25);
		singles.add(50);
		
		ArrayList<Integer> doubles = new ArrayList<Integer>();
		for (int i = 1; i <= 20; i++) {
			doubles.add(i * 2);
		}
		doubles.add(50); // 25 * 2
		

		for (int i = 0; i < singles.size(); i++) {
			for (int j = i; j < singles.size(); j++) {
				for(int k = 0; k < doubles.size(); k++) {
	                if(doubles.get(k) < 100) { // Miss Miss Double
	                	countMMD ++;
	                    if(singles.get(j) + doubles.get(k) < 100) { // Miss Hit Double
		                    countMHD ++;
		                    if(singles.get(i) + singles.get(j) + doubles.get(k) < 100) { // Hit Hit Double
			                    countHHD++;
			                }
		                }
	                }
	            }
			}
        }
		int count = (int) (countHHD + ((float) countMHD / singles.size()) + ((float) countMMD / singles.size()));
		System.out.println(count);
	}
}