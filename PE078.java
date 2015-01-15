// https://projecteuler.net/problem=078
import java.util.ArrayList;

public class PE078 {
	public static void main(String[] args) {
		// Fore more explanation, see
		// https://en.wikipedia.org/wiki/Pentagonal_number_theorem
		ArrayList<Integer> p = new ArrayList<Integer>();
		p.add(1);
		int n = 0;
		while(p.get(n) != 0) {
			int i = 0;
			int pentagonal = 1;
			p.add(0);
			n++;
			while(pentagonal <= n) {
				int sign = i % 4 > 1 ? -1 : 1;
				p.set(n, p.get(n) + sign * p.get(n - pentagonal));
				p.set(n, p.get(n) % 1000000); // Avoids using BigInteger, since we only need the first value under 1000000
				i++;
				int k = (i % 2 == 0) ? (i / 2) + 1 : -((i / 2) + 1); // 1, -1, 2, -2, ...
				pentagonal = k * ((3 * k) - 1) / 2;
			}
		}
		System.out.println(n);
	}
}