package hust.soict.oop.scraper.linker;

import static hust.soict.oop.scraper.paths.Paths.ATTRACTIONS_JSON_PATH;
import static hust.soict.oop.scraper.paths.Paths.DYNASTIES_JSON_PATH;
import static hust.soict.oop.scraper.paths.Paths.EVENTS_JSON_PATH;
import static hust.soict.oop.scraper.paths.Paths.FESTIVALS_JSON_PATH;
import static hust.soict.oop.scraper.paths.Paths.FIGURES_JSON_PATH;
import static hust.soict.oop.scraper.paths.Paths.KINGS_JSON_PATH;

import java.util.*;
import hust.soict.oop.scraper.dynasty.Dynasty;
import hust.soict.oop.scraper.event.Event;
import hust.soict.oop.scraper.festival.Festival;
import hust.soict.oop.scraper.figure.King;
import hust.soict.oop.scraper.location.Location;
import hust.soict.oop.scraper.screen.ControllerItemList;
import hust.soict.oop.scraper.store.Store;
import hust.soict.oop.scraper.figure.Figure;

public class Linker {

	private ControllerItemList<Event> eventListController = new ControllerItemList<>(EVENTS_JSON_PATH, Event[].class);
	private ControllerItemList<King> kingListController = new ControllerItemList<>(KINGS_JSON_PATH, King[].class);
	private ControllerItemList<Figure> figureListController = new ControllerItemList<>(FIGURES_JSON_PATH,
			Figure[].class);
	private ControllerItemList<Dynasty> dynastyListController = new ControllerItemList<>(DYNASTIES_JSON_PATH,
			Dynasty[].class);
	private ControllerItemList<Location> attractionListController = new ControllerItemList<>(ATTRACTIONS_JSON_PATH,
			Location[].class);
	private ControllerItemList<Festival> festivalListController = new ControllerItemList<>(FESTIVALS_JSON_PATH,
			Festival[].class);

	private List<Event> events = new ArrayList<>();
	private List<Figure> figures = new ArrayList<>();
	private List<King> kings = new ArrayList<>();
	private List<Festival> festivals = new ArrayList<>();
	private List<Location> locations = new ArrayList<>();
	private List<Dynasty> dynasties = new ArrayList<>();

	public Linker() {
		events = eventListController.getItems();
		figures = figureListController.getItems();
		kings = kingListController.getItems();
		festivals = festivalListController.getItems();
		locations = attractionListController.getItems();
		dynasties = dynastyListController.getItems();

		setEventToDynasty();
		setKingToDynasty();
		setFigureToDynasty();
		
		setFigureToEvent();
		setKingToEvent();
		
		setFigureToKing();
		setLocationToKing();
		setEventToKing();
		setDynastyToKing();
		
		setEventToFigure();
		setLocationToFigure();
		setDynastyToFigure();
	}
	
	public void setFigureToKing() {
		for (int i = 0; i < kings.size(); i++) {
			List<Figure> list = new ArrayList<>();
			for (Figure figure : figures) {
				if (kings.get(i).getDescription() != null && figure.getName() != kings.get(i).getName()
						&& kings.get(i).getDescription().toLowerCase().contains(figure.getName().toLowerCase())) {
					list.add(figure);
				}
			}
			kings.get(i).setRelatedFigures(list);
		}
	}
	
	public void setEventToKing() {
		for (int i = 0; i < kings.size(); i++) {
			List<Event> list = new ArrayList<>();
			for (Event event : events) {
				if (event.getDescription() != null 
						&& event.getDescription().toLowerCase().contains(kings.get(i).getName().toLowerCase())) {
					list.add(event);
				}
			}
			kings.get(i).setRelatedEvents(list);
		}
	}
	
	public void setLocationToKing() {
		for (int i = 0; i < kings.size(); i++) {
			List<Location> list = new ArrayList<>();
			for (Location location : locations) {
				if (location.getName() != null 
						&& location.getName().toLowerCase().contains(kings.get(i).getName().toLowerCase())) {
					list.add(location);
				}
			}
			kings.get(i).setRelatedLocations(list);
		}
	}
	
	public void setDynastyToKing() {
		for (int i = 0; i < kings.size(); i++) {
			List<Dynasty> list = new ArrayList<>();
			for (Dynasty dynasty : dynasties) {
				if (dynasty.getXungDot() != null 
						&& dynasty.getXungDot().toLowerCase().contains(kings.get(i).getName().toLowerCase())) {
					list.add(dynasty);
				}
			}
			kings.get(i).setRelatedDynasty(list);
		}
	}
	
