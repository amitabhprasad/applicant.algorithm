package com.bg.engine.algorithm.data;

import java.util.List;

public class Employer {
	
	private String employerName;
	private String startingDate;
	private String endDate;
	
	private String reasonForDeparture;
	
	private List<Refrences> employerRefrences;

	/**
	 * @return the employerRefrences
	 */
	public List<Refrences> getEmployerRefrences() {
		return employerRefrences;
	}

	/**
	 * @param employerRefrences the employerRefrences to set
	 */
	public void setEmployerRefrences(List<Refrences> employerRefrences) {
		this.employerRefrences = employerRefrences;
	}

	/**
	 * @return the employerName
	 */
	public String getEmployerName() {
		return employerName;
	}

	/**
	 * @param employerName the employerName to set
	 */
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	/**
	 * @return the startingDate
	 */
	public String getStartingDate() {
		return startingDate;
	}

	/**
	 * @param startingDate the startingDate to set
	 */
	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the reasonForDeparture
	 */
	public String getReasonForDeparture() {
		return reasonForDeparture;
	}

	/**
	 * @param reasonForDeparture the reasonForDeparture to set
	 */
	public void setReasonForDeparture(String reasonForDeparture) {
		this.reasonForDeparture = reasonForDeparture;
	}
	
	

}
