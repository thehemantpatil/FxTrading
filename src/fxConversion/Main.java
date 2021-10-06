package fxConversion;

import java.util.*;

public class Main {

	static Scanner input = new Scanner(System.in);

	public static String getStringinput() {

		String stringinput;

		while(true) {
			
			stringinput = input.nextLine();

			if (stringinput == "" || stringinput == " ") {
				System.out.println("Please Enter valid customer name");

			} else {
				break;
			}
		}

		return stringinput;
	}
	
	public static double getDoubleinput() {

		double doubleinput;

		while(true) {

			if (input.hasNextDouble()) {
				doubleinput = input.nextDouble();
				break;
				
			} else {
				System.out.println("Please Enter valid customer name");
			}
		}

		return doubleinput;
	}

	
	public static void main(String[] args) {

		OnBoarding onBoarding = new OnBoarding();
		onBoarding.displayChoices();

		int userChoice = onBoarding.getUserChoice();

		if (userChoice == 1) {
			
			BookTrade bookTrade = new BookTrade();

			System.out.println("Enter Customer Name");
			String customerName = getStringinput();
			bookTrade.setCustomerName(customerName);

			System.out.println("Enter Currency Pair");
			String currencyPair = getStringinput();
			bookTrade.setCurrencyPair(currencyPair);

			System.out.println("Enter amount to transfer");
			double amount = getDoubleinput();
			bookTrade.setAmount(amount);
			
			

		}

	}
}
