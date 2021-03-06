package exercise2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Student extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Place nodes in the pane
        pane.add(new Label("First Name:"), 0, 0);
        pane.add(new TextField(), 1, 0);
        pane.add(new Label("Address:"), 0, 1);
        pane.add(new TextField(), 1, 1);
        pane.add(new Label("Province:"), 0, 2);
        pane.add(new TextField(), 1, 2);
        pane.add(new Label("City"),0,3);
        pane.add(new TextField(),1,3);
        pane.add(new Label("Postal Code"),0,4);
        pane.add(new TextField(),1,4);
        pane.add(new Label("Phone Number"),0,5);
        pane.add(new TextField(),1,5);
        pane.add(new Label("Email"),0,6);
        pane.add(new TextField(),1,6);
        pane.add(new Label("Student Council"),7,1);
        pane.add(new Label("Volunteer Work"),7,5);
        pane.add(new Label("Computer Science"),14,0);
        pane.add(new Label("Business"),17,0);
        Button btAdd = new Button("Display");
        pane.add(btAdd, 1, 7);
        GridPane.setHalignment(btAdd, HPos.RIGHT);



        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowGridPane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }




    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}