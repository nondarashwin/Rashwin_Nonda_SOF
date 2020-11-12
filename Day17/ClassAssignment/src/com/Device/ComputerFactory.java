package com.Device;

public class ComputerFactory extends AbstractDeviceFactory {
    @Override
    Computer computerDevice(String type) {
        switch (type) {
            case "Laptop":
                return new Laptop();
            case "PersonalComputer":
                return new PersonalComputer();
            default:
                return null;
        }
    }

    @Override
    Mobile mobileDevice(String type) {
        return null;
    }
}
