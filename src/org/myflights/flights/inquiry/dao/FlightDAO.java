package org.myflights.flights.inquiry.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.myflights.flights.inquiry.model.Flight;

public class FlightDAO {
	
	Configuration conf = new Configuration().configure();
	SessionFactory sessionFactory=  conf.buildSessionFactory();
	Session session = sessionFactory.openSession();

	public List<Flight> findFlights(String from, String to, String date, int noOfPersons) 
	{
		List<Flight> flights = session.createCriteria(Order.class)
				.add(Restrictions.eq("from", from))
				.add(Restrictions.eq("to", to))
				.add(Restrictions.eq("date", date))
                .addOrder(Order.asc("price"))
                .list();
		return flights;
	}

}
