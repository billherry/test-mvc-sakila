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
	private Long actor_id;
	
	@Column(name = "first_name", unique = false, nullable = false, length = 50)
	private String first_name;
	
	@Column(name = "last_name", unique = false, nullable = false, length = 50)
	private String last_name;
	
	@Column(name = "last_update", unique = false, nullable = false, length = 50)
	private Date last_update;
	
	@Override
	public String toString() {		
		return String.format("id:%s , Name: %s %s", this.actor_id,this.first_name,this.last_name);
	}

	public Long getActor_id() {
		return actor_id;
	}

	public void setActor_id(Long actor_id) {
		this.actor_id = actor_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
}
