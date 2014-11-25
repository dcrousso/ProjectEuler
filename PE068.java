// https://projecteuler.net/problem=68
import java.math.BigInteger;
import java.util.Arrays;

public class PE068 {
	public static void main(String[] args){
		int[] fiveGon = new int[]{1,2,3,4,5,6,7,8,9,10};
		
		BigInteger largest = BigInteger.ZERO;
		while(!Arrays.equals(fiveGon, new int[]{10,9,8,7,6,5,4,3,2,1})) {
			permutation(fiveGon);
			int sum = fiveGon[0] + fiveGon[5] + fiveGon[6];
			while((fiveGon[1] + fiveGon[6] + fiveGon[7] != sum
				|| fiveGon[2] + fiveGon[7] + fiveGon[8] != sum
			 	|| fiveGon[3] + fiveGon[8] + fiveGon[9] != sum
				|| fiveGon[4] + fiveGon[9] + fiveGon[5] != sum) && !Arrays.equals(fiveGon, new int[]{10,9,8,7,6,5,4,3,2,1})) {
				sum = fiveGon[0] + fiveGon[5] + fiveGon[6];
				permutation(fiveGon);
			}
			//Outer ring has smallest values of [1, 6]
			int smallestOuterIndex = 0, smallestOuter = 7;
			for(int i = 0; i < 5; i++) {
				if (fiveGon[i] < smallestOuter) {
					smallestOuterIndex = i;
					smallestOuter = fiveGon[i];
				}
			}
			String s = "";
			for(int i = 0; i < 5; i++) {
				s += "" + fiveGon[(smallestOuterIndex + i) % 5] + fiveGon[(smallestOuterIndex + i) % 5 + 5] + fiveGon[(smallestOuterIndex + i + 1) % 5 + 5];
			}
			BigInteger fiveGonValue = new BigInteger(s);
			if(s.length() == 16 && (fiveGonValue.compareTo(largest) > 0)) {
				largest = fiveGonValue;
			}
		}
		System.out.println(largest);
	}
	
	public static void permutation(int[] nums) {
		int i = nums.length - 2;
		while(nums[i] > nums[i + 1]) {
			i--;
		}
		// Switches to the next unused digit
		for (int j = 1; i + j < nums.length - j; j++) {
			int temp = nums[i + j];
			nums[i + j] = nums[nums.length - j];
			nums[nums.length - j] = temp;
		}
		int j = i + 1;
		while(nums[j] <= nums[i]) {
			j++;
		}
		// Individual permutation
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}