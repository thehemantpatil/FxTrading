package fxConversion;

import java.util.*;

public class BookTrade {
	/*
	 * This class contains the all the necesaary Variables to store Booking Hostory.
	 * INR hashmap is For Storing all the Values of Foreign Currencies according to
	 * Indian Currency. By creating HashMap like india and Storing into list We can
	 * add as much as we want Currencies Value. To make it more dynamic.
	 */

	private String customerName;
	private String currencyPair;
	private double amount;
	private double totalAmount;
	private static Map<String, Double> INR = new HashMap<String, Double>(Map.of("USD", 66.0));

	public void setINR(String key, Double value) {
		INR.replace(key, value);
	}

	public double getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public String getCurrencyPair() {
		return this.currencyPair;
	}

	public double getAmount() {
		return this.amount;
	}

	public Map<String, Double> getCurrencyRateList() {
		return INR;
	}

}
