package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BatchDetail;
import com.example.demo.model.DeviceDetail;

public interface BatachDataService  {

	void save();
	 List<BatchDetail> findAll();
	List<DeviceDetail> fetchDeviceListByChunkId(String chunkID);
	List<DeviceDetail> updateByChunkId(String chunkID);
}
