package oving3;

import acm.program.ConsoleProgram;

public class Kongefamilien extends ConsoleProgram{

	public void init() {
		
	}
	
	public void run() {
		createRoyalFamily();
	}
	
	public void createRoyalFamily() {
		Person harald = new Person("Harald");
		Person sonja = new Person("Sonja");
		Person haakon = new Person("Haakon",sonja, harald);
		Person mette = new Person("Mette-Marit");
		Person ingrid = new Person("Ingrid Aleksandra", mette, haakon);
		Person sigurd = new Person("Sigurd Magnus", mette, haakon);
		Person martha = new Person("Martha", sonja, harald);
		Person ari = new Person("Ari");
		Person maud = new Person("Maud Angelica", martha, ari);
		Person leah = new Person("Leah Isadora", martha, ari);
		Person emma = new Person("Emma Taluah", martha, ari);
		println(harald);
		println(sonja);
		println(haakon);
		println(mette);
		println(ingrid);
		println(sigurd);
		println(martha);
		println(ari);
		println(maud);
		println(leah);
		println(emma);
	}
}
