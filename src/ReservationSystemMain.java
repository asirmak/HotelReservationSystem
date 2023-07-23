public class ReservationSystemMain extends Services implements Comparable<ReservationSystemMain>{
	private RoomSystem room;
	private String hotelName, reservationMonth, cityName;
	private int reservationStart, reservationEnd;
	public static int totalNumberOfReservations = 0;
	
	public ReservationSystemMain(String cityName,String hotelName, String reservationMonth, int reservationStart,
			int reservationEnd){
		this.cityName = cityName;
		this.hotelName = hotelName;
		this.reservationMonth = reservationMonth;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
	}
	
	public ReservationSystemMain(String hotelName, String reservationMonth, int reservationStart,
			int reservationEnd, RoomSystem room){
		this.hotelName = hotelName;
		this.reservationMonth = reservationMonth;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.room = room;
	}
	public void displayInfo() {
		System.out.printf("\nReservation for %s room in %s starts on %s %d and ends on %s %d. "
				+ "Reservation has a total cost of $%d.\n\n", room.getType(), getHotelName(), getReservationMonth(), 
				getReservationStart(), getReservationMonth(), getReservationEnd(), (int)calculateService());
	}
	@Override
	public String toString() {
		return "Reservation ID #" + CustomerID + "\nReservation at "
				+ hotelName + " starts on " +  reservationMonth +" "+ reservationStart + " and ends on " + reservationMonth + " " + reservationEnd
				+ "\n";
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	String getServiceType() {
		return "Room booking";
	}
	
	double calculateService() {
		return calculateTotalPrice(getReservationStart(), getReservationEnd());
	}
	
	public int calculateTotalPrice(int start, int end) {
		int totalDay = end - start;
		int totalCost = 0;
		String[] peakMonths = {"June", "July", "August"};
		for(int i = 0; i<3; i++) {
			if(getReservationMonth().equals(peakMonths[i])) {
				totalCost = calculateTotalPrice(getReservationStart(), getReservationEnd(), 2);
				break;
			}
			else
				totalCost = room.getDailyCost()*totalDay;
		}
		return totalCost;
		
	}
	public int calculateTotalPrice(int start, int end, int multiplier) {
		int totalDay = end - start;
		return room.getDailyCost()*totalDay*multiplier;
	}
	public String getHotelName() {
		
		return hotelName;
	}
	public String getReservationMonth() {
		
		return reservationMonth;
	}
	public int getReservationStart() {
		
		return reservationStart;
	}
	public int getReservationEnd() {
		
		return reservationEnd;
	}
	@Override
	public int compareTo(ReservationSystemMain o) {
		if(this.hotelName.compareTo( o.hotelName) != 0) {
			return this.hotelName.compareTo( o.hotelName);
		}
		else {
			return this.reservationMonth.compareTo(o.reservationMonth);
		}
	}		

}

