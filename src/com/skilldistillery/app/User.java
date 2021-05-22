package com.skilldistillery.app;

import java.util.Scanner;

public class User {
	Scanner input;

	public User(Scanner input) {
		this.input = input;
	}

	public FoodTruck addFoodTruck() {

		String name;
		String foodType;
		String userChoice;
		int rating = 0;
		boolean isValid = false;

		System.out.print("Please enter truck name or quit: ");
		userChoice = input.nextLine();

		if (userChoice.equalsIgnoreCase("Q") || userChoice.equalsIgnoreCase("Quit")) {
			System.out.println();
			System.out.println("You have quit entering food trucks! Moving to menu.");
			System.out.println();
			return null;
		} else {
			name = userChoice;
		}
		System.out.print("Please enter truck food type: ");
		foodType = input.nextLine();

		while (isValid == false) {
			System.out.print("Please enter your rating 0-5: ");
			rating = input.nextInt();
			//flush
			input.nextLine();
			if (rating < 0 || rating > 5) {
				System.out.println("Please read allowed input");
			} else {
				isValid = true;
			}
		}

		return new FoodTruck(name, foodType, rating);
	}

	public void existingFoodTrucks(FoodTruck[] foodTruck) {
		for(int i = 0; i < foodTruck.length; i++) {
			if(foodTruck[i] != null) {
				//Write a better output for these in the foodtruck
				System.out.println(foodTruck[i].getTruckName());
			}
		}
	}

	public void averageRating(FoodTruck[] foodTruck) {
		System.out.println("Average Rating");

	}

	public void highestRating(FoodTruck[] foodTruck) {
		System.out.println("Highest Rated");
	}

	public int userChoice() {
		int userChoice = input.nextInt();
		return userChoice;
	}

}
