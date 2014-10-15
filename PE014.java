// https://projecteuler.net/problem=14
public class PE014 {
	public static void main(String[] args){
		int longestChain = 0;
		for(int i = 2; i < 1000000; i++) {
			int n = i;
			int chain = 0;
			while(n > 1) {
				if(n % 2 ==0) {
					n /= 2;
					chain++;
				} else {
					n = n * 3 + 1;
					chain++;
				}
			}
			if(chain > longestChain) {
				longestChain = chain;
			}
		}
		System.out.println(longestChain);
	}
}