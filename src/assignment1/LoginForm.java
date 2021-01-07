
package assignment1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginForm extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Text t1= new Text("User Name:"); 
        t1.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        TextField tf1 = new TextField();
        
        Text t2= new Text("Password:");
        t2.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        PasswordField pf1 = new PasswordField();
        
        Button bt1 = new Button("Sign in");
        bt1.setPrefSize(200,35);
        bt1.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
        
        ImageView iv1 = new ImageView(new Image("https://picsum.photos/200"));
            
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(15));
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);
        pane.setHgap(10);
        pane.add(t1, 0, 0);
        pane.add(t2, 0, 1);
        pane.add(tf1, 1, 0);
        pane.add(pf1, 1, 1);
        
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setSpacing(25);
        root.getChildren().addAll(pane,iv1,bt1);

        Scene scene = new Scene(root, 400, 450);
        
        primaryStage.setTitle("Login form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}

