package hust.soict.oop.scraper.dynasty;

import java.util.*;

import hust.soict.oop.scraper.event.Event;
import hust.soict.oop.scraper.figure.Figure;
import hust.soict.oop.scraper.figure.King;

public class Dynasty {
	private String xungDot;
	private String thoiKy;
	private String doiPhuong;
	private String ketQua;
	private List<Event> relatedEvents = new ArrayList<>();
	private List<King> relatedKings = new ArrayList<>();
	private List<Figure> relatedFigures = new ArrayList<>();

	// Constructor
	public Dynasty(String xungDot, String thoiKy, String doiPhuong, String ketQua) {
		super();
		this.xungDot = xungDot;
		this.thoiKy = thoiKy;
		this.doiPhuong = doiPhuong;
		this.ketQua = ketQua;
	}

	public Dynasty() {

	}

	public String getXungDot() {
		return xungDot;
	}

	public void setXungDot(String xungDot) {
		this.xungDot = xungDot;
	}

	public String getThoiKy() {
		return thoiKy;
	}

	public void setThoiKy(String thoiKy) {
		this.thoiKy = thoiKy;
	}

	public String getDoiPhuong() {
		return doiPhuong;
	}

	public void setDoiPhuong(String doiPhuong) {
		this.doiPhuong = doiPhuong;
	}

	public String getKetQua() {
		return ketQua;
	}

	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}

	public List<Event> getRelatedEvents() {
		return relatedEvents;
	}

	public void setRelatedEvents(List<Event> relatedEvents) {
		this.relatedEvents = relatedEvents;
	}

	public List<King> getRelatedKings() {
		return relatedKings;
	}

	public void setRelatedKings(List<King> relatedKings) {
		this.relatedKings = relatedKings;
	}

	public List<Figure> getRelatedFigures() {
		return relatedFigures;
	}

	public void setRelatedFigures(List<Figure> relatedFigures) {
		this.relatedFigures = relatedFigures;
	}

	// Getters and Setters for the attributes

}