// https://projecteuler.net/problem=2
public class PE002 {
	public static void main(String[] args){
		int sum = 0, num = 1, prev = 0, temp = 0;
		while(num < 4000000) {
			temp = num;
			num += prev;
			prev = temp;
			if(num % 2 == 0) {
				sum += num;
			}
		}
		System.out.println(sum);
	}
}