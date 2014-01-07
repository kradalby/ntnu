package oving2;

import java.util.Stack;
import java.util.EmptyStackException;

import acm.program.ConsoleProgram;

public class ConsoleRPN extends ConsoleProgram {

	Stack<Double> stack = new Stack<Double>();
	double a,b;
	String input;
	double defaultValue;
	
	public void init() {}
	
	
	public void run() {
	
		while (true) {
			input = readLine("Input: ");
			
			if (input.equalsIgnoreCase("stop")) {
				print("Programmet er stoppet");
				break;
			} else {
				performeOperation(input);
			}
			if (stack.empty()) {
				stack.push(defaultValue);				
			}
			print (stack + "\r\n");
			
		}
	}


	private void performeOperation(String input) {
		if (Character.isDigit(input.charAt(0))) {
			double n = Double.parseDouble(input);
			stack.push(n);			
		} else {
			a = stack.pop();
			char tegn = input.charAt(0);
			switch (tegn) {
				case '+':
					b = stack.pop();
					stack.push(a + b); 
					break;
				case '-': 
					b = stack.pop();
					stack.push(b-a); 
					break;
				case '*': 
					b = stack.pop();
					stack.push(b*a); 
					break;
				case '/': 
					b = stack.pop();
					stack.push(b/a); 
					break;
				case '.':
					break;
				case ',':
					stack.push(a);
					stack.push(a);
			}	
		}
	}	
}	