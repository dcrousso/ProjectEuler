// https://projecteuler.net/problem=187
public class PE187 {
	public static void main(String[] args) {
		int[] semiprimes = new int[(int) Math.pow(10, 8)];
		for(int i = 2; i < Math.pow(10, 8); i++) {
			if(semiprimes[i] == 0) {
				for(int j = 1; j * i < Math.pow(10, 8); j++) {
					semiprimes[j * i]++; // Already have one factor, that being j
					int exp = j; // Number of times j multiplies into semiprimes[j * i]
					// Modified form of GCD algorithm
					while(exp % i == 0) {
						semiprimes[j * i]++;
						exp /= i;
					}
				}
			}
		}
		int count = 0;
		for(int i = 0; i < semiprimes.length; i++) {
			if(semiprimes[i] == 2) {
				count++;
			}
		}
		System.out.println(count);
	}
}