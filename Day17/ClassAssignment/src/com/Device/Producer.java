package com.Device;

public class Producer {

    static AbstractDeviceFactory device(String type) {
        switch (type) {
            case "Computer":
                return new ComputerFactory();
            case "Mobile":
                return new MobileFactory();
        }
        return null;
    }
}
