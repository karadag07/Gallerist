package com.karadag.galeri.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "saled_car", uniqueConstraints = { @UniqueConstraint(columnNames = { "gallerist_id", "car_id",
		"customer_id" }, name = "uq_gallerist_car_customer") })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SaledCar extends BaseEntity {

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Gallerist gallerist;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Car car;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Customer customer;
}
