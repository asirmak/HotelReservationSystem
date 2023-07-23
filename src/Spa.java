
public class Spa extends Services{
	
	int days;
	double spaCost = 100;

	
	String getServiceType() {
		return "Spa";
	}
	
	double calculateService() {
		return spaCost*days;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public double getSpaCost() {
		return spaCost;
	}

	public void setSpaCost(double spaCost) {
		this.spaCost = spaCost;
	}
	
}
