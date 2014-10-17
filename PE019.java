// https://projecteuler.net/problem=19
public class PE019 {
	public static void main(String[] args){
		int day = 2, sundays = 0; //1 Jan 1901 is a Tuesday
		for(int year = 1; year <= 100; year++) {
			for(int month = 1; month <= 12; month++) {
				if(day == 7) {
					sundays++;
				}
				if(month == 2) {
					if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
						day++;
					}
				} else if(month == 4 || month == 6 || month == 9 || month == 11) {
					day += 2;
				} else {
					day += 3;
				}
				
				if(day > 7) {
					day -= 7;
				}
			}
		}
		System.out.println(sundays);
	}
}