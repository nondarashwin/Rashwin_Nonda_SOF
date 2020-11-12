package com.Device;

public class Client {
    public static void main(String[] args) {
        Computer laptop = Producer.device("Computer").computerDevice("Laptop");
        laptop.name();
        Computer computer = Producer.device("Computer").computerDevice("PersonalComputer");
        computer.name();
        Mobile cellphone = Producer.device("Mobile").mobileDevice("CellPhone");
        cellphone.name();
        Mobile smartphone = Producer.device("Mobile").mobileDevice("SmartPhone");
        smartphone.name();
    }
}
