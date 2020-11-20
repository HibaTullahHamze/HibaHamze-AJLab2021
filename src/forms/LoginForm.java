/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;




import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author hibahamze
 */
public class LoginForm extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Text t1= new Text("User Name:"); 
        t1.setFill(Color.BLUE);
        t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        TextField tf1 = new TextField();
        
        Text t2= new Text("Password:");
        t2.setFill(Color.BLUE);
        t2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        TextField tf2 = new TextField();
        
        Button bt1 = new Button("Sign in");
        
        ImageView iv1 = new ImageView(new Image("https://picsum.photos/200"));
        
         
            VBox vb1 = new VBox(15);
            vb1.setPadding(new Insets(12,12,12,12));
            vb1.getChildren().addAll(t1,t2);
            
            VBox vb2 = new VBox(15);
            vb2.setPadding(new Insets(12,12,12,12));
            vb2.getChildren().addAll(tf1,tf2);
             
            HBox hb = new HBox(15);
            hb.setPadding(new Insets(12,12,12,12));
            hb.getChildren().addAll(vb1,vb2);
            
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(15);
        pane.setHgap(15);
        GridPane.setHalignment(iv1, HPos.CENTER);
        pane.add(hb, 0, 0);
        pane.add(iv1, 0, 1);
        pane.add(bt1, 2, 2);

      
        
        Scene scene = new Scene(pane, 500, 500);
        
        primaryStage.setTitle("HibaTullah Hamze Assignment1 Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

