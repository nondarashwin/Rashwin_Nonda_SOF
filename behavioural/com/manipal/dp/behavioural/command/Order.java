package com.manipal.dp.behavioural.command;

//command interface
public interface Order {
	void execute();
}

//Receiver
class Fan{
	public void switchOn() {
		System.out.println("switching on...");
	}

	public void switchOff() {
		System.out.println("switching off...");

	}
}

//concrete command
class SwitchOnFan implements Order{
	Fan fan;
	SwitchOnFan(Fan fan){
		this.fan = fan;
	}
	@Override
	public void execute() {		
		fan.switchOn();
	}

}
//concrete command
class SwitchOffFan implements Order{
	Fan fan;
	SwitchOffFan(Fan fan){
		this.fan = fan;
	}
	@Override
	public void execute() {		
		fan.switchOff();
	}	
}
//Invoker 
class RemoteControl{
	private Order order;

	public void setOrder(Order order) {
		this.order = order;
	}

	public void pressButton() {
		order.execute();
	}
}

//Client
class client{
	public static void main(String [] args) {
		RemoteControl remoteControl = new RemoteControl();
		Fan fan = new Fan();

		Order switchOnOrder = new SwitchOnFan(fan);
		Order switchOffOrder = new SwitchOffFan(fan);


		//Switch on fan
		remoteControl.setOrder(switchOnOrder);
		remoteControl.pressButton();

		//Switch off fan
		remoteControl.setOrder(switchOffOrder);
		remoteControl.pressButton();

	}
}





