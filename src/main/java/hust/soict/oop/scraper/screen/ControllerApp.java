package hust.soict.oop.scraper.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import static hust.soict.oop.scraper.paths.Paths.*;

import java.io.IOException;
import java.util.*;

import hust.soict.oop.scraper.event.Event;
import hust.soict.oop.scraper.dynasty.Dynasty;
import hust.soict.oop.scraper.figure.King;
import hust.soict.oop.scraper.linker.Linker;
import hust.soict.oop.scraper.figure.Figure;
import hust.soict.oop.scraper.festival.Festival;
import hust.soict.oop.scraper.location.Location;
import hust.soict.oop.scraper.store.Store;

public class ControllerApp {
	private Store store = new Store();

	private List<Event> events = new ArrayList<>();
	private List<Figure> figures = new ArrayList<>();
	private List<King> kings = new ArrayList<>();
	private List<Festival> festivals = new ArrayList<>();
	private List<Dynasty> dynasties = new ArrayList<>();
	private List<Location> attractions = new ArrayList<>();

	@FXML
	private Label titleLabel;

	@FXML
	private TextField searchBar;

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

	public ControllerApp() {
	}

	@FXML
	public void initialize() {
		setHeaderSource(VIEW_DYNASTY_HEADER_PATH);
		dynasties = store.getDynasties();
		loadDynastyItems();
		searchBar.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				search();
			}
		});
	}

	public void search() {
		if (titleLabel.getText().equals("Events")) {
			events = store.searchEvent(searchBar.getText());
			loadEventItems();
		} else if (titleLabel.getText().equals("Kings")) {
			kings = store.searchKing(searchBar.getText());
			loadKingItems();
		} else if (titleLabel.getText().equals("Festivals")) {
			festivals = store.searchFestival(searchBar.getText());
			loadFestivalItems();
		} else if (titleLabel.getText().equals("Figures")) {
			figures = store.searchFigure(searchBar.getText());
			loadFigureItems();
		} else if (titleLabel.getText().equals("Tourist Attractions")) {
			attractions = store.searchLocation(searchBar.getText());
			loadAttractionItems();
		} else if (titleLabel.getText().equals("Dynasties")) {
			dynasties = store.searchDynasty(searchBar.getText());
			loadDynastyItems();
		}
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

	@FXML
	public void handleClicks(ActionEvent actionEvent) {
		Object source = actionEvent.getSource();
		String buttonText = ((Labeled) source).getText();

		// Set the text of the label to the clicked button's text
		titleLabel.setText(buttonText);

		// Update the header source based on the clicked button
		Map<Button, String> headerPaths = new HashMap<>();
		headerPaths.put(btnDynasties, VIEW_DYNASTY_HEADER_PATH);
		headerPaths.put(btnKings, VIEW_KING_HEADER_PATH);
		headerPaths.put(btnOverview, VIEW_OVERVIEW_HEADER_PATH);
		headerPaths.put(btnFigures, VIEW_FIGURE_HEADER_PATH);
		headerPaths.put(btnEvents, VIEW_EVENT_HEADER_PATH);
		headerPaths.put(btnAttractions, VIEW_ATTRACTION_HEADER_PATH);
		headerPaths.put(btnFestivals, VIEW_FESTIVAL_HEADER_PATH);

		if (source == btnOverview) {

		} else if (source == btnEvents) {
			events = store.getEvents();
			loadEventItems();
		} else if (source == btnKings) {
			kings = store.getKings();
			loadKingItems();
		} else if (source == btnFigures) {
			figures = store.getFigures();
			loadFigureItems();
		} else if (source == btnFestivals) {
			festivals = store.getFestivals();
			loadFestivalItems();
		} else if (source == btnAttractions) {
			attractions = store.getLocations();
			loadAttractionItems();
		} else if (source == btnDynasties) {
			dynasties = store.getDynasties();
			loadDynastyItems();
		}

		if (headerPaths.containsKey(source)) {
			setHeaderSource(headerPaths.get(source));
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

	public void loadDynastyItems() {
		pnItems.getChildren().clear();

		try {
			for (Dynasty dynasty : dynasties) {
				HBox dynastyItem = loadItem(dynasty);
				pnItems.getChildren().add(dynastyItem);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private HBox loadItem(Dynasty dynasty) throws IOException {
		ControllerDynasty controller = new ControllerDynasty(dynasty); // Create an instance of Controller

		FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_DYNASTY_PATH));
		loader.setController(controller); // Set the controller instance
		HBox dynastyItem = loader.load();
		controller.setDynastyDetails();
		return dynastyItem;
	}

	public void loadAttractionItems() {
		pnItems.getChildren().clear();

		try {
			for (Location attraction : attractions) {
				HBox attractionItem = loadItem(attraction);
				pnItems.getChildren().add(attractionItem);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private HBox loadItem(Location attraction) throws IOException {
		ControllerAttraction controller = new ControllerAttraction(attraction); // Create an instance of Controller

		FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_ATTRACTION_PATH));
		loader.setController(controller); // Set the controller instance
		HBox attractionItem = loader.load();
		controller.setAttractionDetails();
		return attractionItem;
	}

	public void loadKingItems() {
		pnItems.getChildren().clear();

		try {
			for (King king : kings) {
				HBox kingItem = loadItem(king);
				pnItems.getChildren().add(kingItem);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private HBox loadItem(King king) throws IOException {
		ControllerKing controller = new ControllerKing(king); // Create an instance of Controller

		FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_KING_PATH));
		loader.setController(controller); // Set the controller instance
		HBox kingItem = loader.load();
		controller.setKingDetails();
		return kingItem;
	}

	public void loadFestivalItems() {
		pnItems.getChildren().clear();

		try {
			for (Festival festival : festivals) {
				HBox festivalItem = loadItem(festival);
				pnItems.getChildren().add(festivalItem);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private HBox loadItem(Festival festival) throws IOException {
		ControllerFestival controller = new ControllerFestival(festival); // Create an instance of Controller

		FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_FESTIVAL_PATH));
		loader.setController(controller); // Set the controller instance
		HBox festivalItem = loader.load();
		controller.setFestivalDetails();
		return festivalItem;
	}

	public void loadFigureItems() {
		pnItems.getChildren().clear();

		try {
			for (Figure figure : figures) {
				HBox figureItem = loadFigureItem(figure);
				pnItems.getChildren().add(figureItem);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private HBox loadFigureItem(Figure figure) throws IOException {
		ControllerFigure controller = new ControllerFigure(figure); // Create an instance of Controller

		FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_FIGURE_PATH));
		loader.setController(controller); // Set the controller instance
		HBox figureItem = loader.load();
		controller.setFigureDetails();
		return figureItem;
	}

}
