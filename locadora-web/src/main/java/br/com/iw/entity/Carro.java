package br.com.iw.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 7)
	private String placa;
	
	@Column(nullable = false, length = 20)
	private String chassi;
	
	@Column(nullable = false, length = 15)
	private String cor;
	
	@Column(nullable = false)
	private double valorDiaria;
	
	@Column(nullable = false)
	private long kilometragem;
	
	@ManyToOne
	private ModeloCarro modelo;
	
	@ManyToMany
	private Collection<Acessorio> acessorios;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public long getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(long kilometragem) {
		this.kilometragem = kilometragem;
	}

	public Collection<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Collection<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public ModeloCarro getModelo() {
		return modelo;
	}

	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}
		
}
