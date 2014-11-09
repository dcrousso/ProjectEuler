// https://projecteuler.net/problem=43
import java.util.Arrays;

public class PE043 {
	public static void main(String[] args) {
		long sum = 0;
		int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9};
		while(!Arrays.equals(nums, new int[]{9,8,7,6,5,4,3,2,1,0})) {
			if(isDivisible(nums)) {
				for(int i = 0; i < nums.length; i++) {
					sum += (nums[i] * Math.pow(10, 9 - i));
				}
			}
			permutation(nums);
		}
		System.out.println(sum);
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
	
	public static boolean isDivisible(int[] nums) {
		int[] divisors = new int[]{2, 3, 5, 7, 11, 13, 17};
		for(int i = 0; i < divisors.length; i++) {
			if((nums[i + 1] * 100 + nums[i + 2] * 10 + nums[i + 3]) % divisors[i] != 0) {
				return false;
			}
		}
		return true;
	}
}