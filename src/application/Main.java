package application;
 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

 
public class Main extends Application {
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        
        System.setProperty("prism.lcdtext", "false"); // ��Ʈ���� �ε����� ����
        Font.loadFont(getClass().getResourceAsStream("font.ttf"), 10);
        
        Image icon = new Image(getClass().getResourceAsStream("app.png"));
        primaryStage.getIcons().add(icon);

        primaryStage.setResizable(false);
        primaryStage.setTitle("��ž�� ���ؼ�");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}