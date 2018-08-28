package com.zycus.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.zycus.entity.Passenger;
import com.zycus.entity.Ticket;
import com.zycus.entity.Train;
import com.zycus.service.TicketService;

public class PassengerTrainTicketTest {

	@Test
	public void createTrainTest() {
		Train train = new Train();
		train.setTrainNo(3501);
		train.setName("Shatabdi Express");
		train.setSource("Mumbai");
		train.setDestination("Ahmedabad");
		TicketService service = new TicketService();
		service.createTrains(train);
	}

	@Test
	public void ticketBookingTest() {
		TicketService service = new TicketService();
		Train train=service.fetchTrainById(3500);
		
		Ticket bookTicket = new Ticket();
		
		bookTicket.setPnr(102);
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		bookTicket.setBookingDate(date);
		bookTicket.setTrain(train);
		
		Set<Passenger> passengers = new HashSet<Passenger>(); 
		
		Passenger passenger=new Passenger();
		passenger.setName("Megha");
		passenger.setAge(22);
		
		Passenger passenger1=new Passenger();
		passenger1.setName("Diksha");
		passenger1.setAge(21);
		
		passengers.add(passenger);
		passengers.add(passenger1);
		
		service.bookTicket(bookTicket, passengers);
	}

}
