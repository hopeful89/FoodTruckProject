package com.skilldistillery.app;

public class FoodTruck {
	
	//static to increment for unique truckId
	private static int trucksCreated = 0;
	private int truckId;
	private String truckName;
	private String foodType;
	private double rating;
	
	public FoodTruck(String truckName, String foodType, double rating) {
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
		trucksCreated++;
		truckId = trucksCreated;
	}
	//Added setters for future changes
	
	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "FoodTruck name: " + truckName + ", Type: " + foodType 
				+ ", Rating: " + rating + " TruckId: " + truckId + "\n";
	}

}
