// https://projecteuler.net/problem=24
import java.util.Arrays;

public class PE024 {
	public static void main(String[] args){
		int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9};
		for(int i = 0; i <= 1000000; i++) {
			permutation(nums);
		}
		System.out.println(Arrays.toString(nums));
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