package data;

public class AnuntString implements Comparable<AnuntString>{
	private String title;
	private String price;
	private String rooms;
	private String area;
	private String floor;
	private String comandat;
	private String link;
	private String priceByMeter;
	private String location;

	

	public AnuntString(String title, String price, String rooms, String area, String floor, String comandat,
			String link, String priceByMeter, String location) {
		super();
		this.title = title;
		this.price = price;
		this.rooms = rooms;
		this.area = area;
		this.floor = floor;
		this.comandat = comandat;
		this.link = link;
		this.priceByMeter = priceByMeter;
		this.location = location;
	}


	@Override
	public String toString() {
		return String.format(
				"Anunt [price=%s ,area=%s,rooms=%s,priceByMeter=%s, location=%s	,title=%s,   floor=%s, comandat=%s, link=%s ]", price,
				area, rooms, priceByMeter, location,title, floor, comandat, link);
	}

	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getRooms() {
		return rooms;
	}


	public void setRooms(String rooms) {
		this.rooms = rooms;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		this.floor = floor;
	}


	public String getComandat() {
		return comandat;
	}


	public void setComandat(String comandat) {
		this.comandat = comandat;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getPriceByMeter() {
		return priceByMeter;
	}


	public void setPriceByMeter(String priceByMeter) {
		this.priceByMeter = priceByMeter;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public int compareTo(AnuntString o) {
		// TODO Auto-generated method stub
		return this.getPrice().compareTo(o.getPrice());
	}

}
