package evaluator;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator extends Evaluator {
	private Stack<Integer> output;

//	public static void main(String[] args) {
//		PostfixEvaluator a = new PostfixEvaluator();
//		int o = a.evaluate("10 20 + 3 / 12 +");
//		System.out.println(o);
//	}

	@Override
	public int evaluate(String postfix) throws ArithmeticException {
		// TODO Auto-generated method stub.
		this.output = new Stack<Integer>();
		Scanner s = new Scanner(postfix);
		int numcount=0;
		int opercount=0;

		while (s.hasNext()) {
			String current = s.next();
			int operator = "+-*/^".indexOf(current);
			if (current.length() == 1 && operator != -1) {
				if (this.output.size() < 2) {
					s.close();
					throw new ArithmeticException();
				}
				opercount++;
				int a = this.output.pop();
				int b = this.output.pop();

				switch (operator) {
				case 0:
					this.output.push(a + b);
					break;
				case 1:
					this.output.push(b - a);
					break;
				case 2:
					this.output.push(a * b);
					break;
				case 3:
					this.output.push(b / a);
					break;
				case 4:
					this.output.push((int) Math.pow(b, a));
					break;
				}
			} else {
				try {
					numcount++;
					this.output.push(Integer.parseInt(current));
				} catch (NumberFormatException n) {
					s.close();
					throw new ArithmeticException();
				}
			}
		}
		if(numcount-opercount!=1){
			throw new ArithmeticException();
		}
		s.close();
		return this.output.pop();
	}

}
