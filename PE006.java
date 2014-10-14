// https://projecteuler.net/problem=6
public class PE006 {
	public static void main(String[] args){
		int sumSquare = 0, squareSum = 0;
		for(int i = 1; i < 100; i++) {
			sumSquare += i * i;
			squareSum += i;
		}
		squareSum *= squareSum;
		System.out.println(squareSum - sumSquare);
	}
}