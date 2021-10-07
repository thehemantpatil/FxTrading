package fxConversion;

import java.util.*;

public class PrintTrades {

	/*
	 * This class contains the method to print Booking variable Also contains a List
	 * object tradeList to store list of Booking Trades.
	 * 
	 */

	public static List<BookTrade> tradeList = new ArrayList<BookTrade>();

	public void addToBookedTrade(BookTrade bookingObject) {
		tradeList.add(bookingObject);
	}

	// Iterate over the tradeList which contains the object of BookedTrade and print
	// Respective Output.
	public void printBookedTrade() {

		System.out.println("|  TradeNo  | CurrencyPair |      CustomerName      |   Amount   |   Rate   |");

		for (int i = 0; i < tradeList.size(); i++) {

			System.out.println("|     " + (i + 1) + "   |   " + tradeList.get(i).getCurrencyPair() + "   |      "
					+ tradeList.get(i).getCustomerName() + "      | " + +tradeList.get(i).getAmount() + "  | "
					+ tradeList.get(i).getTotalAmount() + "  | ");
		}
	}

}
