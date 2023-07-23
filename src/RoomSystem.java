
public class RoomSystem {
	private String type;
	private int dailyCost, roomSize;
	private Boolean hasBath;
	
	public RoomSystem(String type, int dailyCost, int roomSize, Boolean hasBath) {
		this.type = type;
		this.dailyCost = dailyCost;
		this.roomSize = roomSize;
		this.hasBath = hasBath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(int dailyCost) {
		this.dailyCost = dailyCost;
	}

	public int getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}

	public Boolean getHasBath() {
		return hasBath;
	}

	public void setHasBath(Boolean hasBath) {
		this.hasBath = hasBath;
	}

	
}
