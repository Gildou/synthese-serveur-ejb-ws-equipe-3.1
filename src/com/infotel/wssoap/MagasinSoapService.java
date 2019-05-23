package com.infotel.wssoap;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.infotel.dao.DaoImpl;
import com.infotel.metier.Magasin;
import com.infotel.metier.Produit;
import com.infotel.metier.ProduitNonPerissable;
import com.infotel.metier.ProduitPerissable;

@Stateless
@WebService
public class MagasinSoapService {
	@EJB
	private DaoImpl dao;

	public DaoImpl getDao() {
		return dao;
	}

	public void setDao(DaoImpl dao) {
		this.dao = dao;
	}
	
	//+++++++++++++++++++++++++++++++++AJOUTER++++++++++++++++++++++++++++++++++
	
	@WebMethod
	public void ajouterMagasin(
			@WebParam(name="nomMagasin")String nomMagasin,
			@WebParam(name="codeMagasin")int codeMagasin,
			@WebParam(name="prixDuLocal")double prixDuLocal) {
	
	Magasin m = new Magasin();
	m.setNomMagasin(nomMagasin);
	m.setCodeMagasin(codeMagasin);
	m.setPrixDuLocal(prixDuLocal);
	
	dao.addMagasin(m);
	}
	
	@WebMethod
	public void ajouterProduitNonPerissable(
			@WebParam(name="nomProduit")String nomProduit,
			@WebParam(name="stock")int stock,
			@WebParam(name="prix")double prix,
			@WebParam(name="modeDemploi")String modeDemploi) {
	
	ProduitNonPerissable p = new ProduitNonPerissable();
	p.setNomProduit(nomProduit);
	p.setStock(stock);
	p.setPrix(prix);
	p.setModeDemploi(modeDemploi);
	
	dao.ajouterProduitNonPerissable(p);
	}
	
	@WebMethod
	public void ajouterProduitPerissable(
			@WebParam(name="nomProduit")String nomProduit,
			@WebParam(name="stock")int stock,
			@WebParam(name="prix")double prix) {
	
	ProduitPerissable p = new ProduitPerissable();
	p.setNomProduit(nomProduit);
	p.setStock(stock);
	p.setPrix(prix);
	p.setDateLimiteUtilisation(new Date());
	
	dao.ajouterProduitPerissable(p);
	}
	
	//+++++++++++++++++++++++++++++++MODIFIER++++++++++++++++++++++++++++++++++++++++++++++

	@WebMethod
	public void modifierMagasin(
			@WebParam(name="idMagasin")long idMagasin,
			@WebParam(name="nomMagasin")String nomMagasin,
			@WebParam(name="codeMagasin")int codeMagasin,
			@WebParam(name="prixDuLocal")double prixDuLocal) {
	
	Magasin m = new Magasin();
	m.setIdMagasin(idMagasin);
	m.setNomMagasin(nomMagasin);
	m.setCodeMagasin(codeMagasin);
	m.setPrixDuLocal(prixDuLocal);
	
	dao.modifierMagasin(m);
	}
	
	@WebMethod
	public void modifierProduitNonPerissable(
			@WebParam(name="idProduit")long idProduit,
			@WebParam(name="nomProduit")String nomProduit,
			@WebParam(name="stock")int stock,
			@WebParam(name="prix")double prix,
			@WebParam(name="modeDemploi")String modeDemploi) {
	
	ProduitNonPerissable p = new ProduitNonPerissable();
	p.setIdProduit(idProduit);
	p.setNomProduit(nomProduit);
	p.setStock(stock);
	p.setPrix(prix);
	p.setModeDemploi(modeDemploi);
	
	dao.modifierProduitNonPerissable(p);
	}
	
	@WebMethod
	public void modifierProduitPerissable(
			@WebParam(name="idProduit")long idProduit,
			@WebParam(name="nomProduit")String nomProduit,
			@WebParam(name="stock")int stock,
			@WebParam(name="prix")double prix){
	
	ProduitPerissable p = new ProduitPerissable();
	p.setIdProduit(idProduit);
	p.setNomProduit(nomProduit);
	p.setStock(stock);
	p.setPrix(prix);
	p.setDateLimiteUtilisation(new Date());
	
	dao.modifierProduitPerissable(p);
	}
	