	public void setDynastyToFigure() {
		for (int i = 0; i < figures.size(); i++) {
			List<Dynasty> list = new ArrayList<>();
			for (Dynasty dynasty : dynasties) {
				if (dynasty.getXungDot() != null 
						&& dynasty.getXungDot().toLowerCase().contains(figures.get(i).getName().toLowerCase())) {
					list.add(dynasty);
				}
			}
			figures.get(i).setRelatedDynasty(list);
		}
	}
	
	public void setLocationToFigure() {
		for (int i = 0; i < figures.size(); i++) {
			List<Location> list = new ArrayList<>();
			for (Location location : locations) {
				if (location.getName() != null 
						&& location.getName().toLowerCase().contains(figures.get(i).getName().toLowerCase())) {
					list.add(location);
				}
			}
			figures.get(i).setRelatedLocation(list);
		}
	}
	
	public void setEventToFigure() {
		for (int i = 0; i < figures.size(); i++) {
			List<Event> list = new ArrayList<>();
			for (Event event : events) {
				if (event.getDescription() != null 
						&& event.getDescription().toLowerCase().contains(figures.get(i).getName().toLowerCase())) {
					list.add(event);
				}
			}
			figures.get(i).setRelatedEvents(list);
		}
	}
	
	public void setFigureToFigure() {
		for (int i = 0; i < figures.size(); i++) {
			List<Figure> list = new ArrayList<>();
			for (Figure figure : figures) {
				if (figure.getDescription() != null && figure.getName() != figures.get(i).getName() 
						&& figure.getDescription().toLowerCase().contains(figures.get(i).getName().toLowerCase())) {
					list.add(figure);
				}
			}
			figures.get(i).setRelatedFigures(list);
		}
	}
	
	public void setEventToDynasty() {
		for (int i = 0; i < dynasties.size(); i++) {
			List<Event> list = new ArrayList<>();
			for (Event event : events) {
				if (event.getDescription() != null
						&& event.getDescription().toLowerCase().contains(dynasties.get(i).getThoiKy().toLowerCase())) {
					list.add(event);
				}
			}
			dynasties.get(i).setRelatedEvents(list);
		}
	}

	public void setKingToDynasty() {
		for (int i = 0; i < dynasties.size(); i++) {
			List<King> list = new ArrayList<>();
			for (King king : kings) {
				if (king.getName() != null
						&& dynasties.get(i).getKetQua().toLowerCase().contains(king.getName().toLowerCase())) {
					list.add(king);
				}
			}
			dynasties.get(i).setRelatedKings(list);
		}
	}

	public void setFigureToDynasty() {
		for (int i = 0; i < dynasties.size(); i++) {
			List<Figure> list = new ArrayList<>();
			for (Figure figure : figures) {
				if (dynasties.get(i).getKetQua().toLowerCase().contains(figure.getName().toLowerCase())
						|| dynasties.get(i).getKetQua().toLowerCase().contains(figure.getOtherName().toLowerCase())) {
					list.add(figure);
				}
			}
			dynasties.get(i).setRelatedFigures(list);
		}
	}
	
	public void setFigureToEvent() {
		for (int i = 0; i < events.size(); i++) {
			List<Figure> list = new ArrayList<>();
			for (Figure figure : figures) {
				if (events.get(i).getDescription() != null && (events.get(i).getEvent().toLowerCase().contains(figure.getName().toLowerCase())
						|| events.get(i).getDescription().toLowerCase().contains(figure.getName().toLowerCase()))) {
					list.add(figure);
				}
			}
			events.get(i).setRelatedFigures(list);
		}
	}
	
	public void setKingToEvent() {
		for (int i = 0; i < events.size(); i++) {
			List<King> list = new ArrayList<>();
			for (King king : kings) {
				if (king.getName() != null && (events.get(i).getEvent().toLowerCase().contains(king.getName().toLowerCase())
						|| events.get(i).getDescription() != null && events.get(i).getDescription().toLowerCase().contains(king.getName().toLowerCase()))) {
					list.add(king);
				}
			}
			events.get(i).setRelatedKings(list);
		}
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

	public List<Location> getLocations() {
		return locations;
	}

	public List<Dynasty> getDynasties() {
		return dynasties;
	}
}
