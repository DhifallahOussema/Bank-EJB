package tn.enis.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_compte")
public class Compte implements Serializable /* spec JEE */ {
	private static final long serialVersionUID = 1L;
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rib;
	private float solde;
//unidirectionnelle
	// fetch: LAZY --> ne se charge pas
	// EAGER --> se charge
	// default : 1 -> EAGER, * ->LAZY
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

	public Compte() {
		super();
	}

	public Compte(float solde, Client client) {
		super();
		this.solde = solde;
		this.client = client;
	}

	public Compte(Long rib, float solde, Client client) {
		super();
		this.rib = rib;
		this.solde = solde;
		this.client = client;
	}

	public Long getRib() {
		return rib;
	}

	public void setRib(Long rib) {
		this.rib = rib;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rib);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Compte other = (Compte) obj;
		return Objects.equals(rib, other.rib);
	}

	@Override
	public String toString() {
		return "Compte [rib=" + rib + ", solde=" + solde + ", client=" + client + "]";
	}

}
