package cn.flights.service;

import java.util.List;

import cn.flights.pojo.Flights;

public interface FlightsService {
	 public List<Flights> findFlightsList(Flights flights);
}
