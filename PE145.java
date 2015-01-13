// https://projecteuler.net/problem=145
public class PE145 {
	public static void main(String[] args) {
		 int count = 0;
         for(long i = 1; i < 1000000000; i++) {
             if(isOddWithAddedReverse(i)) {
            	 count++;                
             }
         }
         System.out.println(count);
	}
	public static boolean isOddWithAddedReverse(long n) {
        if(n % 10 != 0) {
	        long reversed = 0, number = n;            
	        while(number > 0) {
	            reversed = (10 * reversed) + (number % 10);
	            number /= 10;
	        }
	        reversed += n;            
	        while(reversed > 0) {
	            if(reversed % 2 == 0) {
	            	return false;
	            }
	            reversed /= 10;
	        }
	        return true;
	        }
        return false; 
    }
}