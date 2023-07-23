public abstract class Services implements Calculable{
	
	int CustomerID = 0;
	
	public Services() {
		CustomerID = 2;
	}
	
	public void setCustomerID (int CustomerID) {
		this.CustomerID = CustomerID;
	}
	
	public int getCustomerID () {
		return CustomerID;
	}
	
	public double getCost() {
		return calculateService();
	}
	
	public void displayServiceInfo() {
		System.out.printf("Customer ID: %d, Service type: %s, Cost: %.2f\n",
				getCustomerID(), getServiceType(), calculateService());
	}
	
	abstract String getServiceType();
	
	abstract double calculateService();
	
}
