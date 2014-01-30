package T3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

/**
 * Created by kradalby on 25/01/14.
 */
public class PassivPersonPanel extends PersonPanel {

    protected JTextField genderTextField, heightTextField;

    public PassivPersonPanel() {
        super();

        genderTextField = new JTextField();

        heightTextField = new JTextField();

        remove(genderLabel);
        remove(heightLabel);

        remove(genderField);
        remove(heightField);

        add(genderLabel);
        add(genderTextField);

        add(heightLabel);
        add(heightTextField);



        initLayout();

        setEditable(false);


    }

    public void setEditable(boolean e) {
        super.nameField.setEditable(e);
        super.dateOfBirthField.setEditable(e);
        super.emailField.setEditable(e);
        genderTextField.setEditable(e);
        heightTextField.setEditable(e);
    }

    @Override
    public void initLayout() {
        GridLayout grid = new GridLayout(5,2);
        setLayout(grid);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName() == "name") {
            nameField.setText(model.getName());
        } else if (evt.getPropertyName() == "dateOfBirth") {
            dateOfBirthField.setText(model.getDateOfBirth());
        } else if (evt.getPropertyName() == "email") {
            emailField.setText(model.getEmail());
        } else if (evt.getPropertyName() == "gender") {
            genderTextField.setText(model.getGender().toString());
        } else if (evt.getPropertyName() == "height") {
            heightTextField.setText(model.getHeight().toString());
        }
    }

    @Override
    public void setModel(Person p) {
        model = p;
        model.addPropertyChangeListener(this);
        nameField.setText(model.getName());
        emailField.setText(model.getEmail());
        dateOfBirthField.setText(model.getDateOfBirth());
        if (model.getGender() != null) {
            genderTextField.setText(model.getGender().toString());
        }
        heightTextField.setText(model.getHeight().toString());
    }

}
