package hust.soict.oop.scraper.store;

import static hust.soict.oop.scraper.screen.Paths.EVENTS_JSON_PATH;
import static hust.soict.oop.scraper.screen.Paths.FIGURES_JSON_PATH;

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
    private List<Event> events = new ArrayList<>();
//    ControllerItemList<Event> eventListController = new ControllerItemList<>(EVENTS_JSON_PATH, Event[].class);
//
    private List<Dynasty> dynasties = new ArrayList<>();
//    ControllerItemList<Dynasty> dynastyListController = new ControllerItemList<>(DYNASTIES_JSON_PATH, Dynasty[].class);
//
    private List<King> kings = new ArrayList<>();
//    ControllerItemList<King> kingListController = new ControllerItemList<>(KINGS_JSON_PATH, King[].class);
//
    private List<Location> attractions = new ArrayList<>();
//    ControllerItemList<Location> attractionListController = new ControllerItemList<>(ATTRACTIONS_JSON_PATH, Location[].class);
//
    private List<Festival> festivals = new ArrayList<>();
//    ControllerItemList<Festival> festivalListController = new ControllerItemList<>(FESTIVALS_JSON_PATH, Festival[].class);
//
    private List<Figure> figures = new ArrayList<>();
//    ControllerItemList<Figure> figureListController = new ControllerItemList<>(FIGURES_JSON_PATH, Figure[].class);
	public List<Event> getEvents() {
		return events;
	}
	public void addEvent(Event event) {
		events.add(event);
	}
	public List<Dynasty> getDynasties() {
		return dynasties;
	}
	public void addDynasty(Dynasty danasty) {
		dynasties.add(danasty);
	}
	public List<King> getKings() {
		return kings;
	}
	public void addKing(King king) {
		kings.add(king);
	}
	public List<Festival> getFestivals() {
		return festivals;
	}
	public void addFestival(Festival festival) {
		festivals.add(festival);
	}
	public List<Figure> getFigures() {
		return figures;
	}
	public void addFigures(Figure figure) {
		figures.add(figure);
	}
    public List<Location> getLocation(){
    	return attractions;
    }
    public void addLocation(Location attraction) {
    	attractions.add(attraction);
    }
    
}
