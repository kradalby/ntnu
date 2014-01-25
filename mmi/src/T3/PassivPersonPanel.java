package T3;

/**
 * Created by kradalby on 25/01/14.
 */
public class PassivPersonPanel extends PersonPanel {

    public PassivPersonPanel() {
        super();
        setEditable(false);
    }

    public void setEditable(boolean e) {
        super.nameField.setEditable(e);
        super.dateOfBirthField.setEditable(e);
        super.emailField.setEditable(e);
        super.genderField.setEditable(e);
        //super.heightField.setEditable(e);
    }
}
