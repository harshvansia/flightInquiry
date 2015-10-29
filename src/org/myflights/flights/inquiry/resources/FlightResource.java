package org.myflights.flights.inquiry.resources;

import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.myflights.flights.inquiry.beans.FlightFilterBean;
import org.myflights.flights.inquiry.model.Flight;
import org.myflights.flights.inquiry.module.FlightServiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import org.myflights.flights.inquiry.service.FlightService;

@Path("/flights")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FlightResource 
{
	
	Injector injector = Guice.createInjector(new FlightServiceModule());
	FlightService flightService = injector.getInstance(FlightService.class);
	
	
	@GET
	public List<Flight> getOneWayFlights(@BeanParam FlightFilterBean filterBean) {

			return flightService.getOneWayFlights(filterBean);
	}
	
	@GET
	public Map<String,List<Flight>> getRoundTripFlights(@BeanParam FlightFilterBean filterBean) {
		return flightService.getRoundTripFlights(filterBean);
	}

	
}