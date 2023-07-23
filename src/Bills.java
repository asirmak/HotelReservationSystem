
public class Bills implements Calculable {
	String type, month;
	double amount;
	
	public Bills(String type, String month, double amount) {
		this.type = type;
		this.month = month;
		this.amount = amount;
	}
	
	@Override
	public double getCost() {
		return getAmount();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
