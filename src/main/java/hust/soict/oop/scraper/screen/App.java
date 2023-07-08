package hust.soict.oop.scraper.screen;

import static hust.soict.oop.scraper.paths.Paths.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
	
    private double x, y;


    @Override
    public void start(Stage primaryStage) throws Exception {
    	
        ControllerApp controller = new ControllerApp(); // Create an instance of Controller

        FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_APP_PATH));
        loader.setController(controller); // Set the controller instance

        Parent root = loader.load();

        primaryStage.setScene(new Scene(root));
        // Set stage borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);

        // Drag the window
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
