package com.inti.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class CB extends Payment {
	private long numeroCB;
	private LocalDate dateE;
	
	public CB() {
		super();
	}

	public CB(double montant, LocalDate dateP, long numero, LocalDate dateE) {
		super(montant, dateP);
		this.numeroCB = numero;
		this.dateE = dateE;
	}

	public CB(int id, double montant, LocalDate dateP, long numero, LocalDate dateE) {
		super(id, montant, dateP);
		this.numeroCB = numero;
		this.dateE = dateE;
	}

	public long getNumeroCB() {
		return numeroCB;
	}

	public void setNumeroCB(long numero) {
		this.numeroCB = numero;
	}

	public LocalDate getDateE() {
		return dateE;
	}

	public void setDateE(LocalDate dateE) {
		this.dateE = dateE;
	}

	@Override
	public String toString() {
		return "CB [numero=" + numeroCB + ", dateE=" + dateE + ", id=" + id + ", montant=" + montant + ", dateP=" + dateP
				+ "]";
	}

	
	
}
