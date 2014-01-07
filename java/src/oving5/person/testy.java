package oving5.person;

import acm.program.ConsoleProgram;

public class testy extends ConsoleProgram{
	
	public void init() {
		
	}
	
	public void run() {
		Person father = new Person('m');
		Person mother = new Person('f');
		Person child1 = new Person('m');
		Person child2 = new Person('m');
		Person child3 = new Person('f');
		
		// add once
		child1.setFather(father);
		child1.setMother(mother);
		child1.setFather(father);
		child1.setMother(mother);
		println(child1.mother);
		println(child1.father);
		println(father.children);
		println(mother.children);
		println(mother.getChildCount());
		println(father.getChildCount());
	}

}
