package cn.flights.dao;

import java.util.List;

import cn.flights.pojo.Flights;


public interface FlightsMapper {
	public List<Flights> getFlightsList(Flights flights);
}
