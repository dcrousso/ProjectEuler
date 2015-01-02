// https://projecteuler.net/problem=124
import java.util.Arrays;

public class PE124 {
	public static void main(String[] args) {
		int[] rads = new int[100001];
		Arrays.fill(rads, 1);
		for(int i = 2; i <= 100000; i++) {
			if(rads[i] == 1) {
				for(int j = i; j <= 100000; j += i) {
					rads[j] *= i;
				}
			}
		}
		RadValue[] sorted = new RadValue[100000];
		for(int i = 0; i < sorted.length; i++) {
			sorted[i] = new RadValue(rads[i + 1], i + 1);
		}
		Arrays.sort(sorted);
		System.out.println(sorted[9999].n);
	}
	
	public static class RadValue implements Comparable<RadValue> {
		public int rad, n;
		
		public RadValue(int rad, int n) {
			this.rad = rad;
			this.n = n;
		}
		
		public int compareTo(RadValue rv) {
			if(this.rad > rv.rad) {
				return 1;
			} else if(this.rad < rv.rad) {
	        	return -1;
	        } else return (this.n > rv.n ? 1 : -1);
		}
	}
}
