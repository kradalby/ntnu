package T1;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.lang.Override;

public class ButtonsNText extends Application {



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ButtonsNText");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Label inputLabel = new Label("Input:");
        grid.add(inputLabel, 0, 0);

        final TextField inputField = new TextField();
        grid.add(inputField, 1, 0);

        final ToggleGroup group = new ToggleGroup();
        final ToggleButton btnUpper = new ToggleButton();
        final ToggleButton btnLower = new ToggleButton();

        Label contLabel = new Label("Continuous?");
        final CheckBox cont = new CheckBox();

        btnUpper.setToggleGroup(group);
        btnLower.setToggleGroup(group);
        btnUpper.setText("Upper case");
        btnLower.setText("Lower case");


        EventHandler eh = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (event.getSource() instanceof ToggleButton) {
                    ToggleButton btn = (ToggleButton) event.getSource();
                    System.out.println(btn.getText());
                    if (btn == btnUpper) {
                        System.out.println("Upper pressed");
                        btn.setSelected(true);
                        inputField.setText(inputField.getText().toUpperCase());

                    } else if (btn == btnLower) {
                        System.out.println("Lower pressed");
                        btn.setSelected(true);
                        inputField.setText(inputField.getText().toLowerCase());

                    }
                } else if (event.getSource() instanceof TextField) {
                    if (btnUpper.isSelected()) {
                        inputField.setText(inputField.getText().toUpperCase());
                    } else if (btnLower.isSelected()) {
                        inputField.setText(inputField.getText().toLowerCase());
                    }
                }
            }
        };

        btnUpper.setOnAction(eh);
        btnLower.setOnAction(eh);
        inputField.setOnAction(eh);
        inputField.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (cont.isSelected()) {
                    if (btnUpper.isSelected()) {
                        inputField.setText(inputField.getText().toUpperCase());
                    } else if (btnLower.isSelected()) {
                        inputField.setText(inputField.getText().toLowerCase());
                    }
                }
            }
        });

        grid.add(btnUpper, 0, 1);
        grid.add(btnLower, 1, 1);

        grid.add(cont, 0, 2);
        grid.add(contLabel, 1, 2);


        Scene scene = new Scene(grid, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}