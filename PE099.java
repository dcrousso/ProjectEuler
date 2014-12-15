// https://projecteuler.net/problem=99
// https://projecteuler.net/project/resources/p099_base_exp.txt
import java.io.*;

public class PE099 {
	public static void main(String[] args){
		double highest = 0;
		int highestLine = 0;
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(new File("PE099_base_exp.txt")));
		    String text = null;
		    int count = 1;
		    while ((text = reader.readLine()) != null) {
		    	String[] line = text.split(",");
		    	double base = Math.log10(Integer.parseInt(line[0]));
		    	double exp = Integer.parseInt(line[1]);
		    	double num = base * exp;
		    	if(num > highest) {
		    		highest = num;
		    		highestLine = count;
		    	}
		    	count++;
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
		System.out.println(highestLine);
	}
}