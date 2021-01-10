package assignment3;

import java.util.Locale;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class HomePage extends Application{
    @Override
    public void start(Stage primaryStage){
    
        Text tx1= new Text("User Name:"); 
        tx1.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        TextField txf1 = new TextField();
        
        Text tx2= new Text("Password:");
        tx2.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        PasswordField psf1 = new PasswordField();
        
        Button btt1 = new Button("Sign in");
        btt1.setPrefSize(200,35);
        btt1.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        
        ImageView iv1 = new ImageView(new Image("https://picsum.photos/200"));
            
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(15));
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);
        pane.setHgap(10);
        pane.add(tx1, 0, 0);
        pane.add(tx2, 0, 1);
        pane.add(txf1, 1, 0);
        pane.add(psf1, 1, 1);
        
        VBox signin = new VBox();
        signin.setAlignment(Pos.CENTER);
        signin.setPadding(new Insets(20));
        signin.setSpacing(25);
        signin.getChildren().addAll(pane,iv1,btt1);
        signin.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,null,null)));
        
        Scene Signin = new Scene(signin,400,450);
        
        VBox signup = new VBox();
        signup.setPadding(new Insets(20,20,20,30));
        signup.setSpacing(20);
        signup.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,null,null)));
    
        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(30);
        
        VBox errorbox = new VBox();
        errorbox.setSpacing(5);
        
        Text txt1 = new Text("Name:");
        Text txt2 = new Text("Email:");
        Text txt3 = new Text("Phone:");
        Text txt4 = new Text("Password:");
        Text txt5 = new Text("Confirm:");
        Text txt6 = new Text("Country:");
        Text txt7 = new Text("Gender:");
        Text txt8 = new Text("Language:");
        Text txt9 = new Text("About You:");
        
        TextField txtf1 = new TextField();
        txtf1.setPrefColumnCount(25);
        TextField txtf2 = new TextField();
        txtf2.setPrefColumnCount(25);
        TextField txtf3 = new TextField();
        txtf3.setPrefColumnCount(25);
        
        PasswordField pasf1 = new PasswordField();
        pasf1.setPrefColumnCount(25);
        PasswordField pasf2 = new PasswordField();
        pasf2.setPrefColumnCount(25);
        
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

        HBox hbb1 = new HBox();
        hbb1.getChildren().addAll(rb1,rb2);
        hbb1.setSpacing(15);
        
        CheckBox chb1 = new CheckBox("Arabic");
        CheckBox chb2 = new CheckBox("English");
        CheckBox chb3 = new CheckBox("Spanish");
        
        HBox hbb2 = new HBox();
        hbb2.getChildren().addAll(chb1,chb2,chb3);
        hbb2.setSpacing(15);
        
        TextArea ta1 = new TextArea();
        ta1.setPrefColumnCount(20);
        ta1.setPrefRowCount(4);
        
        Button Register = new Button("Register");
        Register.setPrefWidth(385);

        grid.add(txt1, 0, 0);
        grid.add(txt2,0,1);
        grid.add(txt3,0,2);
        grid.add(txt4,0,3);
        grid.add(txt5,0,4);
        grid.add(txt6,0,5);
        grid.add(txt7,0,6);
        grid.add(txt8,0,7);
        grid.add(txt9,0,8);
        
        grid.add(txtf1,1,0);
        grid.add(txtf2,1,1);
        grid.add(txtf3,1,2);
        grid.add(pasf1,1,3);
        grid.add(pasf2,1,4);
        grid.add(cb1,1,5);
        grid.add(hbb1,1,6);
        grid.add(hbb2,1,7);
        grid.add(ta1,1,8);
        
        signup.getChildren().addAll(grid,Register,errorbox);
       
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

        
        Register.setOnAction(e->{
        if(!isAlpha(txtf1.getText()))
            errorbox.getChildren().add(er1);
       else errorbox.getChildren().remove(er1);
        
        if(!isValid(txtf2.getText()))
            errorbox.getChildren().add(er2);
       else errorbox.getChildren().remove(er2);
        
        if(!isPhone2(txtf3.getText()))
            errorbox.getChildren().add(er3);
       else errorbox.getChildren().remove(er3);
        
        if(!isPhone1(txtf3.getText()))
            errorbox.getChildren().add(er4);
       else errorbox.getChildren().remove(er4);
        
        if(!isPassword(pasf1.getText())||isAlpha(pasf1.getText())||!containUpperCase(pasf1.getText())||!containLowerCase(pasf1.getText()))
            errorbox.getChildren().add(er5);
       else errorbox.getChildren().remove(er5);
        
        if(pasf2.getText().compareTo(pasf1.getText())!=0)
            errorbox.getChildren().add(er6);
       else errorbox.getChildren().remove(er6);
        
        if(cb1.getSelectionModel().isEmpty())
            errorbox.getChildren().add(er7);
       else errorbox.getChildren().remove(er7);
        
        if(ta1.getText().length()<50)
            errorbox.getChildren().add(er8);
       else errorbox.getChildren().remove(er8);
        
        if(errorbox.getChildren().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setTitle("Successfully Registered");
	    alert.setHeaderText(null);
            alert.setContentText("Successfully Registered");
            alert.showAndWait();
            }
        });   
         
       txtf1.setOnKeyReleased(e->{
        if(!isAlpha(txtf1.getText()))
            errorbox.getChildren().add(er1);
       else errorbox.getChildren().remove(er1);
       });
       
       txtf2.setOnKeyReleased(e->{
        if(!isValid(txtf2.getText()))
            errorbox.getChildren().add(er2);
       else errorbox.getChildren().remove(er2);
       });
       
       txtf3.setOnKeyReleased(e->{
        if(!isPhone2(txtf3.getText()))
            errorbox.getChildren().add(er3);
       else errorbox.getChildren().remove(er3);
       });
       
       txtf3.setOnKeyReleased(e->{
        if(!isPhone1(txtf3.getText()))
            errorbox.getChildren().add(er4);
       else errorbox.getChildren().remove(er4);
       });
       
       pasf1.setOnKeyReleased(e->{
        if(!isPassword(pasf1.getText())||isAlpha(pasf1.getText())||!containUpperCase(pasf1.getText())||!containLowerCase(pasf1.getText()))
            errorbox.getChildren().add(er5);
       else errorbox.getChildren().remove(er5);
       });
       
       pasf2.setOnKeyReleased(e->{
        if(pasf2.getText().compareTo(pasf1.getText())!=0)
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
        
        Scene Signup = new Scene(signup, 450, 700);
        
        GridPane root = new GridPane();
        root.setPadding(new Insets(50));
        root.setHgap(30);
        root.setVgap(30);
        root.setAlignment(Pos.CENTER);
        
        Image[] image = new Image[10];
        image[0] = new Image("file:///C:\\Users\\user\\Desktop\\Hiba Fall 2020\\Advanced Java Lab\\slide0.jpg");
        image[1] = new Image("file:///C:\\Users\\user\\Desktop\\Hiba Fall 2020\\Advanced Java Lab\\slide1.jpg");
        image[2] = new Image("file:///C:\\Users\\user\\Desktop\\Hiba Fall 2020\\Advanced Java Lab\\slide2.jpg");
        image[3] = new Image("file:///C:\\Users\\user\\Desktop\\Hiba Fall 2020\\Advanced Java Lab\\slide3.jpg");
        image[4] = new Image("file:///C:\\Users\\user\\Desktop\\Hiba Fall 2020\\Advanced Java Lab\\slide4.jpg");
        image[5] = new Image("file:///C:\\Users\\user\\Desktop\\Hiba Fall 2020\\Advanced Java Lab\\slide5.jpg");
        image[6] = new Image("file:///C:\\Users\\user\\Desktop\\Hiba Fall 2020\\Advanced Java Lab\\slide6.jpg");
        image[7] = new Image("file:///C:\\Users\\user\\Desktop\\Hiba Fall 2020\\Advanced Java Lab\\slide7.jpg");
        image[8] = new Image("file:///C:\\Users\\user\\Desktop\\Hiba Fall 2020\\Advanced Java Lab\\slide8.jpg");
        image[9] = new Image("file:///C:\\Users\\user\\Desktop\\Hiba Fall 2020\\Advanced Java Lab\\slide9.jpg");
       
        BackgroundImage bi0 = new BackgroundImage(image[0],BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        BackgroundImage bi1 = new BackgroundImage(image[1],BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        BackgroundImage bi2 = new BackgroundImage(image[2],BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        BackgroundImage bi3 = new BackgroundImage(image[3],BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        BackgroundImage bi4 = new BackgroundImage(image[4],BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        BackgroundImage bi5 = new BackgroundImage(image[5],BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        BackgroundImage bi6 = new BackgroundImage(image[6],BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        BackgroundImage bi7 = new BackgroundImage(image[7],BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        BackgroundImage bi8 = new BackgroundImage(image[8],BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        BackgroundImage bi9 = new BackgroundImage(image[9],BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        
        Background[] bg = new Background[10];
        bg[0] = new Background(bi0);
        bg[1] = new Background(bi1);
        bg[2] = new Background(bi2);
        bg[3] = new Background(bi3);
        bg[4] = new Background(bi4);
        bg[5] = new Background(bi5);
        bg[6] = new Background(bi6);
        bg[7] = new Background(bi7);
        bg[8] = new Background(bi8);
        bg[9] = new Background(bi9);
        
        root.setBackground(bg[0]);
        
        EventHandler<ActionEvent> myHandler = e -> {
          if(root.getBackground()== bg[0])
          root.setBackground(bg[1]);
    else  if(root.getBackground()== bg[1])
          root.setBackground(bg[2]);
    else  if(root.getBackground()== bg[2])
          root.setBackground(bg[3]);
    else  if(root.getBackground()== bg[3])
          root.setBackground(bg[4]);
    else  if(root.getBackground()== bg[4])
          root.setBackground(bg[5]);
    else  if(root.getBackground()== bg[5])
          root.setBackground(bg[6]);
    else  if(root.getBackground()== bg[6])
          root.setBackground(bg[7]);
    else  if(root.getBackground()== bg[7])
          root.setBackground(bg[8]);
    else  if(root.getBackground()== bg[8])
          root.setBackground(bg[9]);
    else  if(root.getBackground()== bg[9])
          root.setBackground(bg[0]);
          
        };
 
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1500), myHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        
        Button button1 = new Button("Sign in");
        button1.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        button1.setStyle("-fx-border-color:white");
        button1.setOnAction(e->{primaryStage.setScene(Signin);
                                primaryStage.setTitle("Signin page");
                                primaryStage.show();});
        
        Button button2 = new Button("Sign up");
        button2.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        button2.setStyle("-fx-border-color:white");
        button2.setOnAction(e->{primaryStage.setScene(Signup);
                                primaryStage.setTitle("Signup page");
                                primaryStage.show();});
        Scene Home = new Scene(root, 800, 600);
        
        Button button3 = new Button("go to signin page");
        button3.setOnAction(e->{primaryStage.setScene(Signin);
                                primaryStage.setTitle("Signin page");
                                primaryStage.show();});
        
        Button button4 = new Button("go to home page");
        button4.setOnAction(e->{primaryStage.setScene(Home);
                                primaryStage.setTitle("Home Page");
                                primaryStage.show();});
        
        Button button5 = new Button("go to signup page");
        button5.setOnAction(e->{primaryStage.setScene(Signup);
                                primaryStage.setTitle("Signup page");
                                primaryStage.show();});
        
        Button button6 = new Button("go to home page");
        button6.setOnAction(e->{primaryStage.setScene(Home);
                                primaryStage.setTitle("Home Page");
                                primaryStage.show();});
        
        HBox back1 = new HBox();
        back1.setSpacing(166);
        back1.getChildren().addAll(button3,button4);
        signup.getChildren().add(back1);
        
        HBox back2 = new HBox();
        back2.setSpacing(130);
        back2.getChildren().addAll(button5,button6);
        signin.getChildren().add(back2);
        

        root.add(button1, 0, 0);
        root.add(button2, 0, 1);
      
        primaryStage.setTitle("Home Page");
        primaryStage.setScene(Home);
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

