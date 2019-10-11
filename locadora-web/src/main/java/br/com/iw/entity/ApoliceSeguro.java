package br.com.iw.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApoliceSeguro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private double valorFranquia;
	
	@Column(nullable = false)
	private boolean protecaoTerceiro;
	
	@Column(nullable = false)
	private boolean protecaoCausasNaturais;
	
	@Column(nullable = false)
	private boolean protecaoRoubo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValorFranquia() {
		return valorFranquia;
	}

	public void setValorFranquia(double valorFranquia) {
		this.valorFranquia = valorFranquia;
	}

	public boolean isProtecaoTerceiro() {
		return protecaoTerceiro;
	}

	public void setProtecaoTerceiro(boolean protecaoTerceiro) {
		this.protecaoTerceiro = protecaoTerceiro;
	}

	public boolean isProtecaoCausasNaturais() {
		return protecaoCausasNaturais;
	}

	public void setProtecaoCausasNaturais(boolean protecaoCausasNaturais) {
		this.protecaoCausasNaturais = protecaoCausasNaturais;
	}

	public boolean isProtecaoRoubo() {
		return protecaoRoubo;
	}

	public void setProtecaoRoubo(boolean protecaoRoubo) {
		this.protecaoRoubo = protecaoRoubo;
	}

}
