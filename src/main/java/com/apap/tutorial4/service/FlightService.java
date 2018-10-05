package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;

public interface FlightService {
	void addFlight(FlightModel flight);
	FlightModel getFlightDetailByFlightNumber(String flightNumber);
	FlightModel getFlightDetailById(long id);
	void deleteFlight (FlightModel flight);
	List <FlightModel> getFlightList();
	void updateFlight(FlightModel flight, long id);
	

}
