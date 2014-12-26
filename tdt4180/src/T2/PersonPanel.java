package T2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kradalby on 21/01/14.
 */
public class PersonPanel extends JPanel{


    private Person model;

    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel birthdayLabel;
    private JLabel genderLabel;
    private JLabel heightLabel;

    private JTextField nameField;
    private JTextField emailField;
    private JTextField dateOfBirthField;
    private JComboBox<Gender> genderField;
    private JSlider heightField;

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

        TextFieldChanged tfcl = new TextFieldChanged();

        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        birthdayLabel = new JLabel("Birthday:");
        genderLabel = new JLabel("Gender:");
        heightLabel = new JLabel("Height:");

        nameField = new JTextField();
        nameField.addActionListener(tfcl);

        emailField = new JTextField();
        emailField.addActionListener(tfcl);

        dateOfBirthField = new JTextField();
        dateOfBirthField.addActionListener(tfcl);

        genderField = new JComboBox<Gender>();
        genderField.addItem(Gender.male);
        genderField.addItem(Gender.female);
        genderField.addActionListener(tfcl);

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

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new PersonPanel();

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400, 200);
    }




    private class SliderChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            if(model!=null){
                model.setHeight(heightField.getValue());
            }
        }
    }


    private class TextFieldChanged implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(model!=null){
                model.setName(nameField.getText());
                model.setDateOfBirth(dateOfBirthField.getText());
                model.setEmail(emailField.getText());
                model.setGender((Gender) genderField.getSelectedItem());
            }
        }
    }


    public void setModel(Person model) {
        this.model = model;
        nameField.setText(this.model.getName());
        emailField.setText(this.model.getEmail());
        dateOfBirthField.setText(this.model.getDateOfBirth());
        genderField.setSelectedItem(this.model.getGender());
        heightField.setValue(this.model.getHeight());

    }

    public Person getModel() {
        return this.model;
    }


}
