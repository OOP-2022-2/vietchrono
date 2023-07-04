package hust.soict.oop.scraper.screen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hust.soict.oop.scraper.event.Event;

public class Controller {
	private List<Event> events = new ArrayList<>();
	
	@FXML
	private Label titleLabel;
	
	@FXML
	private HBox header;

	@FXML
	private VBox pnItems = null;
	
	@FXML
	private Button btnOverview;

	@FXML
	private Button btnKings;

	@FXML
	private Button btnFigures;

	@FXML
	private Button btnEvents;

	@FXML
	private Button btnFestivals;

	@FXML
	private Button btnAttractions;

	@FXML
	private Button btnDynasties;

	@FXML
	public void initialize() {
		setHeaderSource("OverviewHeader.fxml");
	}
	
	public Controller() {
		// init events
		ItemListController<Event> eventListController = new ItemListController<>("src/main/java/hust/soict/oop/scraper/event/data/events.json", Event[].class);
		events = eventListController.getItems();
	}
	
	public void setHeaderSource(String sourcePath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(sourcePath));
            HBox headerContent = loader.load();
            header.getChildren().setAll(headerContent);
        } catch (IOException e) {
            // Handle the exception
        }
    }

	public void handleClicks(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnDynasties) {
			String buttonText = ((Labeled) actionEvent.getSource()).getText();

			// Set the text of the label to the clicked button's text
			titleLabel.setText(buttonText);
		}
		if (actionEvent.getSource() == btnKings) {
			String buttonText = ((Labeled) actionEvent.getSource()).getText();

			// Set the text of the label to the clicked button's text
			titleLabel.setText(buttonText);
		}
		if (actionEvent.getSource() == btnOverview) {
			String buttonText = ((Labeled) actionEvent.getSource()).getText();

			// Set the text of the label to the clicked button's text
			titleLabel.setText(buttonText);
			setHeaderSource("OverviewHeader.fxml");
		}
		if (actionEvent.getSource() == btnFigures) {
			String buttonText = ((Labeled) actionEvent.getSource()).getText();

			// Set the text of the label to the clicked button's text
			titleLabel.setText(buttonText);
		}
		if (actionEvent.getSource() == btnEvents) {
			String buttonText = ((Labeled) actionEvent.getSource()).getText();

			// Set the text of the label to the clicked button's text
			titleLabel.setText(buttonText);
			
			// Set headers
			setHeaderSource("EventHeader.fxml");
			
			// Clear the VBox first
			loadEventItems();
		}
		if (actionEvent.getSource() == btnAttractions) {
			String buttonText = ((Labeled) actionEvent.getSource()).getText();

			// Set the text of the label to the clicked button's text
			titleLabel.setText(buttonText);
		}
		if (actionEvent.getSource() == btnFestivals) {
			String buttonText = ((Labeled) actionEvent.getSource()).getText();

			// Set the text of the label to the clicked button's text
			titleLabel.setText(buttonText);
		}
	}
	
	public void loadEventItems() {
	    pnItems.getChildren().clear();

	    try {
	        for (Event event : events) {
	            HBox eventItem = loadEventItem(event);
	            pnItems.getChildren().add(eventItem);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	private HBox loadEventItem(Event event) throws IOException {
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Event.fxml"));
	    HBox eventItem = fxmlLoader.load();
	    EventController eventController = fxmlLoader.getController();
	    eventController.setEventDetails(event);
	    return eventItem;
	}
}
