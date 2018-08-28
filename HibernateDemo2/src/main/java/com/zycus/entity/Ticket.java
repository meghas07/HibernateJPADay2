package com.zycus.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	private int pnr;
	private Date bookingDate;
	
	@ManyToOne
	@JoinColumn(name="TrainNo")
	private Train train;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pnr")
	private Set<Passenger> passengers;

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "Booking [pnr=" + pnr + ", bookingDate=" + bookingDate + "]";
	}

}
