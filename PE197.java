// https://projecteuler.net/problem=197
public class PE197 {
	public static void main(String[] args) {
		// For more explanation, see
		// https://en.wikipedia.org/wiki/Recurrence_relation#Stability_of_nonlinear_first-order_recurrences
		// https://en.wikipedia.org/wiki/Iterated_function#Abelian_property_and_Iteration_sequences
		// https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare
		// Essentially, any sequence defined by x = f(x) will eventually repeat a value.
		// As such, by having two different variables iterating at different speeds,
		// this repeat value can be identified and used to skip over a set number of values,
		// that being the difference between the number of steps between the two variables.
		double x = f(-1);
		double y = f(f(-1));
		long i = 0;
		while(i < Math.pow(10, 12) && x != y) {
			x = f(x);
			y = f(f(y));
			i++;
		}
		long remaining = (long) ((Math.pow(10, 12) - i) % i);
		while(remaining > 0) {
			x = f(x);
			remaining--;
		}
		System.out.println(x + f(x));
	}
	public static double f(double x) {
		return Math.floor(Math.pow(2, 30.403243784 - (x * x))) * Math.pow(10, -9);
	}
}