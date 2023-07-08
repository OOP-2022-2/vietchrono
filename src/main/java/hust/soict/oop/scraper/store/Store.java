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

	private List<Event> events = new ArrayList<>();
	private List<Figure> figures = new ArrayList<>();
	private List<King> kings = new ArrayList<>();
	private List<Festival> festivals = new ArrayList<>();

	private ControllerItemList<Event> eventListController = new ControllerItemList<>(EVENTS_JSON_PATH, Event[].class);
	private ControllerItemList<King> kingListController = new ControllerItemList<>(KINGS_JSON_PATH, King[].class);
	private ControllerItemList<Figure> figureListController = new ControllerItemList<>(FIGURES_JSON_PATH,
			Figure[].class);
	private ControllerItemList<Festival> festivalListController = new ControllerItemList<>(FESTIVALS_JSON_PATH,
			Festival[].class);
//    private ControllerItemList<Dynasty> dynastyListController = new ControllerItemList<>(DYNASTIES_JSON_PATH, Dynasty[].class);
//    private ControllerItemList<Location> attractionListController = new ControllerItemList<>(ATTRACTIONS_JSON_PATH, Location[].class);

	public Store() {
		events = eventListController.getItems();
		figures = figureListController.getItems();
		kings = kingListController.getItems();
		festivals = festivalListController.getItems();
	}

	public List<Event> getEvents() {
		return events;
	}

	public List<Figure> getFigures() {
		return figures;
	}

	public List<King> getKings() {
		return kings;
	}

	public List<Festival> getFestivals() {
		return festivals;
	}

	public List<Event> searchEvent(String query) {
		List<Event> result = new ArrayList<>();
		for (Event event : events) {
			if (event.getEvent() != null
					&& event.getEvent().toLowerCase().trim().contains(query.toLowerCase().trim())) {
				result.add(event);
			}
		}
		return result;
	}

	public List<King> searchKing(String query) {
		List<King> result = new ArrayList<>();
		for (King king : kings) {
			if (king.getName() != null && king.getName().toLowerCase().trim().contains(query.toLowerCase().trim())) {
				result.add(king);
			}
		}
		return result;
	}
	
	public List<Figure> searchFigure(String query) {
		List<Figure> result = new ArrayList<>();
		for (Figure figure : figures) {
			if (figure.getName() != null && figure.getName().toLowerCase().trim().contains(query.toLowerCase().trim())) {
				result.add(figure);
			}
		}
		return result;
	}
	
	public List<Festival> searchFestival(String query) {
		List<Festival> result = new ArrayList<>();
		for (Festival festival : festivals) {
			if (festival.getName() != null && festival.getName().toLowerCase().trim().contains(query.toLowerCase().trim())) {
				result.add(festival);
			}
		}
		return result;
	}

}
