package assignment2;

import java.util.Locale;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.paint.Color;
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
        
        VBox errorbox = new VBox();
        errorbox.setSpacing(5);
        
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
        
        root.getChildren().addAll(grid,bt1,errorbox);
    
        Scene scene = new Scene(root, 450, 600);
        
        Text er1 = new Text("name must not have digits");
        er1.setFill(Color.RED);
        Text er2 = new Text("Invalid email");
        er2.setFill(Color.RED);
        Text er3 = new Text("Phone number must be 8 digits length");
        er3.setFill(Color.RED);
        Text er4 = new Text("Phone number must not have characters");
        er4.setFill(Color.RED);
        Text er5 = new Text("Password must contain at least one capital letter, one small leter, a digit,\n and minimum 8 characters");
        er5.setFill(Color.RED);
        Text er6 = new Text("Unconfirmed password");
        er6.setFill(Color.RED);
        Text er7 = new Text("Unselected country");
        er7.setFill(Color.RED);
        Text er8 = new Text("About you must contain at least 50 characters");
        er8.setFill(Color.RED);

        
        bt1.setOnAction(e->{
        if(!isAlpha(tf1.getText()))
            errorbox.getChildren().add(er1);
       else errorbox.getChildren().remove(er1);
        
        if(!isValid(tf2.getText()))
            errorbox.getChildren().add(er2);
       else errorbox.getChildren().remove(er2);
        
        if(!isPhone2(tf3.getText()))
            errorbox.getChildren().add(er3);
       else errorbox.getChildren().remove(er3);
        
        if(!isPhone1(tf3.getText()))
            errorbox.getChildren().add(er4);
       else errorbox.getChildren().remove(er4);
        
        if(!isPassword(pf1.getText())||isAlpha(pf1.getText())||!containUpperCase(pf1.getText())||!containLowerCase(pf1.getText()))
            errorbox.getChildren().add(er5);
       else errorbox.getChildren().remove(er5);
        
        if(pf2.getText().compareTo(pf1.getText())!=0)
            errorbox.getChildren().add(er6);
       else errorbox.getChildren().remove(er6);
        
        if(cb1.getSelectionModel().isEmpty())
            errorbox.getChildren().add(er7);
       else errorbox.getChildren().remove(er7);
        
        if(ta1.getText().length()<50)
            errorbox.getChildren().add(er8);
       else errorbox.getChildren().remove(er8);
        
        if(errorbox.getChildren().isEmpty()){
            Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Successfully Registered");
	    alert.setHeaderText(null);
            alert.setContentText("Successfully Registered");
            alert.showAndWait();
            }
        });   
         
       tf1.setOnKeyReleased(e->{
        if(!isAlpha(tf1.getText()))
            errorbox.getChildren().add(er1);
       else errorbox.getChildren().remove(er1);
       });
       
       tf2.setOnKeyReleased(e->{
        if(!isValid(tf2.getText()))
            errorbox.getChildren().add(er2);
       else errorbox.getChildren().remove(er2);
       });
       
       tf3.setOnKeyReleased(e->{
        if(!isPhone2(tf3.getText()))
            errorbox.getChildren().add(er3);
       else errorbox.getChildren().remove(er3);
       });
       
       tf3.setOnKeyReleased(e->{
        if(!isPhone1(tf3.getText()))
            errorbox.getChildren().add(er4);
       else errorbox.getChildren().remove(er4);
       });
       
       pf1.setOnKeyReleased(e->{
        if(!isPassword(pf1.getText())||isAlpha(pf1.getText())||!containUpperCase(pf1.getText())||!containLowerCase(pf1.getText()))
            errorbox.getChildren().add(er5);
       else errorbox.getChildren().remove(er5);
       });
       
       pf2.setOnKeyReleased(e->{
        if(pf2.getText().compareTo(pf1.getText())!=0)
            errorbox.getChildren().add(er6);
       else errorbox.getChildren().remove(er6);
       });
       
       cb1.setOnMouseReleased(e->{
        if(cb1.getSelectionModel().isEmpty())
            errorbox.getChildren().add(er7);
       else errorbox.getChildren().remove(er7);
       });
       
       ta1.setOnKeyReleased(e->{
        if(ta1.getText().length()<50)
            errorbox.getChildren().add(er8);
       else errorbox.getChildren().remove(er8);
       });
       
       
        
        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
     public static void main(String[] args) {
        launch(args);
    }   
     
     public boolean isAlpha(String name){
         char[] chars = name.toCharArray();
         for( char c : chars)
             if(!Character.isLetter(c))
                 return false;
                 return true;
     }
     public boolean isValid(String email){
        if (!email.contains("@")||!email.contains("."))
            return false;
       else return true;
       
        }
    public boolean isPhone1(String phone){
         char[] chars = phone.toCharArray();
         for( char c : chars)
             if(Character.isLetter(c))
                 return false;
                 return true;
     }
    public boolean isPhone2(String phone){
             if(phone.length()==8)
                 return true;
           else  return false;
     }
    public boolean isPassword(String password){
             if(password.length()>=8)
                 return true;
           else  return false;
     }
    public boolean containUpperCase(String password){
         char[] chars = password.toCharArray();
         int i = 0;
         for( char c : chars)
             if(Character.isUpperCase(c))
                i++;
         if(i==0)
             return false;
        else return true;
                
     }
    public boolean containLowerCase(String password){
         char[] chars = password.toCharArray();
         int i = 0;
         for( char c : chars)
             if(Character.isLowerCase(c))
                i++;
         if(i==0)
             return false;
        else return true;
                
     }
     }


