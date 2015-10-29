package org.myflights.flights.inquiry.module;

import org.myflights.flights.inquiry.service.FlightService;
import org.myflights.flights.inquiry.service.FlightServiceImpl;

import com.google.inject.AbstractModule;

public class FlightServiceModule  extends AbstractModule{

	@Override
	protected void configure() 
	{
		bind(FlightService.class).to(FlightServiceImpl.class);		
	}

}
