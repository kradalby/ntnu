package oving3;

import java.util.ArrayList;

public class Person {
	String name;
	Person mother;
	Person father;
	ArrayList<Person> children;

	public Person(String name, Person mother, Person father) {
		this.name = name;
		this.mother = mother;
		this.father = father;
		children = new ArrayList<Person>();
		mother.children.add(this);
		father.children.add(this);
	}
	
	public Person(String name) {
		this.name = name;		
		children = new ArrayList<Person>();
	}
	
	public Person() {
		children = new ArrayList<Person>();	
	}

	public boolean isMotherOf(Person meh) {
		if (meh.mother == this && this.children.contains(meh)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFatherOf(Person meh) {
		if (meh.father == this && this.children.contains(meh)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSiblingOf(Person meh) {
		if (meh.father == this.father && meh.mother == this.mother && meh != this) {
			return true;
		} else {
			return false;
		}		
	}
	
	public String toString() {
		if (this.mother == null && this.father == null) {
			String out = "Navn: " + this.name + " Barn: ";
			for (int x = 0; x < this.children.size(); x++) {
				out += " " + this.children.get(x).name;
			}
			return out;
		} else if (this.children.isEmpty()) {
			return "Navn: " + this.name + " Mor: " + this.mother.name + " Far: " + this.father.name;
		} else {
			String out = "Navn: " + this.name + " Mor: " + this.mother.name + " Far: " + this.father.name + " Barn: ";
			for (int x = 0; x < this.children.size(); x++) {
				out += " " + this.children.get(x).name;
			}
			return out;
		}
		
	}
}

