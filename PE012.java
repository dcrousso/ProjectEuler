// https://projecteuler.net/problem=12
public class PE012 {
	public static void main(String[] args){
		int numDivisors = 1;
		int count = 1;
		int currentTriangle = 0;
		while(numDivisors < 500) {
			numDivisors = 1;
			currentTriangle += count;
			count++;
			for(int i = 1; i * i < currentTriangle; i++) {
				if(currentTriangle % i == 0) {
					numDivisors++;
				}
			}
		}
		System.out.println(currentTriangle);
	}
}