package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BatchDetail;
import com.example.demo.model.DeviceDetail;
import com.example.demo.model.DeviceResponse;
import com.example.demo.repo.BatchDetailRepo;
import com.example.demo.repo.DeviceDetailRepo;
import com.example.demo.service.BatachDataService;


@RestController
@RequestMapping("/bds")
public class BatachDataServiceController {

	@Autowired BatchDetailRepo batchDetail;
	@Autowired DeviceDetailRepo deviceDetail;
    @Autowired BatachDataService batchService;
	
	@GetMapping(value="/getdetails")
    public List<BatchDetail> getBatchList(){
        List<BatchDetail> findAll = batchService.findAll();
      
		return findAll;
    }

	 @PostMapping(value = "/insertBatchDetails")
	    public String  create(){
		 batchService.save();
	         return "Data Saved Successfully";
	    }
	 
	
	/*
	 * public List<DeviceDetail> fetchDeviceListById(@PathVariable(value ="chunkID")
	 * String chunkID) { return batchService.fetchDeviceListByChunkId(chunkID);
	 * 
	 * }
	 */
		 @GetMapping("/fetchDeviceList/{chunkID}")
	 public ResponseEntity<DeviceResponse> fetchDeviceListById(@PathVariable("chunkID") String chunkID) 
		 {
			List<DeviceDetail> deviceList = batchService.fetchDeviceListByChunkId(chunkID);
			return new ResponseEntity<>(new DeviceResponse(deviceList), HttpStatus.OK);

		}
	 
	 @PutMapping("/updateDevice/{chunkID}")
		public List<DeviceDetail> updateByChunkId(@PathVariable(value ="chunkID") String chunkID) {
		return  batchService.updateByChunkId(chunkID);
		}
}
