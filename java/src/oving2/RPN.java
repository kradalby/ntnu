package oving2;

import java.util.Stack;
import java.util.EmptyStackException;

public class RPN {
	
	Stack<Double> stack = new Stack<Double>();
	double o1, o2;
	
	int getOperandCount() {
		return stack.size();
		
	}
	
	double peek(int n){
		return stack.get(n);
		
	}
	
	void push(double value)	{
		stack.push(value);
		
	}
	
	double pop(double defaultValue)	{
		try { 
		return stack.pop();
		} catch (EmptyStackException error) {
			System.out.println("Stack is empty");
		}
		return defaultValue;
	}
	
	void performOperation(char operator) {
		if (getOperandCount() < 2) {
			System.out.println("Stack has two few operander");
		} else {
			o2 = pop(0);
			o1 = pop(0);
					
			switch (operator) {
				case '+': push(o2+o1); break;
				case '-': push(o1-o2); break;
				case '*': push(o2*o1); break;
				case '/': push(o1/o2); break;
				case ',': push(o1);push(o2);push(o2); break;
			}
		}
	}
}