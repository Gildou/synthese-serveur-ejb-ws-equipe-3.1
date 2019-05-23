package com.infotel.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ProdNonPeri")
public class ProduitNonPerissable extends Produit{

	private String modeDemploi;

	public String getModeDemploi() {
		return modeDemploi;
	}

	public void setModeDemploi(String modeDemploi) {
		this.modeDemploi = modeDemploi;
	}

	@Override
	public String toString() {
		return "ProduitNonPerissable [modeDemploi=" + modeDemploi + "]";
	}
	
	
}
