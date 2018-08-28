package com.zycus.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="train")
public class Train {

	@Id
	private int TrainNo;
	private String name;
	private String source;
	private String destination;

	@OneToMany(mappedBy="train" )
	private Set<Ticket> tickets;

	public int getTrainNo() {
		return TrainNo;
	}

	public void setTrainNo(int trainNo) {
		TrainNo = trainNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Train [TrainNo=" + TrainNo + ", name=" + name + ", source=" + source + ", destination=" + destination
				+ "]";
	}

}
