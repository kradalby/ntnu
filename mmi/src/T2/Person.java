package T2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by kradalby on 11/01/14.
 */
public class Person {

    private PropertyChangeSupport pcs;
    private String name;
    private String dateOfBirth;
    private Gender gender;
    private String email;
    private Integer height;


    public Person(String name, String dateOfBirth, Gender gender, String email, Integer height) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.height = height;
        pcs = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        String oldName = this.name;
        this.name = name;
        pcs.firePropertyChange("name", oldName, name);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        String oldDate = this.dateOfBirth;
        this.dateOfBirth = dateOfBirth;
        pcs.firePropertyChange("dateOfBirth", oldDate, dateOfBirth);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        pcs.firePropertyChange("email", oldEmail, email);
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        Integer oldHeight = this.height;
        this.height = height;
        pcs.firePropertyChange("height", oldHeight, height);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        Gender oldGender = this.gender;
        this.gender = gender;
        pcs.firePropertyChange("gender", oldGender, gender);
    }

}
