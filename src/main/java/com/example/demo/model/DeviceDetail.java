package com.example.demo.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="DeviceDetail")
public class DeviceDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private String deviceID;
	private boolean statusOfUpgrade;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="chunkID")
	@JsonIgnore
	private BatchDetail batchDetail;
	
	public DeviceDetail()
	{
		super();
	}
	public DeviceDetail(String deviceID,boolean statusOfUpgrade,BatchDetail batchDetail) {
		super();
		this.deviceID=deviceID;
		this.statusOfUpgrade=statusOfUpgrade;
		this.batchDetail=batchDetail;
	}
	

	public BatchDetail getBatchDetail() {
		return batchDetail;
	}

	public void setBatchDetail(BatchDetail batchDetail) {
		this.batchDetail = batchDetail;
	}

	
   public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public boolean isStatusOfUpgrade() {
		return statusOfUpgrade;
	}

	public void setStatusOfUpgrade(boolean statusOfUpgrade) {
		this.statusOfUpgrade = statusOfUpgrade;
	}
	@Override
	public String toString() {
		return "DeviceDetail [deviceID=" + deviceID + ", statusOfUpgrade=" + statusOfUpgrade + ", batchDetail="
				+ batchDetail + "]";
	}

}

