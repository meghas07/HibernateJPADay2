package com.zycus.entity;

import javax.persistence.*;

@Entity
@Table(name="passenger")
public class Passenger {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	
	@ManyToOne
	@JoinColumn(name="pnr")
	private Ticket ticket;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
