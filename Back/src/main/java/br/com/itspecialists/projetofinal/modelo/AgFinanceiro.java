package br.com.itspecialists.projetofinal.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mtb310_ag_financeiro")
public class AgFinanceiro {
	
	@Column(name="id_agente")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAgente;
	
	@Column(name="nome_agente")
	private String nomeAgente;
	
	@Column(name="volume_transacional")
	private float volumeTransacional;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="agFinanceiro")
	@JsonIgnoreProperties("agFinanceiro")
	private List<Transaction> transactions;

	public AgFinanceiro() {
		super();
	}

	public AgFinanceiro(int idAgente, String nomeAgente, float volumeTransacional, List<Transaction> transactions) {
		super();
		this.idAgente = idAgente;
		this.nomeAgente = nomeAgente;
		this.volumeTransacional = volumeTransacional;
		this.transactions = transactions;
	}

	public int getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(int idAgente) {
		this.idAgente = idAgente;
	}

	public String getNomeAgente() {
		return nomeAgente;
	}

	public void setNomeAgente(String nomeAgente) {
		this.nomeAgente = nomeAgente;
	}

	public float getVolumeTransacional() {
		return volumeTransacional;
	}

	public void setVolumeTransacional(float volumeTransacional) {
		this.volumeTransacional = volumeTransacional;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "AgFinanceiro [idAgente=" + idAgente + ", nomeAgente=" + nomeAgente + ", volumeTransacional="
				+ volumeTransacional + ", transactions=" + transactions + "]";
	}


	
	
}
