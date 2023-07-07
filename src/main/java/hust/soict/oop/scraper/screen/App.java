package hust.soict.oop.scraper.screen;

import static hust.soict.oop.scraper.screen.Paths.EVENTS_JSON_PATH;
import hust.soict.oop.scraper.store.Store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.oop.scraper.event.Event;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
	private static final String VIEW_APP_PATH = "ViewApp.fxml";    

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
