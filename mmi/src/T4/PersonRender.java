package T4;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kradalby on 31/01/14.
 */
public class PersonRender extends DefaultListCellRenderer implements ListCellRenderer<Object> {

    ImageIcon male = new ImageIcon(getClass().getResource("male.png"));
    ImageIcon female = new ImageIcon(getClass().getResource("female.png"));

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        Person person = (Person) value;

        String labelText = "";
        if (person.getName() == null) {
            labelText = "Missingno.";
        } else {
            labelText = person.getName();
        }

        label.setText(labelText);

        if (person.getGender() != null) {
            if (person.getGender() == Gender.male) {
                Image image = male.getImage();
                image = image.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(image));
            } else if (person.getGender() == Gender.female) {
                Image image = female.getImage();
                image = image.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(image));
            }
        }


        return label;
    }

}
