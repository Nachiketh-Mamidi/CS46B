package lab5;

public class FactorialGenerator {
	
	public double nthFactorial(int n) {
		return computeFactorialRecurse(n);
	}
	
	private double computeFactorialRecurse(int n) {
		assert n >= 0 : "n needs to be positive";
		if (n == 0) {
			return 1;
		} else {
			return n * computeFactorialRecurse(n-1);
		}
	}
	
	public static void main (String[] args) {
		FactorialGenerator fGen = new FactorialGenerator();
		long l = Long.MAX_VALUE;
		System.out.println(l);
		for (int i = -1; i < 32; i ++) {
			System.out.println(fGen.nthFactorial(i));
		}
	}
}

