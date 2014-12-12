// https://projecteuler.net/problem=62
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PE062 {
	public static void main(String[] args) {
		Map<String, Integer> cubes = new HashMap<String, Integer>();
		Map<String, Integer> permutations = new HashMap<String, Integer>();
		int min = -1, cube = 345;
		while(min == -1) {
			char[] cubeDigits = BigInteger.valueOf(cube).pow(3).toString().toCharArray();
			Arrays.sort(cubeDigits);
			String sortedCubeDigits = new String(cubeDigits);			
			for(String scd : permutations.keySet()) {
				if(permutations.get(scd) == 5 && (cubes.get(scd) < min || min == -1)) {
					min = cubes.get(scd);
				}
			}
			if(cubes.containsKey(sortedCubeDigits)) {
				permutations.put(sortedCubeDigits, permutations.get(sortedCubeDigits) + 1);
			} else {
				cubes.put(sortedCubeDigits, cube);
				permutations.put(sortedCubeDigits, 1);
			}
			cube++;
		}
		System.out.println(BigInteger.valueOf(min).pow(3));
	}
}