import java.util.*;

public class IteratorTest {

    public static void main(String[] args) {
        Person iver = new Person("Iver", 'm');
        Person lars = new Person("Lars", 'm');
        Person alex = new Person("Alex", 'm');
        Person marius = new Person("Marius", 'm');
        Person kristoffer = new Person("Kristoffer", 'm');
        
        List<Person> persons = new ArrayList<Person>();
        
        persons.add(iver);
        persons.add(lars);
        persons.add(alex);
        persons.add(marius);
        persons.add(kristoffer);

        Iterator tits = persons.iterator();

        while(tits.hasNext()) {
            Person derp = (Person) tits.next();
            System.out.println(derp.getName());
        }

        for (Person p: persons) {
            System.out.println(p.getName());
        }
    }
}

