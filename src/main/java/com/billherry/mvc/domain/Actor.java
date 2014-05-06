package com.billherry.mvc.domain;

import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "actor")
@Access(AccessType.FIELD)
public class Actor {	
	@Id
	@Column(name = "actor_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "first_name", unique = false, nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "last_name", unique = false, nullable = false, length = 50)
	private String lastName;
	
	@Column(name = "last_update", unique = false, nullable = false, length = 50)
	private Date lastUpdate;
	
	@Override
	public String toString() {		
		return String.format("id:%s , Name: %s %s", this.id,this.firstName,this.lastName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	} 
}
