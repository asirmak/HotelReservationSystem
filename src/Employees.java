
public class Employees implements Calculable {
	
	private String name, surname;
	private double monthlyPayment;
	private int id;
	
	public Employees(String name, String surname, int id, double monthlyPayment){
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.monthlyPayment = monthlyPayment;
	}
	
	public double getCost() {
		return getMonthlyPayment();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
