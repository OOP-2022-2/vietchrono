package hust.soict.oop.scraper.store;

import static hust.soict.oop.scraper.paths.Paths.*;

import java.util.ArrayList;
import java.util.List;

import hust.soict.oop.scraper.dynasty.Dynasty;
import hust.soict.oop.scraper.event.Event;
import hust.soict.oop.scraper.festival.Festival;
import hust.soict.oop.scraper.figure.Figure;
import hust.soict.oop.scraper.figure.King;
import hust.soict.oop.scraper.location.Location;
import hust.soict.oop.scraper.screen.ControllerItemList;

public class Store {

    private ControllerItemList<Event> eventListController = new ControllerItemList<>(EVENTS_JSON_PATH, Event[].class);
    private ControllerItemList<King> kingListController = new ControllerItemList<>(KINGS_JSON_PATH, King[].class);
    private ControllerItemList<Figure> figureListController = new ControllerItemList<>(FIGURES_JSON_PATH, Figure[].class);
    private ControllerItemList<Dynasty> dynastyListController = new ControllerItemList<>(DYNASTIES_JSON_PATH, Dynasty[].class);
    private ControllerItemList<Location> attractionListController = new ControllerItemList<>(ATTRACTIONS_JSON_PATH, Location[].class);
    private ControllerItemList<Festival> festivalListController = new ControllerItemList<>(FESTIVALS_JSON_PATH, Festival[].class);
    
	public List<Event> getEvents() {
		return eventListController.getItems();
	}
	
	public List<Figure> getFigures() {
		return figureListController.getItems();
	}
	
	public List<King> getKings() {
		return kingListController.getItems();
	}

	public List<Festival> getFestivals() {
		return festivalListController.getItems();
	}
	
	public List<Location> getLocation() {
		return attractionListController.getItems();
	}
	
	public List<Dynasty> getDynasties() {
		return dynastyListController.getItems();
	}

}
