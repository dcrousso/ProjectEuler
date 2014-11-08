// https://projecteuler.net/problem=42
// https://projecteuler.net/project/resources/p042_words.txt
import java.io.*;

public class PE042 {
	public static void main(String[] args){
		String[] names = new String[]{};
		int count = 0;
		BufferedReader reader = null;
		
		try {
		    reader = new BufferedReader(new FileReader(new File("PE042_words.txt")));
		    String text = null;

		    while ((text = reader.readLine()) != null) {
		    	text = text.substring(1, text.length() - 1);
		        names = text.split("\",\"");
		        for(int i = 0; i < names.length; i++) {
		        	int numericValue = 0;
		        	for(int j = 0; j < names[i].length(); j++) {
		        		numericValue += (names[i].charAt(j) - 'A') + 1;
		        	}
		        	if(isTriangle(numericValue)) {
		        		count++;
		        	}
		        }
		        System.out.println(count);
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
	}
	
	public static boolean isTriangle(int n) {
		for(int i = 0; 0.5 * i * (i + 1) <= n; i++) {
			if(0.5 * i * (i + 1) == n) {
				return true;
			}
		}
		return false;
	}
}