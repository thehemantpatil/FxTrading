package fxConversion;

import java.util.*;


public class BookTrade {

	private String customerName;
	private String currencyPair;
	private double amount;
	private Map<String, Double> currencyRateList = new HashMap<String, Double>(Map.of("USD", 66.0));

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
	
	public Map<String, Double> currencyRateList() {
		return this.currencyRateList;
	}
	
}
