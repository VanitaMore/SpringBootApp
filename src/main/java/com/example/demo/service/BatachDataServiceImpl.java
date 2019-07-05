package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.BatchDetail;
import com.example.demo.model.DeviceDetail;
import com.example.demo.repo.BatchDetailRepo;
import com.example.demo.repo.DeviceDetailRepo;

@Service(value = "batchService")
@Component
public class BatachDataServiceImpl implements BatachDataService {

	@Autowired BatchDetailRepo batchDetailRepo;
	@Autowired DeviceDetailRepo deviceDetailRepo;

	@Override
	public List<BatchDetail> findAll() {
		return (List<BatchDetail>) batchDetailRepo.findAll();
	}

	@Override
	public void save() {

		BatchDetail batchDetail= new BatchDetail();
		batchDetail.setScheduledDate(java.sql.Date.valueOf("2017-11-15"));

		BatchDetail batchDetail1= new BatchDetail();
		batchDetail1.setScheduledDate(java.sql.Date.valueOf("2017-12-15"));

		DeviceDetail deviceDetail=new DeviceDetail();
		deviceDetail.setStatusOfUpgrade(true);
		deviceDetail.setBatchDetail(batchDetail);
		deviceDetail.setBatchDetail(batchDetail1);

		DeviceDetail deviceDetail1=new DeviceDetail();
		deviceDetail1.setStatusOfUpgrade(true);
		deviceDetail1.setBatchDetail(batchDetail);
		deviceDetail.setBatchDetail(batchDetail1);

		ArrayList<DeviceDetail> batchDetailList= new ArrayList<>();

		batchDetailList.add(deviceDetail);
		batchDetailList.add(deviceDetail1);

		batchDetail.setDeviceDetail(batchDetailList);

		batchDetailRepo.save(batchDetail);
		batchDetailRepo.save(batchDetail1);

	}

	@Override
	public List<DeviceDetail> fetchDeviceListByChunkId(String chunkID) {
		BatchDetail findById = batchDetailRepo.findBatchDetailByChunkID(chunkID);
		List<DeviceDetail> list=findById.getDeviceDetail();
		return list ;
	}

	@Override
	public List<DeviceDetail> updateByChunkId(String chunkID) {

		BatchDetail findById = batchDetailRepo.findBatchDetailByChunkID(chunkID);

		List<DeviceDetail> list=findById.getDeviceDetail();
		List<DeviceDetail> saveDeviceDetails=new ArrayList <DeviceDetail>();
		for (DeviceDetail deviceDetails : list) {
			deviceDetails.setDeviceID(deviceDetails.getDeviceID());
			deviceDetails.setBatchDetail(findById);
			deviceDetails.setStatusOfUpgrade(false);
			saveDeviceDetails.add(deviceDetails);
		}

		return deviceDetailRepo.saveAll(saveDeviceDetails);

	}
}
