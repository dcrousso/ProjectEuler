// https://projecteuler.net/problem=031
public class PE031 {
	public static void main(String[] args) {
		int ways = 1;
		for(int hundred = 0; hundred <= 200; hundred += 100) {
			for(int fifty = 0; fifty <= 200; fifty += 50) {
				for(int twenty = 0; twenty <= 200; twenty += 20) {
					for(int ten = 0; ten <= 200; ten += 10) {
						for(int five = 0; five <= 200; five += 5) {
							for(int two = 0; two <= 200; two += 2) {
								for(int one = 0; one <= 200; one++) {
									if(hundred + fifty + twenty + ten + five + two + one == 200) {
										ways++;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(ways);
	}
}