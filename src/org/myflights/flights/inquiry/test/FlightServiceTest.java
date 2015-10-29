package org.myflights.flights.inquiry.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.myflights.flights.inquiry.beans.FlightFilterBean;
import org.myflights.flights.inquiry.dao.FlightDAO;
import org.myflights.flights.inquiry.model.Flight;
import org.myflights.flights.inquiry.module.FlightServiceModule;
import org.myflights.flights.inquiry.service.FlightService;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class FlightServiceTest 
{
	private FlightDAO mockDao;
	private FlightService service;		
	
	
	@Before
 	public void setUp()
    {
		Injector injector = Guice.createInjector(new FlightServiceModule());
		service = injector.getInstance(FlightService.class);
	
        mockDao = mock(FlightDAO.class);
        //service.setFlightDAO(mockDao);       
    }
	
	@Test
    public void getOneWayFlights()
    {
    	List<Flight> dummyFlights = new ArrayList<Flight>();
    	List<Flight> flights= new ArrayList<Flight>();
    	FlightFilterBean fB =  new FlightFilterBean("Orlando","NewYork","12/12/2015","12/15/2015",2);
         
    	dummyFlights.add(new Flight(1273L,"Orlando","NewYork",new Date(),3,40,200,0));
    	dummyFlights.add(new Flight(1583L,"Orlando","NewYork",new Date(),3,20,220,1));
    	dummyFlights.add(new Flight(1633L,"Orlando","NewYork",new Date(),4,60,280,0));
    	
    	when(mockDao.findFlights(anyString(),anyString(),anyString(),anyInt())).thenReturn(dummyFlights);
    	
  		flights = service.getOneWayFlights(fB);
  		
  		verify(mockDao,times(1)).findFlights(anyString(),anyString(),anyString(),anyInt());  		
        assertEquals(flights.size(), 3);
    }

}
