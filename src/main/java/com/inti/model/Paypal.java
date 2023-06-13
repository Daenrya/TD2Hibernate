package com.inti.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Paypal extends Payment {

	private int numeroPaypal;

	public Paypal(int numero) {
		super();
		this.numeroPaypal = numero;
	}

	public Paypal(double montant, LocalDate dateP, int numero) {
		super(montant, dateP);
		this.numeroPaypal = numero;
	}

	public Paypal(int id, double montant, LocalDate dateP, int numero) {
		super(id, montant, dateP);
		this.numeroPaypal = numero;
	}

	public int getNumeroPaypal() {
		return numeroPaypal;
	}

	public void setNumeroPaypal(int numero) {
		this.numeroPaypal = numero;
	}

	@Override
	public String toString() {
		return "Paypal [numero=" + numeroPaypal + ", id=" + id + ", montant=" + montant + ", dateP=" + dateP + "]";
	}
	
	
	
}
