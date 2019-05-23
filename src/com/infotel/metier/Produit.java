package com.infotel.metier;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PROD")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ProduitPerissable.class,ProduitNonPerissable.class})
public abstract class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduit;
	protected String nomProduit;
	protected int stock;
	protected double prix;
	@ManyToOne
	protected Magasin magasin;
	
	public long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Magasin getMagasin() {
		return magasin;
	}
	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", stock=" + stock + ", prix=" + prix
				+ ", magasin=" + magasin + "]";
	}
	
	
}
