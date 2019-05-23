package com.infotel.wsrest;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.infotel.dao.DaoImpl;
import com.infotel.metier.Magasin;
import com.infotel.metier.Produit;
import com.infotel.metier.ProduitNonPerissable;
import com.infotel.metier.ProduitPerissable;

@Stateless
@Path(value = "/magasins")
public class MagasinRestService {

	@EJB
	private DaoImpl dao;

	public DaoImpl getDao() {
		return dao;
	}

	public void setDao(DaoImpl dao) {
		this.dao = dao;
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Ajouter +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@GET
	@Path("ajouterMagasin/{nomMagasin}/{codeMagasin}/{prixDuLocal}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterMagasin(
			@PathParam(value="nomMagasin")String nomMagasin,
			@PathParam(value="codeMagasin")int codeMagasin,
			@PathParam(value="prixDuLocal")double prixDuLocal) {
	
	Magasin m = new Magasin();
	m.setNomMagasin(nomMagasin);
	m.setCodeMagasin(codeMagasin);
	m.setPrixDuLocal(prixDuLocal);
	
		dao.addMagasin(m);
	}
	
	@GET
	@Path("ajouterProduitNonPerissable/{nomProduit}/{stock}/{prix}/{modeDemploi}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterProduitNonPerissable(
			@PathParam(value="nomProduit")String nomProduit,
			@PathParam(value="stock")int stock,
			@PathParam(value="prix")double prix,
			@PathParam(value="modeDemploi")String modeDemploi) {
	
	ProduitNonPerissable p = new ProduitNonPerissable();
	p.setNomProduit(nomProduit);
	p.setStock(stock);
	p.setPrix(prix);
	p.setModeDemploi(modeDemploi);
	
	dao.ajouterProduitNonPerissable(p);
	}
	
	@GET
	@Path("ajouterProduitPerissable/{nomProduit}/{stock}/{prix}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterProduitPerissable(
			@PathParam(value="nomProduit")String nomProduit,
			@PathParam(value="stock")int stock,
			@PathParam(value="prix")double prix){
	
	ProduitPerissable p = new ProduitPerissable();
	p.setNomProduit(nomProduit);
	p.setStock(stock);
	p.setPrix(prix);
	p.setDateLimiteUtilisation(new Date());
	
	dao.ajouterProduitPerissable(p);
	}
	
	@GET
	@Path("ajouterPPMagasin/{nomProduit}/{stock}/{prix}/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterPPMagasin(
			@PathParam(value="nomProduit")String nomProduit,
			@PathParam(value="stock")int stock,
			@PathParam(value="prix")double prix,
			@PathParam(value="idMagasin")long idMagasin) {
		
		ProduitPerissable p = new ProduitPerissable();
		p.setNomProduit(nomProduit);
		p.setStock(stock);
		p.setPrix(prix);
		p.setDateLimiteUtilisation(new Date());
		
		dao.ajouterProduit(p, idMagasin);
		
	}
	
	@GET
	@Path("ajouterPNPMagasin/{nomProduit}/{stock}/{prix}/{modeDemploi}/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterPNPMagasin(
			@PathParam(value="nomProduit")String nomProduit,
			@PathParam(value="stock")int stock,
			@PathParam(value="prix")double prix,
			@PathParam(value="modeDemploi")String modeDemploi,
			@PathParam(value="idMagasin")long idMagasin) {
		
		ProduitNonPerissable p = new ProduitNonPerissable();
		p.setNomProduit(nomProduit);
		p.setStock(stock);
		p.setPrix(prix);
		p.setModeDemploi(modeDemploi);
		
		dao.ajouterProduit(p, idMagasin);
			}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Modifier ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@GET
	@Path("modifierMagasin/{idMagasin}/{nomMagasin}/{codeMagasin}/{prixDuLocal}")
	@Produces(MediaType.APPLICATION_JSON)
	public void modifierMagasin(
			@PathParam(value="idMagasin")long idMagasin,
			@PathParam(value="nomMagasin")String nomMagasin,
			@PathParam(value="codeMagasin")int codeMagasin,
			@PathParam(value="prixDuLocal")double prixDuLocal) {
	
	Magasin m = new Magasin();
	m.setIdMagasin(idMagasin);
	m.setNomMagasin(nomMagasin);
	m.setCodeMagasin(codeMagasin);
	m.setPrixDuLocal(prixDuLocal);
	
	dao.modifierMagasin(m);
	}
	
	@GET
	@Path("modifierProduitNonPerissable/{idProduit}/{nomProduit}/{stock}/{prix}/{modeDemploi}")
	@Produces(MediaType.APPLICATION_JSON)
	public void modifierProduitNonPerissable(
			@PathParam(value="idProduit")long idProduit,
			@PathParam(value="nomProduit")String nomProduit,
			@PathParam(value="stock")int stock,
			@PathParam(value="prix")double prix,
			@PathParam(value="modeDemploi")String modeDemploi) {
	
	ProduitNonPerissable p = new ProduitNonPerissable();
	p.setIdProduit(idProduit);
	p.setNomProduit(nomProduit);
	p.setStock(stock);
	p.setPrix(prix);
	p.setModeDemploi(modeDemploi);
	
	dao.modifierProduitNonPerissable(p);
	}
	
	@GET
	@Path("modifierProduitPerissable/{idProduit}/{nomProduit}/{stock}/{prix}")
	@Produces(MediaType.APPLICATION_JSON)
	public void modifierProduitPerissable(
			@PathParam(value="idProduit")long idProduit,
			@PathParam(value="nomProduit")String nomProduit,
			@PathParam(value="stock")int stock,
			@PathParam(value="prix")double prix){
	
	ProduitPerissable p = new ProduitPerissable();
	p.setIdProduit(idProduit);
	p.setNomProduit(nomProduit);
	p.setStock(stock);
	p.setPrix(prix);
	p.setDateLimiteUtilisation(new Date());
	
	dao.modifierProduitPerissable(p);
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Supprimer +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@GET
	@Path("supprProduitPerissable/{idProduit}")
	@Produces(MediaType.APPLICATION_JSON)
	public long supprimerProduitPerissable(
			@PathParam(value="idProduit") long idProduit) {
		
		return dao.supprimerProduitPerissable(idProduit);
	}
	@GET
	@Path("supprProduitNonPerissable/{idProduit}")
	@Produces(MediaType.APPLICATION_JSON)
	public long supprimerProduitNonPerissable(
			@PathParam(value="idProduit") long idProduit) {
		
		return dao.supprimerProduitNonPerissable(idProduit);
	}
	@GET
	@Path("supprMagasin/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
	public void supprimerMagasin(
			@PathParam(value="idMagasin") long idMagasin) {
		
		Magasin m = new Magasin();
		//m.setIdMagasin(idMagasin);
		m = dao.getMagasin(idMagasin);
		dao.supprimerMagasin(m);
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Calcul de prix +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@GET
	@Path("calculPrixMagasin/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
	public double calculPrixMagasin(
			@PathParam(value="idMagasin")long idMagasin) {
		
		Magasin m = new Magasin();
		m =dao.getMagasin(idMagasin);
		
		return dao.calculPrixMagasin(m);
		
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Lecture +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@GET
	@Path("getProduitPerissable/{idProduit}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProduitPerissable getProduitPerissable(
			@PathParam(value="idProduit")long idProduit) {
		
		return dao.getProduitPerissable(idProduit);
	}
	@GET
	@Path("getProduitNonPerissable/{idProduit}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProduitNonPerissable getProduitNonPerissable(
			@PathParam(value="idProduit")long idProduit) {
		
		return dao.getProduitNonPerissable(idProduit);
	}
	
	@GET
	@Path("getMagasin/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Magasin getMagasin(
			@PathParam(value="idMagasin")long idMagasin) {
		
		return dao.getMagasin(idMagasin);
	}
	
	@GET
	@Path("allMagasins")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Magasin> getAllMagasin(){
		
		return dao.getAllMagasin();
	}
	
	@GET
	@Path("allProduits")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getAllProduits(){
		
		return dao.getAllProduit();
	}
	@GET
	@Path("allProduitsNonPerissables")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProduitNonPerissable> getAllProduitsNonPerissables(){
		
		return dao.getAllProduitNonPerissable();
	}
	@GET
	@Path("allProduitsPerissables")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProduitPerissable> getAllProduitsPerissables(){
		
		return dao.getAllProduitPerissable();
	}
	
	@GET
	@Path("ProduitsParMagasin/{idMagasin}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getProduitsParMagasin(
			@PathParam(value="idMagasin")long idMagasin){
		
		return dao.getProduitParMagasin(idMagasin);
	}
}
