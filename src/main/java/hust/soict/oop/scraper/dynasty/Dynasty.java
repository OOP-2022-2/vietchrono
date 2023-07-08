package hust.soict.oop.scraper.dynasty;
import java.util.*;

public class Dynasty {
    private String xungDot;
    private String thoiKy;
    private String doiPhuong;
    private String ketQua;


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

    // Getters and Setters for the attributes


}