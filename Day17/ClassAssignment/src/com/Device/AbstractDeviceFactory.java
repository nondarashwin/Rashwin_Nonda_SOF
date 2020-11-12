package com.Device;

public abstract class AbstractDeviceFactory {
    abstract Computer computerDevice(String type);

    abstract Mobile mobileDevice(String type);
}
