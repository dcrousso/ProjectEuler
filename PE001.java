// https://projecteuler.net/problem=1
public class PE001 {
	public static void main(String[] args){
		int sum = 0, i = 0;
		while(3 * Math.pow(3, i) < 1000) {
			if(5 * Math.pow(5, i) < 1000) {
				sum += 5 * Math.pow(5, i);
			}
			sum += 3 * Math.pow(3, i);
			i++;
		}
		System.out.println(sum);
	}
}