
public class Laundry extends Services{

	public int clothingPieces;
	double laundryCost = 20;
	
	public String getServiceType() {
		return "Laundry";
	}
	
	public double calculateService() {
		return laundryCost*clothingPieces;
	}

	public int getClothingPieces() {
		return clothingPieces;
	}

	public void setClothingPieces(int clothingPieces) {
		this.clothingPieces = clothingPieces;
	}

	public double getLaundryCost() {
		return laundryCost;
	}

	public void setLaundryCost(double laundryCost) {
		this.laundryCost = laundryCost;
	}

	
}
