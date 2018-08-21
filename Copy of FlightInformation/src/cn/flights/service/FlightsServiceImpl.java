package cn.flights.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.flights.dao.FlightsMapper;
import cn.flights.pojo.Flights;


@Service("flightsService")
public class FlightsServiceImpl implements FlightsService {
    @Autowired 
    private FlightsMapper flightsMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Flights> findFlightsList(Flights flights) {
        try {
            return flightsMapper.getFlightsList(flights);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }


}
