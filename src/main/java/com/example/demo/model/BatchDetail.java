package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BatchDetail")
public class BatchDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String chunkID;

	@OneToMany(fetch = FetchType.EAGER,mappedBy="batchDetail",cascade = CascadeType.ALL) 
	
	private List<DeviceDetail> deviceDetail;

	@Basic
	private java.sql.Date scheduledDate;
	
	public String getChunkID() {
		return chunkID;
	}


	public void setChunkID(String chunkID) {
		this.chunkID = chunkID;
	}

    public List<DeviceDetail> getDeviceDetail() {
		return deviceDetail;
	}


	public void setDeviceDetail(List<DeviceDetail> deviceDetail) {
		this.deviceDetail = deviceDetail;
	}


	public java.sql.Date getScheduledDate() {
		return scheduledDate;
	}


	public void setScheduledDate(java.sql.Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}


	public BatchDetail() {
		super();
	}

    public BatchDetail(String chunkID,Date scheduledDate,List<DeviceDetail> deviceDetail) {
    	super();
    	this.chunkID=chunkID;
		this.scheduledDate=(java.sql.Date) scheduledDate;
		this.deviceDetail=deviceDetail;
	}


	@Override
	public String toString() {
		return "BatchDetail [chunkID=" + chunkID + ", scheduledDate=" + scheduledDate + "]";
	}

    
	
    
}
