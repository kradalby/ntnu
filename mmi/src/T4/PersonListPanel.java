package T4;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kradalby on 29/01/14.
 */
public class PersonListPanel extends JPanel {

    private JList<Person> personList;
    private PersonPanel personPanel;

    private DefaultListModel<Person> defaultListModel;

    public PersonListPanel() {

        personList = new JList<Person>();
        personList.setName("PersonPanel");

        personPanel = new PersonPanel();

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        add(personList);
        add(personPanel);



    }




    public DefaultListModel<Person> getDefaultListModel() {
        return defaultListModel;
    }

    public void setDefaultListModel(DefaultListModel<Person> defaultListModel) {
        this.defaultListModel = defaultListModel;
    }


    public static void  main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel c = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));

        PersonListPanel pl = new PersonListPanel();



        Person person = new Person("Kristoffer Dalby");
        person.setDateOfBirth("10.08.92");
        person.setGender(Gender.male);
        person.setEmail("kradalby@kradalby.no");
        person.setHeight(150);

        pl.personPanel.setModel(person);

        c.add(pl);

        frame.setContentPane(c);
        frame.setVisible(true);
        frame.setSize(600, 400);
    }


}
