package com.Device;

public class MobileFactory extends AbstractDeviceFactory {

    @Override
    Computer computerDevice(String type) {
        return null;
    }

    @Override
    Mobile mobileDevice(String type) {
        switch (type) {
            case "SmartPhone":
                return new SmartPhone();
            case "CellPhone":
                return new CellPhone();
            default:
                return null;
        }
    }
}
