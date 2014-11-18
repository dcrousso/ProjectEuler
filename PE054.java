// https://projecteuler.net/problem=54
// https://projecteuler.net/project/resources/p054_poker.txt
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class PE054 {
	public static void main(String[] args){
		String[] p1hands = new String[1000];
		String[] p2hands = new String[1000];
		int p1wins = 0;
		BufferedReader reader = null;
		
		try {
		    reader = new BufferedReader(new FileReader(new File("PE054_poker.txt")));
		    String text = null;
		    int i = 0;
		    while ((text = reader.readLine()) != null) {
		    	p1hands[i] = text.substring(0, text.length() / 2);
		    	p2hands[i] = text.substring(text.length() / 2 + 1);
		    	i++;
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
		
		for(int i = 0; i < 1000; i++) {
			if(p1Wins(p1hands[i].split(" "), p2hands[i].split(" "))) {
				p1wins++;
			}
		}
		System.out.println(p1wins);
	}
	
	public static boolean p1Wins(String[] p1, String[] p2) {
		int[][] p1cards = new int[p1.length][];
		int[][] p2cards = new int[p2.length][];
		for(int i = 0; i < 5; i++) {
			p1cards[i] = getCardValue(p1[i]);
			p2cards[i] = getCardValue(p2[i]);
		}
		Arrays.sort(p1cards, intArrayComparator);
		Arrays.sort(p2cards, intArrayComparator);
		
		int p1hand = handValue(p1cards);
		int p2hand = handValue(p2cards);
		System.out.println(p1hand + " : " +p2hand);
		return p1hand > p2hand;
	}
	
	public static int handValue(int[][] h) {
		int value = getHandValue(h);
		if(isPair(h, 0) || isPair(h, 1) || isPair(h, 2) || isPair(h, 3)) {
			if((isPair(h, 0) && isPair(h, 2)) || (isPair(h, 0) && isPair(h, 3))|| (isPair(h, 1) && isPair(h, 3))) {
				value += 8000000;
			}
			if(isThreeKind(h)) {
				value += 6000000;
			}
		} else if(isFlush(h)) {
			if(isStraight(h)) {
				if(h[0][0] == 14) {
					value += 10000000;
				} else {
					value += 9000000;
				}
			} else {
				value += 6000000;
			}
		} else if(isStraight(h)) {
			value += 5000000;
		} else if(isThreeKind(h)) {
			value += 4000000;
		} else {
			value = h[0][0];
		}
		return value;
	}
	
	public static boolean isFlush(int[][] h) {
		for(int i = 0; i < h.length; i++) {
			if(h[i][1] != h[0][1]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isStraight(int[][] h) {
		for(int i = 0; i < h.length - 1; i++) {
			if(h[i][0] != h[i + 1][0]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isThreeKind(int[][] h) {
		if(h[0][0] == h[2][0] || h[1][0] == h[3][0] || h[2][0] == h[4][0]) {
			return true;
		}
		return false;
	}
	
	public static boolean isPair(int[][] h, int s) {
		if(h[s][0] == h[s + 1][0]) {
			return true;
		}
		return false;
	}
	
	public static int getHandValue(int[][] h) {
		int sum = 1;
		for(int i = 0; i < h.length; i++) {
			sum *= h[i][0];
		}
		return sum;
	}
	
	public static int[] getCardValue(String s) {
		return new int[]{"23456789TJQKA".indexOf(s.charAt(0)) + 2, "DCHS".indexOf(s.charAt(1)) + 1};
	}
	
	final static Comparator<int[]> intArrayComparator = new Comparator<int[]>() {
        public int compare(int[] o1, int[] o2) {
            return o1[0] == o2[0] ? 0 : (o1[0] > o2[0] ? 1 : -1);
        }
    };
}