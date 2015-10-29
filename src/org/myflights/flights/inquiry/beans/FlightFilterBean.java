package org.myflights.flights.inquiry.beans;


public class FlightFilterBean
{
	private String from;
	private String to;
	private String startDate;
	private String returnDate;
	private int noOfPersons;
	
	public FlightFilterBean(String from, String to, String startDate, String returnDate, int noOfPersons) {
		super();
		this.from = from;
		this.to = to;
		this.startDate = startDate;
		this.returnDate = returnDate;
		this.noOfPersons = noOfPersons;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public int getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	
	

}
