// https://projecteuler.net/problem=45
public class PE045 {
	public static void main(String[] args){
		int t = 286;
		int p = 166;
		int h = 144;
		while(true) {
			long triangle = (long) t * (t + 1) / 2;
			long pentagon = (long) p * (p * 3 - 1) / 2;
			long hexagon  = (long) h * (h * 2 - 1);
			if(triangle == pentagon && triangle == hexagon){
				break;
			} else if(triangle <= pentagon && triangle <= hexagon) {
				t++;
			} else if(pentagon <= triangle && pentagon <= hexagon) {
				p++;
			} else if(hexagon <= triangle && hexagon <= pentagon) {
				h++;
			}
			
		}
		System.out.println((long) t * (t + 1) / 2);
	}
}