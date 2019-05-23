package com.infotel.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.infotel.metier.Magasin;
import com.infotel.metier.Produit;
import com.infotel.metier.ProduitNonPerissable;
import com.infotel.metier.ProduitPerissable;

@Stateless
@LocalBean // afin que la dao puisse etre accessible par le WS
public class DaoImpl implements IdaoLocal, IdaoRemote {

	@PersistenceContext(unitName = "pu_ejb_ws")
	EntityManager em;

	// ++++++++++++++++++++AJOUTER++++++++++++++++++++

	@Override
	public void addMagasin(Magasin m) {
		em.persist(m);
	}

	@Override
	public void ajouterProduitNonPerissable(ProduitNonPerissable pnp) {
		em.persist(pnp);
	}

	@Override
	public void ajouterProduitPerissable(ProduitPerissable pp) {
		em.persist(pp);
	}
	
	@Override
	public void ajouterProduit(Produit p, long idMagasin) {
		Magasin m = new Magasin();
		p.setMagasin(m);
		em.persist(p);
	}

	// +++++++++++++++++++SUPPRIMER++++++++++++++++++++


	@Override
	public void supprimerMagasin(Magasin m) {

		em.remove(m);
	}

	@Override
	public long supprimerProduitNonPerissable(long idProduit) {
		Query q = null;
		try {
			q = em.createQuery("DELETE FROM Produit pnp where p.idProduit = :idpnp").setParameter("idpnp", idProduit);
			idProduit = q.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return idProduit;
	}

	@Override
	public long supprimerProduitPerissable(long idProduit) {
		Query q = null;
		try {
			q = em.createQuery("DELETE FROM Produit pp where p.idProduit = :idpp").setParameter("idpp", idProduit);
			idProduit = q.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return idProduit; 
	}
 
	// +++++++++++++++++++MODIFIER++++++++++++++++++++

	@Override
	public void modifierMagasin(Magasin m) {
		em.merge(m);
	}

	@Override
	public void modifierProduitNonPerissable(ProduitNonPerissable pnp) {
		em.merge(pnp);
	}

	@Override
	public void modifierProduitPerissable(ProduitPerissable pp) {
		em.merge(pp);
	}

	// +++++++++++++++++++GET++++++++++++++++++++

	@Override
	public Magasin getMagasin(long idMagasin) {
		return em.find(Magasin.class, idMagasin);
	}

	@Override
	public ProduitNonPerissable getProduitNonPerissable(long idProduit) {
		return em.find(ProduitNonPerissable.class, idProduit);
	}

	@Override
	public ProduitPerissable getProduitPerissable(long idProduit) {
		return em.find(ProduitPerissable.class, idProduit);
	}

	@Override
	public List<Magasin> getAllMagasin() {
		return em.createQuery("SELECT m FROM Magasin m").getResultList();
	}

	@Override
	public List<Produit> getAllProduit() {
		return em.createQuery("SELECT p FROM Produit p").getResultList();
	}

	@Override
	public List<ProduitNonPerissable> getAllProduitNonPerissable() {
		return em.createQuery("SELECT p FROM Produit p where TYPE_PROD=ProdNonPeri").getResultList();
	}

	@Override
	public List<ProduitPerissable> getAllProduitPerissable() {
		return em.createQuery("SELECT p FROM Produit p where TYPE_PROD=ProdPeri").getResultList();
	}

	@Override
	public List<Produit> getProduitParMagasin(long idMagasin) {
		return em.createQuery("SELECT p FROM Produit p WHERE p.magasin.idMagasin = :idMagasin")
				.setParameter("idMagasin", idMagasin).getResultList();
	}

	// +++++++++++++++++++CUSTOM++++++++++++++++++++
	
	@Override
	public double calculPrixMagasin(Magasin m) {
		double prixP=0;
		for(Produit p : m.getProduits()) {
			prixP = prixP + p.getPrix()*p.getStock();
		}
			
		return (prixP + m.getPrixDuLocal());
	}

}
