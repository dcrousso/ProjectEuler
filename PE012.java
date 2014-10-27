// https://projecteuler.net/problem=12
public class PE012 {
	public static void main(String[] args){
		int numDivisors = 0;
		int count = 1;
		int currentTriangle = 0;
		while(numDivisors < 500) {
			numDivisors = 0;
			currentTriangle += count;
			count++;
			for(int i = 1; i * i < currentTriangle; i++) {
				if(currentTriangle % i == 0) {
					numDivisors+=2;
				}
			}
			System.out.println(currentTriangle + " : " + numDivisors);
		}
		System.out.println(currentTriangle);
	}
}	