package com.co.tempcal.modelo;

public class CertificadoDTO {
	
	/**
	 * Propietario de la Maquina
	 */
	private String owner;
	
	/**
	 * Numero del Certificado
	 */
	private String certificateNumber;
	
	/**
	 * Modelo de la Maquina
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
