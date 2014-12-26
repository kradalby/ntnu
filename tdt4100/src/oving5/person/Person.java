package oving5.person;

import java.util.ArrayList;

public class Person {
	String name;
	char gender;
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
	
	public Person(char gender) {
		if (gender != 'f' || gender != 'm') {
				this.gender = gender;
		}
		children = new ArrayList<Person>();
	}
	
	public Person() {
		children = new ArrayList<Person>();	
	}
		
	
	public boolean isMale() {
		if (this.gender == 'm') {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFemale() {
		if (this.gender == 'f') {
			return true;
		} else {
			return false;
		}
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
	
	public boolean isAncestorOf(Person p) {
		boolean ancestor = false;
		
		if(this.containsChild(p)){
			ancestor = true;
		}
		
		for(int i = 0; i<this.getChildCount(); i++) {
			if(this.getChild(i).isAncestorOf(p)) {	
				ancestor = true;
			}
		}
		return ancestor;
	}
	
	public void setName(String name) {
		if (isOnlyLetters(name)) {
			this.name = name;
		} else {
			this.name = null;
		}
	}
	
	public void setMother(Person p) {
		if (p == null) {
			if (!(this.getMother() == null)) {
				this.mother.children.remove(this);
			}
			this.mother = p;

		} else if (p.isFemale()) {
			if ((!(this.mother == p)) && (!(this.mother == null))) {
				this.mother.children.remove(this);
			}
			this.mother = p;
			if (!p.children.contains(this)) {
				this.mother.children.add(this);
			}
		}
	}
	
	public void setFather(Person p) {
		if (p == null) {
			if (!(this.getFather() == null)) {
				this.father.children.remove(this);
			}
			this.father = p;

		} else if (p.isMale()) {
			if ((!(this.father == p)) && (!(this.father == null))) {
				this.father.children.remove(this);
			}
			this.father = p;
			if (!p.children.contains(this)) {
				this.father.children.add(this);
			}
		}
	}
	
	public void addChild(Person child) {
		if (!this.containsChild(child)) {
			this.children.add(child);
			if (this.isFemale()) {
				if (child.getMother() != null && child.getMother() != this) {
					child.getMother().removeChild(child);
				}
				child.mother = this;
			} else if (this.isMale()) {
				if (child.getFather() != null && child.getFather() != this) {
					child.getFather().removeChild(child);
				}
				child.father = this;
			}
		}
	}
	
	public void removeChild(Person child) {
		if (this.children.contains(child)) {
			this.children.remove(child);
			if (this.isMale()) {
				child.father = null;
			} else if (this.isFemale()) {
				child.mother = null;
			}
			
		}
	}
	
	public String getName() {
		return this.name;
		
	}
	
	public int getChildCount() {
		return this.children.size();
	}
	
	public Person getMother() {
		return this.mother;
	}
	
	public Person getFather() {
		return this.father;
	}
	
	public Person getChild(int index) {
		return this.children.get(index);
	}
	
	public int indexOfChild(Person child) {
		if (this.children.contains(child)) {
			return this.children.indexOf(child);
		}
		return -1;
	}
	
	public boolean containsChild(Person person) {
		if (this.children.contains(person)) {
			return true;
		}
		return false;
	}
	
	
	
	private boolean isOnlyLetters(String x) {
		for (int i = 0; i < x.length(); i++) {
			if (!Character.isLetter(x.charAt(i)) && (!(x.charAt(i) == ' '))) {
				return false;
			}
		}
		return true;
	}
}
