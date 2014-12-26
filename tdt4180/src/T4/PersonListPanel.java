package T4;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kradalby on 29/01/14.
 */
public class PersonListPanel extends JPanel {

    private JList<Person> personList;
    private JButton deletePersonButton, addPersonButton;
    private JScrollBar scrollBar;
    private PersonPanel personPanel;
    private ListSelectionModel listSelectionModel;

    private DefaultListModel<Person> defaultListModel;

    public PersonListPanel() {

        defaultListModel = new DefaultListModel<Person>();

        personList = new JList<Person>();
        personList.setName("PersonList");
        personList.setModel(defaultListModel);
        personList.setPreferredSize(new Dimension(130, 155));
        personList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        personList.setCellRenderer(new PersonRender());
        listSelectionModel = personList.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectListener());

        addPersonButton = new JButton();
        addPersonButton.setName("NewPersonButton");
        addPersonButton.addActionListener(new AddPersonListener());

        deletePersonButton = new JButton();
        deletePersonButton.setName("DeletePersonButton");
        deletePersonButton.addActionListener(new DeletePersonListener());



        personPanel = new PersonPanel();
        personPanel.setName("PersonPanel");

        scrollBar = new JScrollBar();
        scrollBar.setPreferredSize(new Dimension(15, 155));


        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(layout);

        c.gridx = 0;
        c.gridy = 0;
        add(personList);

        c.gridx = 0;
        c.gridy = 1;
        add(addPersonButton);
        add(deletePersonButton);

        c.gridx = 1;
        c.gridy = 0;
        add(scrollBar);

        c.gridx = 2;
        c.gridy = 0;
        add(personPanel);



    }


    public DefaultListModel<Person> getModel() {
        return defaultListModel;
    }


    public void setModel(DefaultListModel<Person> defaultListModel) {
        this.defaultListModel = defaultListModel;
        this.personList.setModel(defaultListModel);

    }

    class ListSelectListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            if (lsm.isSelectionEmpty()) {
                personPanel.setModel(null);
            } else {
                personPanel.setModel(personList.getSelectedValue());
                System.out.println(personList.getSelectedValue());
            }

        }
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



        Person bergalerga = new Person("Fredrik Berg");
        Person tcat = new Person("Truls Pettersen");

        DefaultListModel<Person> walla = new DefaultListModel<Person>();

        walla.addElement(person);
        walla.addElement(bergalerga);
        walla.addElement(tcat);

        pl.setModel(walla);

        pl.personPanel.setModel(person);

        c.add(pl);

        frame.setContentPane(c);
        frame.setVisible(true);
        //frame.setSize(600, 400);
        frame.pack();
    }


    private class AddPersonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Person p = new Person("Ny bruker");
            personPanel.setModel(p);
            defaultListModel.addElement(p);
            personList.setSelectedIndex(defaultListModel.getSize()-1);
        }
    }

    private class DeletePersonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!personList.isSelectionEmpty()) {
                personPanel.setModel(null);
                defaultListModel.remove(personList.getSelectedIndex());
            }
        }
    }
}
