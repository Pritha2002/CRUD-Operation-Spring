package com.persistent.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cName;
	private String cAddr;
	private Double pAmt;
	private Double intrAmt;
	private Double roi;
	private Double time;
	private String newName;
	private String newAddr;
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcAddr() {
		return cAddr;
	}
	public void setcAddr(String cAddr) {
		this.cAddr = cAddr;
	}
	public Double getpAmt() {
		return pAmt;
	}
	public void setpAmt(Double pAmt) {
		this.pAmt = pAmt;
	}
	public Double getIntrAmt() {
		return intrAmt;
	}
	public void setIntrAmt(Double intrAmt) {
		this.intrAmt = intrAmt;
	}
	public Double getRoi() {
		return roi;
	}
	public void setRoi(Double roi) {
		this.roi = roi;
	}
	public Double getTime() {
		return time;
	}
	public void setTime(Double time) {
		this.time = time;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getNewAddr() {
		return newAddr;
	}
	public void setNewAddr(String newAddr) {
		this.newAddr = newAddr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
