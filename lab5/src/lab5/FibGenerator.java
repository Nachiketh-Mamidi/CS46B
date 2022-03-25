package lab5;

public class FibGenerator {
	private int[] callCounter;
	
	public int nthFib(int n) {
		callCounter = new int[n+1];
		return computeFibRecurse(n);
	}
	
	private int computeFibRecurse(int n) {
		callCounter[n] += 1;
		if(n ==1 || n == 2) {
			return 1;
		} else {
			return computeFibRecurse(n - 2) + computeFibRecurse(n - 1);
		}
	}
	
	void printCallCounter() {
		for (int i = 0; i < callCounter.length; i ++) {
			System.out.printf(callCounter[i] + " calls to fib(%d)%n", i);
		}
	}
	
	public static void main(String[] args) {
		FibGenerator fg = new FibGenerator();
		System.out.println(fg.nthFib(20));
		fg.printCallCounter();
	}
}
