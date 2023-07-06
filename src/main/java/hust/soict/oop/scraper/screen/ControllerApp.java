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
import hust.soict.oop.scraper.dynasty.Dynasty;
import hust.soict.oop.scraper.figure.King;
import hust.soict.oop.scraper.figure.Figure;
import hust.soict.oop.scraper.festival.Festival;
import hust.soict.oop.scraper.location.Location;
import static hust.soict.oop.scraper.screen.Paths.*;

public class ControllerApp {

    private List<Event> events = new ArrayList<>();
    ControllerItemList<Event> eventListController = new ControllerItemList<>(EVENTS_JSON_PATH, Event[].class);
//
//    private List<Dynasty> dynasties = new ArrayList<>();
//    ControllerItemList<Dynasty> dynastyListController = new ControllerItemList<>(DYNASTIES_JSON_PATH, Dynasty[].class);
//
//    private List<King> kings = new ArrayList<>();
//    ControllerItemList<King> kingListController = new ControllerItemList<>(KINGS_JSON_PATH, King[].class);
//
//    private List<Location> attractions = new ArrayList<>();
//    ControllerItemList<Location> attractionListController = new ControllerItemList<>(ATTRACTIONS_JSON_PATH, Location[].class);
//
//    private List<Festival> festivals = new ArrayList<>();
//    ControllerItemList<Festival> festivalListController = new ControllerItemList<>(FESTIVALS_JSON_PATH, Festival[].class);
//
    private List<Figure> figures = new ArrayList<>();
    ControllerItemList<Figure> figureListController = new ControllerItemList<>(FIGURES_JSON_PATH, Figure[].class);

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
        events = eventListController.getItems();
//        dynasties = dynastyListController.getItems();
//        kings = kingListController.getItems();
//        attractions = attractionListController.getItems();
//        festivals = festivalListController.getItems();
        figures = figureListController.getItems();
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

        Map<Button, String> headerPaths = new HashMap<>();
        headerPaths.put(btnDynasties, VIEW_DYNASTY_HEADER_PATH);
        headerPaths.put(btnKings, VIEW_KING_HEADER_PATH);
        headerPaths.put(btnOverview, VIEW_OVERVIEW_HEADER_PATH);
        headerPaths.put(btnFigures, VIEW_FIGURE_HEADER_PATH);
        headerPaths.put(btnEvents, VIEW_EVENT_HEADER_PATH);
        headerPaths.put(btnAttractions, VIEW_ATTRACTION_HEADER_PATH);
        headerPaths.put(btnFestivals, VIEW_FESTIVAL_HEADER_PATH);

        if (headerPaths.containsKey(source)) {
            setHeaderSource(headerPaths.get(source));
            if (source == btnEvents) {
                loadEventItems();
            } 
//            else if (source == btnDynasties) {
//                loadDynastyItems();
//            } else if (source == btnKings) {
//                loadKingItems();
            } 
        	if (source == btnFigures) {
                loadFigureItems();
//            } else if (source == btnFestivals) {
//                loadFestivalItems();
//            } else if (source == btnAttractions) {
//                loadAttractionItems();
//            }
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
    
//    public void loadDynastyItems() {
//        pnItems.getChildren().clear();
//
//        try {
//            for (Dynasty dynasty : dynasties) {
//                HBox dynastyItem = loadDynastyItem(dynasty);
//                pnItems.getChildren().add(dynastyItem);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private HBox loadDynastyItem(Dynasty dynasty) throws IOException {
//        ControllerDynasty controller = new ControllerDynasty(dynasty); // Create an instance of Controller
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_DYNASTY_PATH));
//        loader.setController(controller); // Set the controller instance
//        HBox dynastyItem = loader.load();
//        controller.setDynastyDetails();
//        return dynastyItem;
//    }
//
//    public void loadAttractionItems() {
//        pnItems.getChildren().clear();
//
//        try {
//            for (Location attraction : attractions) {
//                HBox attractionItem = loadAttractionItem(attraction);
//                pnItems.getChildren().add(attractionItem);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private HBox loadAttractionItem(Location attraction) throws IOException {
//        ControllerAttraction controller = new ControllerAttraction(attraction); // Create an instance of Controller
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_ATTRACTION_PATH));
//        loader.setController(controller); // Set the controller instance
//        HBox attractionItem = loader.load();
//        controller.setAttractionDetails();
//        return attractionItem;
//    }
//
//    public void loadKingItems() {
//        pnItems.getChildren().clear();
//
//        try {
//            for (King king : kings) {
//                HBox kingItem = loadKingItem(king);
//                pnItems.getChildren().add(kingItem);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private HBox loadKingItem(King king) throws IOException {
//        ControllerKing controller = new ControllerKing(king); // Create an instance of Controller
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_KING_PATH));
//        loader.setController(controller); // Set the controller instance
//        HBox kingItem = loader.load();
//        controller.setKingDetails();
//        return kingItem;
//    }
//
//    public void loadFestivalItems() {
//        pnItems.getChildren().clear();
//
//        try {
//            for (Festival festival : festivals) {
//                HBox festivalItem = loadFestivalItem(festival);
//                pnItems.getChildren().add(festivalItem);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private HBox loadFestivalItem(Festival festival) throws IOException {
//        ControllerFestival controller = new ControllerFestival(festival); // Create an instance of Controller
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_FESTIVAL_PATH));
//        loader.setController(controller); // Set the controller instance
//        HBox festivalItem = loader.load();
//        controller.setFestivalDetails();
//        return festivalItem;
//    }
//
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
    	System.out.println(figure.name);
        ControllerFigure controller = new ControllerFigure(figure); // Create an instance of Controller

        FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_FIGURE_PATH));
        loader.setController(controller); // Set the controller instance
        HBox figureItem = loader.load();
        controller.setFigureDetails();
        return figureItem;
    }

}
