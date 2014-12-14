// https://projecteuler.net/problem=76
public class PE076 {
	public static void main(String[] args) {
        int[] sums = new int[101];
        sums[0] = 1;
        for (int i = 1; i <= 99; i++) {
            for (int j = i; j <= 100; j++) {
            	sums[j] += sums[j - i];
            }
        }
        System.out.println(sums[sums.length - 1]);
	}
}