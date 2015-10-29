package org.myflights.flights.inquiry.service;

import java.util.List;
import java.util.Map;

import org.myflights.flights.inquiry.beans.FlightFilterBean;
import org.myflights.flights.inquiry.model.Flight;

public interface FlightService 
{
	public List<Flight> getOneWayFlights(FlightFilterBean fB);
	public Map<String,List<Flight>> getRoundTripFlights(FlightFilterBean filterBean);

}
