package com.manipal.dp.behavioural.command;
//Receiver
public class Stock {
	private String itemName;
	private int quantity;
	
	public Stock() {
		itemName = "Mobile";
		quantity = 5;
	}
	
	public void buy() {
		System.out.println("Bought Stock name : " + itemName + "\tQuantity : " + quantity);
	}
	public void sell() {
		System.out.println("Sold Stock name : " + itemName + "\tQuantity : " + quantity);
	}
}
