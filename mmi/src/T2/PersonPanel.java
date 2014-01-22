package T2;

import com.sun.java.swing.plaf.windows.WindowsGraphicsUtils;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

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

    private JTextField NamePropertyComponent;
    private JTextField EmailPropertyComponent;
    private JTextField DateOfBirthPropertyComponent;
    private JComboBox<Gender> GenderPropertyComponent;
    private JSlider HeightPropertyComponent;

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

        NamePropertyComponent = new JTextField();
        NamePropertyComponent.addActionListener(tfcl);

        EmailPropertyComponent = new JTextField();
        EmailPropertyComponent.addActionListener(tfcl);

        DateOfBirthPropertyComponent = new JTextField();
        DateOfBirthPropertyComponent.addActionListener(tfcl);

        GenderPropertyComponent = new JComboBox<Gender>();
        GenderPropertyComponent.addItem(Gender.male);
        GenderPropertyComponent.addItem(Gender.female);
        GenderPropertyComponent.addActionListener(tfcl);

        HeightPropertyComponent = new JSlider(JSlider.HORIZONTAL, HEIGHTMIN, HEIGHTMAX, HEIGHTINIT);
        HeightPropertyComponent.setPaintTicks(true);
        HeightPropertyComponent.setPaintLabels(true);
        HeightPropertyComponent.setPaintTrack(true);
        HeightPropertyComponent.setPreferredSize(sliderDimension);
        HeightPropertyComponent.addChangeListener(new SliderChangeListener());



        NamePropertyComponent.setName("NamePropertyComponent");
        EmailPropertyComponent.setName("EmailPropertyComponent");
        DateOfBirthPropertyComponent.setName("DateOfBirthPropertyComponent");
        GenderPropertyComponent.setName("GenderPropertyComponent");
        HeightPropertyComponent.setName("HeightPropertyComponent");


        add(nameLabel);
        add(NamePropertyComponent);

        add(emailLabel);
        add(EmailPropertyComponent);

        add(birthdayLabel);
        add(DateOfBirthPropertyComponent);

        add(genderLabel);
        add(GenderPropertyComponent);

        add(heightLabel);
        add(HeightPropertyComponent);

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
            model.setHeight(HeightPropertyComponent.getValue());
        }
    }


    private class TextFieldChanged implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model.setName(NamePropertyComponent.getText());
            model.setDateOfBirth(DateOfBirthPropertyComponent.getText());
            model.setEmail(EmailPropertyComponent.getText());
            model.setGender((Gender) GenderPropertyComponent.getSelectedItem());
        }
    }


    public void setModel(Person model) {
        this.model = model;
        NamePropertyComponent.setText(this.model.getName());
        EmailPropertyComponent.setText(this.model.getEmail());
        DateOfBirthPropertyComponent.setText(this.model.getDateOfBirth());
        GenderPropertyComponent.setSelectedItem(this.model.getGender());
        HeightPropertyComponent.setValue(this.model.getHeight());

    }

    public Person getModel() {
        return this.model;
    }


}
