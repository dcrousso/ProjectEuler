// https://projecteuler.net/problem=031
public class PE031 {
	public static void main(String[] args) {
		int ways = 1;
		for(int hundred = 0; hundred <= 200; hundred += 100) {
			for(int fifty = 0; fifty <= 200 - hundred; fifty += 50) {
				for(int twenty = 0; twenty <= 200 - hundred - fifty; twenty += 20) {
					for(int ten = 0; ten <= 200 - hundred - fifty - twenty; ten += 10) {
						for(int five = 0; five <= 200 - hundred - fifty - twenty - ten; five += 5) {
							for(int two = 0; two <= 200 - hundred - fifty - twenty - ten - five; two += 2) {
								for(int one = 0; one <= 200 - hundred - fifty - twenty - ten - five - two; one++) {
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