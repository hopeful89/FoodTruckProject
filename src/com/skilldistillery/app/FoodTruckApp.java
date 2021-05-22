package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {
	private FoodTruck[] foodTrucks;
	private Scanner input = new Scanner(System.in);

	public FoodTruckApp(int numOfTrucks) {
		foodTrucks = new FoodTruck[numOfTrucks];
	}

	public static void main(String[] args) {

		// Instantiate new App to call run(), Allocate space for 10 trucks.
		FoodTruckApp foodApp = new FoodTruckApp(5);
		User newUser = new User(foodApp.input);

		// Call run and pass array reference to user

		foodApp.start(newUser);
		foodApp.menuOption(newUser);

		foodApp.input.close();
	}

	public void start(User newUser) {
		newFoodTrucks(newUser, foodTrucks);
	}

	public void newFoodTrucks(User user, FoodTruck[] foodTrucks) {
		int count = 0;

		System.out.println("Welcome to the Food Truck rating system.\n\n");
		System.out.println("\tI need the name,\n\t   food type,\n    and rating of the truck");

		while (true && count < foodTrucks.length) {
			FoodTruck newTruck = user.addFoodTruck();
			if (newTruck == null) {
				break;
			} else {
				foodTrucks[count] = newTruck;
			}
			count++;
		}
		if(count + 1 == foodTrucks.length) {
			System.out.println("Max count reached. Moving to menu!");
		}

	}
	
	public void menuOption(User user) {
		boolean choosingOptions = true;
		
		do {
			menuPrint();
			int userInput = user.userChoice();
			switch(userInput) {
			case 1:
				user.existingFoodTrucks(foodTrucks);
				break;
			case 2:
				user.averageRating(foodTrucks);
				break;
			case 3:
				user.highestRating(foodTrucks);
				break;
			case 4:
				System.out.println("Thanks for using the app come again!");
				choosingOptions = false;
				break;
			default:
				System.out.println("Not a valid response");
			}
			
			
			
		} while (choosingOptions);
	}
	
	public void menuPrint() {
		System.out.println(" ------------------------------");
		System.out.println("- 1. List existing food trucks -");
		System.out.println("- 2. See average rating        -");
		System.out.println("- 3. Display highest rated     -");
		System.out.println("- 4. Quit the Program          -");
		System.out.println(" ------------------------------");
		System.out.print("Your choice:    ");
	}

}