	//+++++++++++++++++++++++++++++++CALCUL PRIX MAGASIN++++++++++++++++++++++++++++++++++++++++
	
	@WebMethod
	public double calculPrixMagasin(
			@WebParam(name="idMagasin")long idMagasin) {
		
		Magasin m = new Magasin();
		m =dao.getMagasin(idMagasin);
		
		return dao.calculPrixMagasin(m);
		
	}
	
	//++++++++++++++++++++++++++++AJOUT PRODUIT MAGASIN+++++++++++++++++++++++++++++++++++++++
	@WebMethod
	public void ajouterPPMagasin(
			@WebParam(name="nomProduit")String nomProduit,
			@WebParam(name="stock")int stock,
			@WebParam(name="prix")double prix,
			@WebParam(name="idMagasin")long idMagasin) {
		
		ProduitPerissable p = new ProduitPerissable();
		p.setNomProduit(nomProduit);
		p.setStock(stock);
		p.setPrix(prix);
		p.setDateLimiteUtilisation(new Date());
		
		dao.ajouterProduit(p, idMagasin);
		
	}
	
	@WebMethod
	public void ajouterPNPMagasin(
			@WebParam(name="nomProduit")String nomProduit,
			@WebParam(name="stock")int stock,
			@WebParam(name="prix")double prix,
			@WebParam(name="modeDemploi")String modeDemploi,
			@WebParam(name="idMagasin")long idMagasin) {
		
		ProduitNonPerissable p = new ProduitNonPerissable();
		p.setNomProduit(nomProduit);
		p.setStock(stock);
		p.setPrix(prix);
		p.setModeDemploi(modeDemploi);
		
		dao.ajouterProduit(p, idMagasin);
			}
	//++++++++++++++++++++++++++++SUPPRIMER+++++++++++++++++++++++++++++++++++++++++
	@WebMethod
	public long supprimerProduitPerissable(
			@WebParam(name="idProduit") long idProduit) {
		
		return dao.supprimerProduitPerissable(idProduit);
	}
	
	@WebMethod
	public long supprimerProduitNonPerissable(
			@WebParam(name="idProduit") long idProduit) {
		
		return dao.supprimerProduitNonPerissable(idProduit);
	}
	
	@WebMethod
	public void supprimerMagasin(
			@WebParam(name="idMagasin") long idMagasin) {
		
		Magasin m = new Magasin();
		//m.setIdMagasin(idMagasin);
		m = dao.getMagasin(idMagasin);
		dao.supprimerMagasin(m);
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Lecture +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@WebMethod
	public ProduitPerissable getProduitPerissable(
			@WebParam(name="idProduit")long idProduit) {
		
		return dao.getProduitPerissable(idProduit);
	}
	@WebMethod
	public ProduitNonPerissable getProduitNonPerissable(
			@WebParam(name="idProduit")long idProduit) {
		
		return dao.getProduitNonPerissable(idProduit);
	}
	
	@WebMethod
	public Magasin getMagasin(
			@WebParam(name="idMagasin")long idMagasin) {
		
		return dao.getMagasin(idMagasin);
	}
	
	@WebMethod
	public List<Magasin> getAllMagasin(){
		
		return dao.getAllMagasin();
	}
	
	@WebMethod
	public List<Produit> getAllProduits(){
		
		return dao.getAllProduit();
	}
	@WebMethod
	public List<ProduitNonPerissable> getAllProduitsNonPerissables(){
		
		return dao.getAllProduitNonPerissable();
	}
	@WebMethod
	public List<ProduitPerissable> getAllProduitsPerissables(){
		
		return dao.getAllProduitPerissable();
	}
	
	@WebMethod
	public List<Produit> getProduitsParMagasin(
			@WebParam(name="idMagasin")long idMagasin){
		
		return dao.getProduitParMagasin(idMagasin);
	}
	
	
	}

	

