// https://projecteuler.net/problem=26
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PE026 {
	public static void main(String[] args){
		int longest = 0;
		int num = 0;
		for(int i = 1; i < 1000; i++) {
			BigDecimal n = BigDecimal.ONE.divide(BigDecimal.valueOf(i), 5000, RoundingMode.HALF_UP);
			String repeat = n.toString().replaceAll("0.0+", "");
			repeat = findRepeat(repeat);
			if(repeat.length() > longest) {
				longest = repeat.length();
				num = i;
			}
		}
		System.out.println(num + " : " + longest);
	}
	
	public static String findRepeat(String n) {
		String repeat = "";
		Pattern p = Pattern.compile("(\\d+?)\\1");
		Matcher matcher = p.matcher(n);
		if (matcher.find()) {
			repeat = matcher.group(1);
		}
		return repeat;
	}
}