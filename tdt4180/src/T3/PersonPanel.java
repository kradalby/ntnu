package T3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by kradalby on 21/01/14.
 */
public class PersonPanel extends JPanel implements PropertyChangeListener{


    protected Person model;

    protected JLabel nameLabel, emailLabel, birthdayLabel, genderLabel, heightLabel;

    protected JTextField nameField, emailField, dateOfBirthField;
    protected JComboBox<Gender> genderField;
    protected JSlider heightField;

    private final Dimension sliderDimension = new Dimension(320, 40);
    private static final int HEIGHTMIN = 120;
    private static final int HEIGHTMAX = 220;
    private static final int HEIGHTINIT = 170;

    public PersonPanel() {
        initGUI();
        initLayout();
        this.model = null;


    }

    public void initGUI() {

        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        birthdayLabel = new JLabel("Birthday:");
        genderLabel = new JLabel("Gender:");
        heightLabel = new JLabel("Height:");

        nameField = new JTextField();
        nameField.addActionListener(new NameFieldChanged());

        emailField = new JTextField();
        emailField.addActionListener(new EmailFieldChanged());

        dateOfBirthField = new JTextField();
        dateOfBirthField.addActionListener(new DateFieldChanged());

        genderField = new JComboBox<Gender>();
        genderField.addItem(Gender.male);
        genderField.addItem(Gender.female);
        genderField.addActionListener(new GenderFieldChanged());

        heightField = new JSlider(JSlider.HORIZONTAL, HEIGHTMIN, HEIGHTMAX, HEIGHTINIT);
        heightField.setMajorTickSpacing(10);
        heightField.setMinorTickSpacing(1);
        heightField.setPaintTicks(true);
        heightField.setPaintLabels(true);
        heightField.setPaintTrack(true);
        heightField.setPreferredSize(sliderDimension);
        heightField.addChangeListener(new SliderChangeListener());



        nameField.setName("NamePropertyComponent");
        emailField.setName("EmailPropertyComponent");
        dateOfBirthField.setName("DateOfBirthPropertyComponent");
        genderField.setName("GenderPropertyComponent");
        heightField.setName("HeightPropertyComponent");


        add(nameLabel);
        add(nameField);

        add(emailLabel);
        add(emailField);

        add(birthdayLabel);
        add(dateOfBirthField);

        add(genderLabel);
        add(genderField);

        add(heightLabel);
        add(heightField);

    }

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
            genderField.setSelectedItem(model.getGender());
        } else if (evt.getPropertyName() == "height") {
            heightField.setValue(model.getHeight());
        }
    }


    private class SliderChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            if(model!=null){
                model.setHeight(heightField.getValue());
            }
        }
    }


    private class NameFieldChanged implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(model!=null){
                model.setName(nameField.getText());
            }
        }
    }

    private class DateFieldChanged implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(model!=null){
                model.setDateOfBirth(dateOfBirthField.getText());
            }
        }
    }

    private class EmailFieldChanged implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(model!=null){
                model.setEmail(emailField.getText());
            }
        }
    }

    private class GenderFieldChanged implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(model!=null){
                model.setGender((Gender) genderField.getSelectedItem());
            }
        }
    }


    public void setModel(Person model) {
        this.model = model;
        model.addPropertyChangeListener(this);
        nameField.setText(this.model.getName());
        emailField.setText(this.model.getEmail());
        dateOfBirthField.setText(this.model.getDateOfBirth());
        genderField.setSelectedItem(this.model.getGender());
        heightField.setValue(this.model.getHeight());

    }

    public Person getModel() {
        return this.model;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel c = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        PersonPanel panel = new PersonPanel();
        PassivPersonPanel panel2 = new PassivPersonPanel();




        Person person = new Person("Kristoffer Dalby");
        person.setDateOfBirth("10.08.92");
        person.setGender(Gender.male);
        person.setEmail("kradalby@kradalby.no");
        person.setHeight(150);

        panel.setModel(person);
        panel2.setModel(person);

        c.add(panel);
        c.add(panel2);

        frame.setContentPane(c);
        frame.setVisible(true);
        frame.setSize(400, 600);
    }




}
