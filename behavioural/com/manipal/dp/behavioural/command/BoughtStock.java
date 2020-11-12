package com.manipal.dp.behavioural.command;
//concrete command

public class BoughtStock implements Order {
	private Stock stock;
	
	public BoughtStock(Stock stock) {
		this.stock = stock;
	}
	@Override
	public void execute() {
		stock.buy();
	}

}
