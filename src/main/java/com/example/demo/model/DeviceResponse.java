package com.example.demo.model;

import java.util.List;

public class DeviceResponse {
	
	List<DeviceDetail> deviceList;

	public List<DeviceDetail> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<DeviceDetail> deviceList) {
		this.deviceList = deviceList;
	}
	
	public DeviceResponse(List<DeviceDetail> deviceList) {
		super();
		this.deviceList=deviceList;
	}

}
