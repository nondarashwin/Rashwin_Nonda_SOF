package com.manipal.dp.behavioural.command;

public class CommandPatternDemo {

	public static void main(String[] args) {
		Stock someStock = new Stock();
		
		BoughtStock boughtStockOrder = new BoughtStock(someStock);
		SoldStock soldStockOrder = new SoldStock(someStock);
		
		Broker broker = new Broker();
		broker.takeOrder(boughtStockOrder);
		broker.takeOrder(soldStockOrder);
		
		broker.placeOrders();
		
	}

}
