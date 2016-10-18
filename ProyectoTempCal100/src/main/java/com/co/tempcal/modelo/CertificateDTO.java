package com.co.tempcal.modelo;

public class CertificateDTO {
	
	/**
	 * machine owner
	 */
	private String owner;
	
	/**
	 * certificate number
	 */
	private String certificateNumber;
	
	/**
	 * Machine Model
	 */
	private String machineModel;

	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getMachineModel() {
		return machineModel;
	}

	public void setMachineModel(String machineModel) {
		this.machineModel = machineModel;
	}
	
	
}
