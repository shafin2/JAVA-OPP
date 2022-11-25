import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primarStage) throws Exception {

        // Stage stage =new Stage();
        Group root=new Group();
        Scene scene=new Scene(root,Color.AQUA);
        Image iconImage=new Image("pic.png");
        
        primarStage.setWidth(420);
        primarStage.setHeight(420);
        primarStage.setResizable(false);
        primarStage.getIcons().add(iconImage);
        primarStage.setTitle("Learning");
        primarStage.setScene(scene);
        primarStage.show();
    }
}