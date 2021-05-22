package com.skilldistillery.app;

import java.util.Scanner;

public class User {

	public User(Scanner input) {
	}

	// Prompts and records user input to create new food truck

	public FoodTruck addFoodTruck(TextPrinter printer, Scanner input) {

		String name;
		String foodType;
		String userChoice;
		double rating = 0;
		boolean isValid = false;

		printer.enterTruckInfo("name");
		userChoice = userStringChoice(input);

		// Choose to stop making trucks

		if (userChoice.equalsIgnoreCase("Q") || userChoice.equalsIgnoreCase("Quit")) {
			printer.stopEnteringTruckNames();
			return null;
		} else {
			name = userChoice;
		}
		printer.enterTruckInfo("food");
		foodType = userStringChoice(input);

		// Only isValid when data is between 0 - 5

		while (isValid == false) {
			printer.enterTruckRating();
			rating = userIntChoice(input);

			// flush the return

			input.nextLine();

			if (rating < 0 || rating > 5) {
				printer.errorMessage("invalid");
			} else {
				isValid = true;
			}
		}

		// New Truck returned to be added

		return new FoodTruck(name, foodType, rating);
	}
	
	public void existingTrucks(FoodTruck[] foodTruck) {
		for (FoodTruck truck : foodTruck) {
			System.out.println(truck.toString());
		}
	}

	// Average rating of all listed food trucks


	public void averageRating(FoodTruck[] foodTruck) {
		double sum = 0;
		for (FoodTruck truck : foodTruck) {
			sum += truck.getRating();
		}
		
		double avg = (sum / foodTruck.length);
		System.out.printf("Average Rating: %.2f\n", avg);
	}

	// Highest rated food truck or trucks

	public void highestRating(FoodTruck[] foodTruck) {
		FoodTruck bestTruck = foodTruck[0];
		for (FoodTruck nextTruck : foodTruck) {
			if(nextTruck.getRating() > bestTruck.getRating()) {
				bestTruck = nextTruck;
			}
		}
		System.out.println("Highest Rated truck I found first: \n" + bestTruck.toString());
	}

	// Used to get input based on type

	public double userIntChoice(Scanner input) {
		double userChoice = input.nextInt();
		return userChoice;
	}

	public String userStringChoice(Scanner input) {
		String userChoice = input.nextLine();
		return userChoice;
	}

}
