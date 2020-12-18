package assignment2;

import java.util.Locale;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RegistrationForm extends Application{
    @Override
    public void start(Stage primaryStage){
        
        VBox root = new VBox();
        root.setPadding(new Insets(20,20,20,30));
        root.setSpacing(20);
    
        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(30);
        
        Text t1 = new Text("Name:");
        Text t2 = new Text("Email:");
        Text t3 = new Text("Phone:");
        Text t4 = new Text("Password:");
        Text t5 = new Text("Confirm:");
        Text t6 = new Text("Country:");
        Text t7 = new Text("Gender:");
        Text t8 = new Text("Language:");
        Text t9 = new Text("About You:");
        
        TextField tf1 = new TextField();
        tf1.setPrefColumnCount(25);
        TextField tf2 = new TextField();
        tf2.setPrefColumnCount(25);
        TextField tf3 = new TextField();
        tf3.setPrefColumnCount(25);
        
        PasswordField pf1 = new PasswordField();
        pf1.setPrefColumnCount(25);
        PasswordField pf2 = new PasswordField();
        pf2.setPrefColumnCount(25);
        
        ComboBox<String> cb1 = new ComboBox<>();
        String[] locales = Locale.getISOCountries();
        for (String countrylist : locales) {
           cb1.setItems(FXCollections.observableArrayList(locales));
        }
        cb1.getSelectionModel().select("select...");
        
        RadioButton rb1 = new RadioButton("Male");
        RadioButton rb2 = new RadioButton("Female");

        final ToggleGroup group1 = new ToggleGroup();
	rb1.setToggleGroup(group1);
	rb2.setToggleGroup(group1);

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(rb1,rb2);
        hb1.setSpacing(15);
        
        CheckBox chb1 = new CheckBox("Arabic");
        CheckBox chb2 = new CheckBox("English");
        CheckBox chb3 = new CheckBox("Spanish");
        
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(chb1,chb2,chb3);
        hb2.setSpacing(15);
        
        TextArea ta1 = new TextArea();
        ta1.setPrefColumnCount(20);
        ta1.setPrefRowCount(4);
        
        Button bt1 = new Button("Register");
        bt1.setPrefWidth(385);

        grid.add(t1, 0, 0);
        grid.add(t2,0,1);
        grid.add(t3,0,2);
        grid.add(t4,0,3);
        grid.add(t5,0,4);
        grid.add(t6,0,5);
        grid.add(t7,0,6);
        grid.add(t8,0,7);
        grid.add(t9,0,8);
        
        grid.add(tf1,1,0);
        grid.add(tf2,1,1);
        grid.add(tf3,1,2);
        grid.add(pf1,1,3);
        grid.add(pf2,1,4);
        grid.add(cb1,1,5);
        grid.add(hb1,1,6);
        grid.add(hb2,1,7);
        grid.add(ta1,1,8);
        
        root.getChildren().addAll(grid,bt1);
        
        Scene scene = new Scene(root, 450, 600);
      
        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
     public static void main(String[] args) {
        launch(args);
    }   
}

