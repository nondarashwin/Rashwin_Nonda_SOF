package com.manipal.dp.behavioural.command;
//concrete command
public class SoldStock implements Order {
	private Stock stock;

	public SoldStock(Stock stock) {
		this.stock = stock;
	}
	@Override
	public void execute() {
		stock.sell();
	}

}
