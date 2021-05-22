package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {
	private FoodTruck[] foodTrucks;

	public FoodTruckApp(int numOfTrucks) {
		foodTrucks = new FoodTruck[numOfTrucks];
	}

	public static void main(String[] args) {
		// Required to get user input
		Scanner input = new Scanner(System.in);

		// Calls most printed text in application
		TextPrinter printer = new TextPrinter();

		// Instantiate FoodTruckApp to call for newFoodTrucks()
		// Allocate space for 5 trucks.
		FoodTruckApp foodApp = new FoodTruckApp(5);

		// Create User instance
		User newUser = new User(input);

		// Application  Start
		foodApp.newFoodTrucks(newUser, foodApp.foodTrucks, printer, input);

		// Present menu after truck completion
		foodApp.menuOption(newUser, printer, input, foodApp.foodTrucks);

		// close scanner
		input.close();
	}

	public void newFoodTrucks(User user, FoodTruck[] foodTrucks, TextPrinter printer, Scanner input) {
		int count = 0;

		// startText
		printer.welcomeToApp();
		while (true && count < foodTrucks.length) {

			// Creates a new truck based on user input
			FoodTruck newTruck = user.addFoodTruck(printer, input);

			// When user quits truck returns null
			if (newTruck == null) {
				break;
			} else {

				// Valid information adds a new truck
				foodTrucks[count] = newTruck;
			}
			count++;
		}

		if (count == foodTrucks.length) {
			printer.errorMessage("maxCount");
		}

	}

	public void menuOption(User user, TextPrinter printer, Scanner input, FoodTruck[] foodTruck) {
		boolean choosingOptions = true;

		FoodTruck[] validTrucks = validTruckArray(foodTruck);

		do {

			printer.mainMenuPrint();

			// Cast needed since its a double return
			int userInput = (int) user.userIntChoice(input);
			switch (userInput) {
			case 1:
				user.existingTrucks(validTrucks);
				break;
			case 2:
				user.averageRating(validTrucks);
				break;
			case 3:
				user.highestRating(validTrucks);
				break;
			case 4:
				printer.appExitMessage();
				
				// exits program loop
				
				choosingOptions = false;
				break;
			default:
				printer.errorMessage("invalid");
			}
		} while (choosingOptions);
	}

	public FoodTruck[] validTruckArray(FoodTruck[] foodTruck) {
		// Use count to track number of non null results

		int count = 0;

		for (int i = 0; i < foodTruck.length; i++) {
			if (foodTruck[i] != null) {
				count++;
			}
		}
		// New array based on non null values

		FoodTruck[] validTrucks = new FoodTruck[count];
		count = 0;

		// Assign non null values to validTrucks

		for (int i = 0; i < foodTruck.length; i++) {
			if (foodTruck[i] != null) {
				validTrucks[count] = foodTruck[i];
				count++;
			}
		}

		return validTrucks;

	}

}
