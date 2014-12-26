// https://projecteuler.net/problem=102
// https://projecteuler.net/project/resources/p102_triangles.txt
import java.io.*;

public class PE102 {
	public static void main(String[] args){
		int count = 0;
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(new File("PE102_triangles.txt")));
		    String text = null;
		    while ((text = reader.readLine()) != null) {
		    	String[] line = text.split(",");
		    	int[] a = new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])};
		    	int[] b = new int[]{Integer.parseInt(line[2]), Integer.parseInt(line[3])};
		    	int[] c = new int[]{Integer.parseInt(line[4]), Integer.parseInt(line[5])};
		    	int[] origin = new int[]{0, 0};
		    	if(area(a, b, c) == area(a, b, origin) + area(a, origin, c) + area(origin, b, c)) {
		    		count++;
		    	}
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
		System.out.println(count);
	}
	public static float area(int[] a, int[] b, int[] c) {
		// For more explanation, see
		// https://en.wikipedia.org/wiki/Triangle#Using_coordinates
        return (float) Math.abs(a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])) / 2;
    }
}