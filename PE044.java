// https://projecteuler.net/problem=44
public class PE044 {
	public static void main(String[] args) {
		long diff = 0;
		int i = 2;
		while(true) {
			long pI = pentagon(i);
			if (diff != 0 && pI - pentagon(i - 1) > diff) {
				break;
			}
			for(int j = i - 1; j >= 1; j--) {
				long pJ = pentagon(j);
				if(diff != 0 && pI - pJ >= diff) {
					break;
				} else if((diff == 0 || pI - pJ < diff) && isPentagon(pI + pJ) && isPentagon(pI - pJ)) {
					diff = pI - pJ;
				}
			}
			i++;
		}
		System.out.println(diff);
	}
	
	public static long pentagon(int n) {
		return (long) n * (n * 3 - 1) / 2;
	}
	
	public static boolean isPentagon(long n) {
		return (Math.sqrt(n * 24 + 1) % 6 == 5);
	}
}