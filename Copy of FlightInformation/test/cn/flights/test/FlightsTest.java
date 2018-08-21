package cn.flights.test;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.flights.pojo.Airports;
import cn.flights.pojo.Flights;
import cn.flights.service.FlightsService;


public class FlightsTest {

    private Logger logger = Logger.getLogger(FlightsTest.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetFlightsList() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        FlightsService flightsService = (FlightsService) ctx.getBean("flightsService");
        List<Flights> flightsList = new ArrayList<Flights>();
        Flights flights1 = new Flights();
        Airports airports = new Airports();
        Airports airports1 = new Airports();
        airports.setCityName("北京");
        airports1.setCityName("吉隆波");
        flights1.setAirports(airports);
        flights1.setAirports1(airports1);
        flightsList=flightsService.findFlightsList(flights1);
        for(Flights flights:flightsList){
        	System.out.println("航空公司/航班机型:"+flights.getAirline()+"/"+flights.getType()+"\n"+
        						"起降机场:"+flights.getAirports().getAirportName()+"/"+
        						flights.getAirports().getAirportName1()+"\n"+
        						"起降时间:"+new SimpleDateFormat("HH:mm:ss").format(flights.getTakeoffTime())+"/"+new SimpleDateFormat("HH:mm:ss").format(flights.getLandingTime())+"\n"+
        						"飞行时长:"+flights.getFlightTime()+"\n"+
        						"参考价:"+flights.getReferencePrice()+"\n"+
        						"售票公司/售票价格:"+flights.getFlight_Tickets().getSellCompany()+"/"+flights.getFlight_Tickets().getTicketPrice());
        }
        
    }

}
