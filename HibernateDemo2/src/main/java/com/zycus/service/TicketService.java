package com.zycus.service;

import java.util.Set;

import com.zycus.dao.GenericDao;
import com.zycus.entity.Passenger;
import com.zycus.entity.Ticket;
import com.zycus.entity.Train;

public class TicketService {
	private GenericDao dao = new GenericDao();

	public void createTrains(Train train) {
		dao.add(train);

	}

	public Train fetchTrainById(int trainNo) {
		Train train = dao.fetchById(Train.class, trainNo);
		return train;

	}

	public void bookTicket(Ticket ticket, Set<Passenger> passengers) {
		ticket.setPassengers(passengers);
		dao.add(ticket);
	}

	public void newPassenger(Passenger passenger) {
		dao.add(passenger);
	}

}
