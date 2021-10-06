package fxConversion;

import java.util.Scanner;

public class OnBoarding {

	public void displayChoices() {

		System.out.println("Enter your Choice:- ");
		System.out.println("");
		System.out.println("1. Book Trade");
		System.out.println("1. Print Trades");
		System.out.println("3. Exit");

	}

	public int getUserChoice() {

		try {
			while(true) {
				
				Scanner input = new Scanner(System.in);
				input.close();
				int userChoice = -1;

				if (input.hasNextInt()) {
					int choice = input.nextInt();

					if (choice > 0 && choice < 4) {
						userChoice = choice;
						return userChoice;

					} else {
						System.out.println("Please enter valid choice");
					}

				} else {
					System.out.println("Please enter valid choice");
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return -1;
	}
}
