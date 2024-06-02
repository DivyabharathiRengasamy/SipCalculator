package com.divi.hotelApplicationApp.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class DeliveryPartners {
	
	@GeneratedValue(generator="delivery_id",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="delivery_id",sequenceName = "delivery_id")
	private Integer deliveryId;
	private String deliveryPartnerName;
	private double deliveryCharges;
	@ManyToMany(mappedBy = "deliveryList")
	private Set<Hotel>hotelList=new HashSet<>();
	
	public DeliveryPartners(String deliveryPartnerName, double deliveryCharges) {
		super();
		this.deliveryPartnerName = deliveryPartnerName;
		this.deliveryCharges = deliveryCharges;
	}
	@Override
	public String toString() {
		return "DeliveryPartners [deliveryPartnerName=" + deliveryPartnerName + ", deliveryCharges=" + deliveryCharges
				+ "]";
	}
	

}
