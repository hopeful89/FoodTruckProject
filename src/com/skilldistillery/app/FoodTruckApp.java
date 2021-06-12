package com.skilldistillery.app;

import java.util.InputMismatchException;
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
		User newUser = new User();

		// Application Start
		foodApp.newFoodTrucks(newUser, foodApp.foodTrucks, printer, input);

		// Present menu after truck completion
		foodApp.menuOption(newUser, printer, input, foodApp.foodTrucks);

		// close scanner
		input.close();
	}

	public void newFoodTrucks(User user, FoodTruck[] foodTrucks, TextPrinter printer, Scanner input) {
		int count = 0;

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
		// Array null checked for next operations
		FoodTruck[] validTrucks = validTruckArray(foodTruck);
		boolean trucksAdded = validTrucks.length != 0;

		do {

			printer.mainMenuPrint();
			int userInput;
			// Cast needed since its a double return
		    try { userInput = (int) user.userIntChoice(input);}
		    catch (InputMismatchException error) {
		        userInput = -1;
		        input.nextLine();
		    }
		    
		      
			switch (userInput) {
			
			//TODO write new method to validate and call userMethods
			//for all 3 cases validateArrayLength(FoodTruck[] validTrucks, User user, TextPrinter printer)
			case 1:
				if(trucksAdded) {
					user.existingTrucks(validTrucks);
				}else {
					printer.errorMessage("noTrucks");
				}
				break;
			case 2:
				if(trucksAdded) {
					user.averageRating(validTrucks);
				}else {
					printer.errorMessage("noTrucks");
				}
				break;
			case 3:
				if(trucksAdded) {
					user.highestRating(validTrucks);
				}else {
					printer.errorMessage("noTrucks");
				}
				
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

	// Used to return an array of valid non null trucks
	public FoodTruck[] validTruckArray(FoodTruck[] foodTruck) {
		// Use count to track number of non null results

		int count = 0;

		for (int i = 0; i < foodTruck.length; i++) {
			if (foodTruck[i] != null) {
				count++;
			}
		}
		// New array - no null values

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
