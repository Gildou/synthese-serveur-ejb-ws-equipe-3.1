package com.infotel.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.infotel.dao.IdaoRemote;
import com.infotel.metier.Magasin;
import com.infotel.metier.Produit;
import com.infotel.metier.ProduitNonPerissable;
import com.infotel.metier.ProduitPerissable;

@Stateless(name="ejbMagasin")
public class MagasinEjbImpl implements IMagasinLocal, IMagasinRemote {
	@EJB
	private IdaoRemote dao;
	

	public IdaoRemote getDao() {
		return dao;
	}

	public void setDao(IdaoRemote dao) {
		this.dao = dao;
	}

	@Override
	public void addMagasin(Magasin m) {
		// TODO Auto-generated method stub
		dao.addMagasin(m);

	}

	@Override
	public void ajouterProduitNonPerissable(ProduitNonPerissable pnp) {
		// TODO Auto-generated method stub
		dao.ajouterProduitNonPerissable(pnp);

	}

	@Override
	public void ajouterProduitPerissable(ProduitPerissable pp) {
		// TODO Auto-generated method stub
		dao.ajouterProduitPerissable(pp);

	}

	@Override
	public void ajouterProduit(Produit p, long idMagasin) {
		// TODO Auto-generated method stub
		dao.ajouterProduit(p, idMagasin);

	}

	@Override
	public void supprimerMagasin(Magasin m) {
		// TODO Auto-generated method stub
		dao.supprimerMagasin(m);

	}

	@Override
	public long supprimerProduitNonPerissable(long idProduit) {
		// TODO Auto-generated method stub
		return dao.supprimerProduitNonPerissable(idProduit);
	}

	@Override
	public long supprimerProduitPerissable(long idProduit) {
		// TODO Auto-generated method stub
		return dao.supprimerProduitPerissable(idProduit);
	}

	@Override
	public void modifierMagasin(Magasin m) {
		// TODO Auto-generated method stub
		dao.modifierMagasin(m);
	}

	@Override
	public void modifierProduitNonPerissable(ProduitNonPerissable pnp) {
		// TODO Auto-generated method stub
		dao.modifierProduitNonPerissable(pnp);
	}

	@Override
	public void modifierProduitPerissable(ProduitPerissable pp) {
		// TODO Auto-generated method stub
		dao.modifierProduitPerissable(pp);
	}

	@Override
	public Magasin getMagasin(long idMagasin) {
		// TODO Auto-generated method stub
		return dao.getMagasin(idMagasin);
	}

	@Override
	public ProduitNonPerissable getProduitNonPerissable(long idProduit) {
		// TODO Auto-generated method stub
		return dao.getProduitNonPerissable(idProduit);
	}

	@Override
	public ProduitPerissable getProduitPerissable(long idProduit) {
		// TODO Auto-generated method stub
		return dao.getProduitPerissable(idProduit);
	}

	@Override
	public List<Magasin> getAllMagasin() {
		// TODO Auto-generated method stub
		return dao.getAllMagasin();
	}

	@Override
	public List<Produit> getAllProduit() {
		// TODO Auto-generated method stub
		return dao.getAllProduit();
	}

	@Override
	public List<ProduitNonPerissable> getAllProduitNonPerissable() {
		// TODO Auto-generated method stub
		return dao.getAllProduitNonPerissable();
	}

	@Override
	public List<ProduitPerissable> getAllProduitPerissable() {
		// TODO Auto-generated method stub
		return dao.getAllProduitPerissable();
	}

	@Override
	public List<Produit> getProduitParMagasin(long idMagasin) {
		// TODO Auto-generated method stub
		return dao.getProduitParMagasin(idMagasin);
	}

	@Override
	public double calculPrixMagasin(Magasin m) {
		// TODO Auto-generated method stub
		return dao.calculPrixMagasin(m);
	}

}
