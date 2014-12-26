package T3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by kradalby on 11/01/14.
 */
public class Person {

    private final PropertyChangeSupport pcs;
    private String name;
    private String dateOfBirth;
    private Gender gender;
    private String email;
    private Integer height;


    public Person(String name) {
        this.name = name;
        this.pcs = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }


    public String getName() {
        return name;
    }

    public void setName(String name){
        String oldName = this.name;
        this.name = name;
        pcs.firePropertyChange("name", oldName, name);
        System.out.println("Changed " + oldName + " to " + this.name);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        String oldDate = this.dateOfBirth;
        this.dateOfBirth = dateOfBirth;
        pcs.firePropertyChange("dateOfBirth", oldDate, dateOfBirth);
        System.out.println("Changed " + oldDate + " to " + this.dateOfBirth);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        pcs.firePropertyChange("email", oldEmail, email);
        System.out.println("Changed " + oldEmail + " to " + this.email);
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        Integer oldHeight = this.height;
        this.height = height;
        pcs.firePropertyChange("height", oldHeight, height);
        System.out.println("Changed " + oldHeight + " to " + this.height);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        Gender oldGender = this.gender;
        this.gender = gender;
        pcs.firePropertyChange("gender", oldGender, gender);
        System.out.println("Changed " + oldGender + " to " + this.gender);
    }

}
