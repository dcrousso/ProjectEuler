// https://projecteuler.net/problem=22
// https://projecteuler.net/project/resources/p022_names.txt
import java.io.*;
import java.util.Arrays;

public class PE022 {
	public static void main(String[] args){
		String[] names = new String[]{};
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int sum = 0;
		BufferedReader reader = null;
		
		try {
		    reader = new BufferedReader(new FileReader(new File("PE022_names.txt")));
		    String text = null;

		    while ((text = reader.readLine()) != null) {
		    	text = text.substring(1, text.length() - 1);
		        names = text.split("\",\"");
		        Arrays.sort(names);
		        for(int i = 0; i < names.length; i++) {
		        	int numericValue = 0;
		        	for(int j = 0; j < names[i].length(); j++) {
		        		numericValue += letters.indexOf(names[i].charAt(j)) + 1;
		        	}
		        	sum += numericValue * (i + 1);
		        }
		        System.out.println(sum);
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
}