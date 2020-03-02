package Dao;

public class classData {
	public int ClassNumber;
	public int Floor;
	public int MaximumPeople;
	public int peoplePresent;
	public int getClassNumber() {
		return ClassNumber;
	}
	public void setClassNumber(int classNumber) {
		ClassNumber = classNumber;
	}
	public int getFloor() {
		return Floor;
	}
	public void setFloor(int floor) {
		Floor = floor;
	}
	public int getMaximumPeople() {
		return MaximumPeople;
	}
	public void setMaximumPeople(int maximumPeople) {
		MaximumPeople = maximumPeople;
	}
	public int getPeoplePresent() {
		return peoplePresent;
	}
	public void setPeoplePresent(int peoplePresent) {
		this.peoplePresent = peoplePresent;
	}
}
