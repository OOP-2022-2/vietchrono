package hust.soict.oop.scraper.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.*;

import hust.soict.oop.scraper.event.Event;

public class ControllerApp {
    private static final String EVENTS_JSON_PATH = "src/main/java/hust/soict/oop/scraper/event/data/events.json";
	private static final String VIEW_OVERVIEW_HEADER_PATH = "ViewOverviewHeader.fxml";
	private static final String VIEW_EVENT_HEADER_PATH = "ViewEventHeader.fxml";    
	private static final String VIEW_EVENT_PATH = "ViewEvent.fxml";    
    
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
		setHeaderSource(VIEW_OVERVIEW_HEADER_PATH);
	}
	
	public ControllerApp() {
		// init events
		ControllerItemList<Event> eventListController = new ControllerItemList<>(EVENTS_JSON_PATH, Event[].class);
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
			setHeaderSource(VIEW_OVERVIEW_HEADER_PATH);
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
			setHeaderSource(VIEW_EVENT_HEADER_PATH);
			
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
		ControllerEvent controller = new ControllerEvent(event); // Create an instance of Controller

        FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_EVENT_PATH));
        loader.setController(controller); // Set the controller instance
	    HBox eventItem = loader.load();
	    controller.setEventDetails();
	    return eventItem;
	}
}
