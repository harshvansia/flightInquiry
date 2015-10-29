package org.myflights.flights.inquiry.service;

import org.myflights.flights.inquiry.model.Flight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myflights.flights.inquiry.dao.FlightDAO;
import org.myflights.flights.inquiry.beans.FlightFilterBean;

public class FlightServiceImpl implements FlightService {
	
	FlightDAO flightDAO;

	public FlightDAO getFlightDAO() {
		return flightDAO;
	}

	public void setFlightDAO(FlightDAO flightDAO) {
		this.flightDAO = flightDAO;
	}

	@Override
	public List<Flight> getOneWayFlights(FlightFilterBean fb)
	{
		return flightDAO.findFlights(fb.getFrom(),fb.getTo(),fb.getStartDate(),fb.getNoOfPersons());
	}
	
	@Override
	public Map<String,List<Flight>> getRoundTripFlights(FlightFilterBean fb)
	{
		Map<String, List<Flight>> result = new HashMap<String, List<Flight>>();
		
		//destination flight
		result.put("destflights",flightDAO.findFlights(fb.getFrom(),fb.getTo(),fb.getStartDate(),fb.getNoOfPersons()));
		
		//return flight
		result.put("retnflights",flightDAO.findFlights(fb.getTo(),fb.getFrom(),fb.getReturnDate(),fb.getNoOfPersons()));
		
		return result;
	}	

}
