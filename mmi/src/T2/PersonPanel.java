package T2;

import com.sun.java.swing.plaf.windows.WindowsGraphicsUtils;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by kradalby on 21/01/14.
 */
public class PersonPanel extends JPanel implements PropertyChangeListener{


    Person model;

    JLabel nameLabel;
    JLabel emailLabel;
    JLabel birthdayLabel;
    JLabel genderLabel;
    JLabel heightLabel;

    JTextField NamePropertyComponent;
    JTextField EmailPropertyComponent;
    JTextField DateOfBirthPropertyComponent;
    JComboBox<Gender> GenderPropertyComponent;
    JSlider HeightPropertyComponent;

    public PersonPanel() {

        this.nameLabel = new JLabel("Name:");
        this.emailLabel = new JLabel("Email:");
        this.birthdayLabel = new JLabel("Birthday:");
        this.genderLabel = new JLabel("Gender:");
        this.heightLabel = new JLabel("Height:");

        this.NamePropertyComponent = new JTextField();
        this.EmailPropertyComponent = new JTextField();
        this.DateOfBirthPropertyComponent = new JTextField();
        this.GenderPropertyComponent = new JComboBox<Gender>();
        this.HeightPropertyComponent = new JSlider(0, 120, 220, 170);
        HeightPropertyComponent.setPaintTicks(true);
        HeightPropertyComponent.setPaintLabels(true);
        HeightPropertyComponent.setPaintTrack(true);

        add(nameLabel);
        add(emailLabel);
        add(birthdayLabel);
        add(genderLabel);
        add(heightLabel);

        add(NamePropertyComponent);
        add(EmailPropertyComponent);
        add(DateOfBirthPropertyComponent);
        add(GenderPropertyComponent);
        add(HeightPropertyComponent);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new PersonPanel();

        GridLayout grid = new GridLayout(5,2);
        Container cont = frame.getContentPane();
        cont.setLayout(grid);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400, 200);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }


    public void setModel(Person model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }
}
