package evaluator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluator extends Evaluator {
	private Stack<String> operator;
	private Map<String, Integer> priorities;

//	public static void main(String[] args) {
//		InfixEvaluator a = new InfixEvaluator();
//		String o = a.convertToPostfix("( 3 * 2 + 7 ) + ( 10 / 2 )");
//		System.out.println(o);
//	}

	@Override
	public int evaluate(String infix) throws ArithmeticException {
		String postfix = this.convertToPostfix(infix);
		PostfixEvaluator postE = new PostfixEvaluator();
		return postE.evaluate(postfix);
	}

	public String convertToPostfix(String infix) {
		// TODO Auto-generated method stub.
		this.priorities = new HashMap<>();
		this.priorities.put("^", 3);
		this.priorities.put("*", 2);
		this.priorities.put("/", 2);
		this.priorities.put("+", 1);
		this.priorities.put("-", 1);
		this.priorities.put("(", 0);
		this.priorities.put(")", 0);
		
		String postfix = "";
		this.operator = new Stack<String>();
		Scanner s = new Scanner(infix);
		int countL = 0;

		

		while (s.hasNext()) {
			String current = s.next();
			if (current.equals("(")) {
				this.operator.push("(");
				countL++;
			} else if (current.equals(")")) {
				if (countL < 1) {
					s.close();
					throw new ArithmeticException();
				}
				countL--;
				while (!this.operator.peek().equals("(")) {
					postfix += " ";
					postfix += this.operator.pop();
				}
				this.operator.pop();
				// Character o = this.operator.peek();
				// while (!(o.equals('(') && !(this.operator.isEmpty()))) {
				// postfix += ' ';
				// postfix += o;
				// this.operator.pop();
				//
				// o = this.operator.peek();
				//
				// }
				//
				// this.operator.pop();

			} else if (Evaluator.isOperator(current)) {
				while (!this.operator.isEmpty() 
						&& this.priorities.get(this.operator.peek()) >= this.priorities.get(current)) {
					postfix += " ";
					postfix += this.operator.pop();
				}
				this.operator.push(current);
			} else {
				try {
					postfix += " ";
					postfix += Integer.parseInt(current);
				} catch (NumberFormatException n) {
					s.close();
					throw new ArithmeticException();
				}
			}

		}
		if (countL != 0) {
			throw new ArithmeticException();
		}
		while (!this.operator.isEmpty()) {
			String oper = this.operator.peek();
			this.operator.pop();
			postfix += " ";
			postfix += oper;

		}
		postfix = postfix.trim();
		return postfix;

	}
}
