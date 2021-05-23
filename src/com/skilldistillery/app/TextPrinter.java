package com.skilldistillery.app;

public class TextPrinter {
	
	
	public void welcomeToApp() {
		System.out.println("Welcome to the Food Truck rating system.\n\n");
		System.out.println("You may enter up to 5 trucks information\n");
		System.out.println("\tI need the name,\n\t   food type,\n    and rating of the truck");
	}
	
	public void mainMenuPrint() {
		System.out.println(" ------------------------------");
		System.out.println("- 1. List existing food trucks -");
		System.out.println("- 2. See average rating        -");
		System.out.println("- 3. Display highest rated     -");
		System.out.println("- 4. Quit the Program          -");
		System.out.println(" ------------------------------");
		System.out.print("Your choice:    ");
	}
	
	public void appExitMessage() {
		System.out.println("Thanks for using the app come again!");
		System.out.println("The pleasure was all ours!");
	}
	
	public void errorMessage(String type) {
		if(type.equals("invalid")) {
			System.out.println("Not a valid response");
		}
		if(type.equals("maxCount")) {
			System.out.println();
			System.out.println("Max count reached. Moving to menu!");
			System.out.println();
		}
		if(type.equals("noTrucks")){
			System.out.println("\nYou forgot to add trucks.\n");
		}
				
	}
	
	public void enterTruckInfo(String type) {
		if(type.equals("name")) {
			System.out.print("Please enter truck name or quit: ");
		}else if(type.equals("food")) {
			System.out.print("Please enter food type: ");
		}
	}
	
	public void enterTruckRating() {
		System.out.print("Please enter your rating 0-5: ");
	}
	
	public void stopEnteringTruckNames() {
		System.out.println();
		System.out.println("You have quit entering food trucks! Moving to menu.");
		System.out.println();
	}
	
}
