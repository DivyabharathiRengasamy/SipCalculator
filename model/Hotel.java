package com.divi.hotelApplicationApp.model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hotel 
{
	@GeneratedValue(generator="hotel_id",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="hotel_id",sequenceName = "hotel_id")
	private Integer hotelId;
	private String hotelName;
	@OneToOne
	private Address address;
	@OneToMany
	private Set<Menu> menuList;
	
	private Set<DeliveryPartners>deliveryList;
	
	public Hotel(String hotelName, Address address, Set<Menu> menuList, Set<DeliveryPartners> deliveryList) {
		super();
		this.hotelName = hotelName;
		this.address = address;
		this.menuList = menuList;
		this.deliveryList = deliveryList;
	}
	

}
