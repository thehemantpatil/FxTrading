package fxConversion;

import java.util.*;
import java.util.regex.Pattern;

/*Logic
 * Created HashMap for storing Currency name and their Respective rate According to Specific USD.
 * Hashmap Name is Same as Country currency Name for Ex. INR =  <Key = currecencyName, Value = CurrencyRate>.
 * We Can easily add New currency rate and get the result according to it.
 * The CurrencyPair getting from user is splitted into array; First element of array will be use to,
 * to get Value by using key into the hashmap. 
 * Once user book the trade the object of booking history is storing into the List.
 */

public class Main {

	static Scanner input = new Scanner(System.in);

	// To validate and get User Name from user.
	public static String getCustomerNameinput() {
		String stringinput;

		while (true) {
			stringinput = input.next();

			// It will throw error if person name contains any number or special character.
			if (!Pattern.matches("[a-zA-Z]*", stringinput)) {
				System.out.println(
						"Please Enter valid customer name; Name should not contain any special character or number."
								+ stringinput + "NDN");
				input.nextLine();

			} else {
				break;
			}
		}

		return stringinput;
	}

	// This function is for to validate and get CurrencyPair.
	public static String getValidCurrencyPair() {

		String stringinput;
		BookTrade booktrade = new BookTrade();

		while (true) {
			try {
				// It will convert the String into uppercase, incase user put lowercase.
				stringinput = input.next().toUpperCase();
				String[] stringinputArray = stringinput.split("-");

				if (booktrade.getCurrencyRateList().containsKey(stringinputArray[0])
						&& "INR".equals(stringinputArray[1])) {
					return stringinput;

				} else {

					System.out.println("Please Select From listed Currency Pair");

					// It will list all the available Currency Pair.
					for (String key : booktrade.getCurrencyRateList().keySet()) {
						System.out.println(key + "-INR");
					}
				}

			} catch (Exception e) {

				System.out.println("Please Select From listed Currency Pair");
				for (String key : booktrade.getCurrencyRateList().keySet()) {
					System.out.println(key + "-INR");
				}
			}
		}
	}

	// This Function will get Amount from user and validate it as a Pure integer.
	public static int getAmountinput() {

		int amountInput;

		while (true) {
			try {
				// if amount entered by user is not an integer, It will throw an error.
				amountInput = input.nextInt();
				return amountInput;

			} catch (Exception e) {
				System.out.println("Please Enter valid Amount; Must be valid Integer. ");
				input.nextLine();
			}
		}
	}

	// This function is for get a valid choice from user.
	public static int getChoiceInput() {

		int integerInput;

		while (true) {

			try {
				integerInput = input.nextInt();

				if (integerInput == 1 || integerInput == 2) {
					break;

				} else {
					System.out.println("Please Enter valid Choice");
				}

			} catch (Exception e) {
				System.out.println("Please Enter valid Choice");
			}
		}

		return integerInput;
	}

	// Here, creating a trade object if user booked the trade.
	// Storing created boooked object into the List for printing operation.
	public static void tradeBooking() {

		BookTrade bookTrade = new BookTrade();
		PrintTrades printTrades = new PrintTrades();

		System.out.println("Enter Customer Name");
		String customerName = getCustomerNameinput();
		bookTrade.setCustomerName(customerName);

		System.out.println("Enter Currency Pair");
		String currencyPair = getValidCurrencyPair();
		bookTrade.setCurrencyPair(currencyPair);

		System.out.println("Enter amount to transfer");
		int amount = getAmountinput();
		bookTrade.setAmount(amount);

		System.out.println("Do You Want to get rate:- ");
		System.out.println("1. Yes");
		System.out.println("2. No");

		int rateChoice = getChoiceInput();
		String[] currencyPairArray = currencyPair.split("-");
		double totalAmount = amount * bookTrade.getCurrencyRateList().get(currencyPairArray[0]);

		if (rateChoice == 1) {
			System.out.println("You are transferring INR " + totalAmount + " to " + customerName);
		}

		System.out.println("Do You Want to Book Trade:- ");
		System.out.println("1. Book");
		System.out.println("2. Cancel");

		int bookChoice = getChoiceInput();

		if (bookChoice == 1) {

			bookTrade.setTotalAmount(totalAmount);
			printTrades.addToBookedTrade(bookTrade);

			System.out.println("Trade for " + currencyPair + " has been booked with rate "
					+ bookTrade.getCurrencyRateList().get(currencyPairArray[0]) + ". The amount of Rs " + totalAmount
					+ " will  be transferred in 2 working days to " + customerName + "..");

		} else if (bookChoice == 2) {
			System.out.println("Trade is Canceled.");
		}
	}

	public static void main(String[] args) {
		try {
			while (true) {

				// Onboarding class is for to display Onboarding messages and choices.
				OnBoarding onBoarding = new OnBoarding();
				onBoarding.displayChoices();

				int userChoice = onBoarding.getUserChoice();

				if (userChoice == 1) {
					tradeBooking();

				} else if (userChoice == 2) {
					PrintTrades printTrade = new PrintTrades();
					printTrade.printBookedTrade();

				} else if (userChoice == 3) {
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Please Re-run Application");
		}
	}
}
