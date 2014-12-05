// https://projecteuler.net/problem=89
// https://projecteuler.net/project/resources/p089_roman.txt
import java.io.*;

public class PE089 {
	public static void main(String[] args){
		int sum = 0;
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(new File("PE089_roman.txt")));
		    String text = null;
		    while ((text = reader.readLine()) != null) {
		    	sum += text.length() - romanUnitLength(countRomanValue(text));
		    }
		} catch(FileNotFoundException e) {
		    e.printStackTrace();
		} catch(IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if(reader != null) {
		            reader.close();
		        }
		    } catch(IOException e) {
		    	e.printStackTrace();
		    }
		}
		System.out.println(sum);
	}
	
	public static int countRomanValue(String s) {
		Object[][] number = {
			{"M" , 1000},
			{"CM",  900},
			{"D" ,  500},
			{"CD",  400},
			{"C" ,  100},
			{"XC",   90},
			{"L" ,   50},
			{"XL",   40},
			{"X" ,   10},
			{"IX",    9},
			{"V" ,    5},
			{"IV",    4},
			{"I" ,    1},
		};
		int result = 0;
		while(s.length() > 0) {
			for(Object[] n : number) {
				String numeral = (String) n[0];
				if(s.startsWith(numeral)) {
					result += (Integer) n[1];
					s = s.substring(numeral.length());
					break;
				}
			}
		}
		return result;
	}
	
	public static int romanUnitLength(int n) {
		int[] unitLengths = {0, 1, 2, 3, 2, 1, 2, 3, 4, 2};
		int count = 0;
		if(n >= 4000) { // for MMMM
			count += 2;
		}
		while(n > 0) {
			count += unitLengths[n % 10];
			n /= 10;
		}
		return count;
	}
}