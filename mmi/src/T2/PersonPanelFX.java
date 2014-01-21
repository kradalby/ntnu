package T2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by kradalby on 11/01/14.
 */
public class PersonPanelFX extends Application {

    private Person model = null;

    private GridPane grid;
    private Label nameLabel;
    private Label emailLabel;
    private Label dateOfBirthLabel;
    private Label genderLabel;
    private Label heightLabel;


    private TextField nameField;
    private TextField emailField;
    private TextField dateOfBirthField;


    private ComboBox genderBox;

    private Slider heightSlider;

    ObservableList<Gender> options = FXCollections.observableArrayList(
            Gender.MAN,
            Gender.WOMAN
    );

    public PersonPanelFX() {
        this.grid = new GridPane();
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setHgap(10);
        this.grid.setVgap(10);
        this.grid.setPadding(new Insets(25,25,25,25));

        this.nameLabel = new Label("Name:");
        this.emailLabel = new Label("Email:");
        this.dateOfBirthLabel = new Label("Birthday:");
        this.genderLabel = new Label("Gender:");
        this.heightLabel = new Label("Height");


        this.nameField = new TextField();
        this.emailField = new TextField();
        this.dateOfBirthField = new TextField();



        this.genderBox = new ComboBox(options);

        this.heightSlider = new Slider();
        this.heightSlider.setMin(50);
        this.heightSlider.setMax(230);
        this.heightSlider.setValue(140);
        this.heightSlider.setMajorTickUnit(140);
        this.heightSlider.setShowTickLabels(true);
        this.heightSlider.setShowTickMarks(true);

        this.grid.add(nameLabel, 0, 1);
        this.grid.add(nameField, 1, 1);
        this.grid.add(emailLabel, 0, 2);
        this.grid.add(emailField, 1, 2);
        this.grid.add(dateOfBirthLabel, 0, 3);
        this.grid.add(dateOfBirthField, 1, 3);
        this.grid.add(genderLabel, 0, 4);
        this.grid.add(genderBox, 1, 4);
        this.grid.add(heightLabel, 0, 5);
        this.grid.add(heightSlider, 1, 5);


    }


    public void setModel(Person person) {
        this.model = person;
        this.nameField.setText(this.model.getName());
        this.dateOfBirthField.setText(this.model.getDateOfBirth());
        this.genderBox.setValue(this.model.getGender());
        this.emailField.setText(this.model.getEmail());
        this.heightSlider.setValue(this.model.getHeight());
    }

    public Person getModel() {
        return this.model;
    }



    public void start(Stage primaryStage) {
        primaryStage.setTitle("herp");

        PersonPanelFX pp = new PersonPanelFX();
        Scene scene = new Scene(pp.grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String args[]) {
        launch(args);

    }
}
