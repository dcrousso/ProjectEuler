// https://projecteuler.net/problem=86
public class PE086 {
	public static void main(String[] args) {
		int m = 100;
        int count = 2060;
        while(count < 1000000) {
            m++;
            for(int i = 1; i <= 2 * m; i++) {
                if(Math.sqrt(i * i + m *m) % 1 == 0) { // Not a pythagorean triple
                	if(i <= m) {
                		count += i / 2; // Number of solutions from [0, i / 2]
                	} else {
                		count += m - (i - 1) / 2; // Number of solutions from [(i - 1) / 2, m]
                	}
                }
            }
        }
        System.out.println(m);
	}
}