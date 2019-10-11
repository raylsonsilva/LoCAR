package br.com.iw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Motorista extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 10)
	private String numeroCNH;

	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}
	
}
