// https://projecteuler.net/problem=77
import java.util.ArrayList;

public class PE077 {
	public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        int index = 1;
        while(primes.get(index) < 100) {
        	primes.add(nextPrime(primes.get(index)));
        	index++;
        }
		int currentPrime = 2;
        while(true) {
            int[] ways = new int[currentPrime + 1];
            ways[0] = 1;
            for(int i = 0; i < primes.size(); i++) {                    
                for(int j = primes.get(i); j <= currentPrime; j++) {
                    ways[j] += ways[j - primes.get(i)];
                }
            }              
            if(ways[currentPrime] > 5000) {
            	break;
            }
            currentPrime++;
        }
        System.out.println(currentPrime);
	}
	public static boolean isPrime(int n) {
		if(n == 2) {
			return true;
		}
		if(n == 1 || n % 2 == 0) {
			return false;
		}
		for(int i = 3; i * i <= n; i += 2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static int nextPrime(int n) {
		int i = n + 2;
		while(!isPrime(i)) {
			i+=2;
		}
		return i;
	}
}