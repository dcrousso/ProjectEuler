// https://projecteuler.net/problem=95
import java.util.Set;
import java.util.HashSet;

public class PE095 {
	public static void main(String[] args) {
		int[] sumOfDivisors = new int[1000001];
		for(int i = 1; i <= 1000000; i++) {
			for(int j = i * 2; j <= 1000000; j += i) {
				sumOfDivisors[j] += i;
			}
		}
		int maxLength = 0;
		int smallestElement = -1;
		for(int i = 0; i <= 1000000; i++) {
			Set<Integer> chain = new HashSet<Integer>();
			int count = 1, current = i, next = 0;
			while(next < 1000000 && !chain.contains(next)) {
				chain.add(current);
				next = sumOfDivisors[current];
				if(next == i) { //Chain has looped back to original number
					if(count > maxLength) {
						smallestElement = i;
						maxLength = count;
					}
					break;
				}
				current = next;
				count++;
			}
		}
		System.out.println(smallestElement);
	}
}