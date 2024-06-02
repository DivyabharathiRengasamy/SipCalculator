package com.divi.hotelApplicationApp.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Address 

{	
	@GeneratedValue(generator="add_id",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="add_id",sequenceName = "address_id")
	private Integer addressId;
	private String city;
	private Long zipCode;
	private String  state;
	public Address(String city, Long zipCode, String state) {
		super();
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Address [city=" + city + ", zipCode=" + zipCode + ", state=" + state + "]";
	}
}
