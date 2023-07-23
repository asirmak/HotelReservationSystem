
public enum MenuOptions {

	OPTION1("1. Create new Reservation with Room Type"),
	OPTION2("2. Display all Reservations"),
	OPTION3("3. List the reservations for a specific city"),
	OPTION4("4. Add extra services to a reservation"),
	OPTION5("5. Calculate total cost for each service"),
	OPTION6("6. Display the total cost of every customer"),
	OPTION7("7. Add an Employee"),
	OPTION8("8. Add a Bill"),
	OPTION9("9. Get Monthly Balance"),
	OPTION10("10. List all Services sorted based on cost"),
	OPTION11("11. List all Reservations sorted based on hotel names"),
	OPTION12("12. Exit");
	
	
	private String option;
	
	MenuOptions(String option){
		this.option = option;
	}
	
	public String getOption() {
		return option;
	}
}