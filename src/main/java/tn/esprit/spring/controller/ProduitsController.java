package tn.esprit.spring.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dto.ProduitsDTO;
import tn.esprit.spring.entites.Categories;
import tn.esprit.spring.entites.Produits;
import tn.esprit.spring.repository.CategorieRepository;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.service.IProduit;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProduitsController {
	@Autowired 
	IProduit pr ;
	@Autowired
	ProduitRepository prod ;
	@Autowired
	CategorieRepository cc ;
	@Autowired 
	private ModelMapper mapper ;
	
	@PostMapping("/addprod/{cat-id}")
	@ResponseBody
	public long ajoutercategorie(@RequestBody ProduitsDTO pro , @PathVariable("cat-id") long idc) {
		
		Produits cw  = mapper.map(pro, Produits.class);
		Categories catId = cc.findById(idc).orElse(null);
		cw.setDatecreation(Timestamp.valueOf(LocalDateTime.now()));
		cw.setCategories(catId);
		prod.save(cw);
		return cw.getId();
	}
	@PostMapping("/addprods/{cat-id}")
	@ResponseBody
	public long ajoutercategories(@RequestBody ProduitsDTO pro ) {
		Produits cw  = mapper.map(pro, Produits.class);
		cw.setDatecreation(Timestamp.valueOf(LocalDateTime.now()));
		
		prod.save(cw);
		return cw.getId();
	}
	
	
	@DeleteMapping("/deleteproduitById/{prod-id}")
	public void deleteCategorieById(@PathVariable("prod-id") long idp) {
		Produits e =prod.findById(idp).orElse(null);
		 if (e != null) {

		prod.delete(e);	
	}}
	
	@PutMapping("/updateProduit/{idp}")
  	@ResponseBody
  	public ResponseEntity<String> updateCategory(
  			
  		@RequestBody ProduitsDTO p,@PathVariable("idp")long idp) {
		Produits cw  = mapper.map(p, Produits.class);
		if (idp != 0) {
		Optional<Produits> x=prod.findById(idp);
		if (x.isPresent()){
		Produits ca=x.get();
		
		 
		if (ca != null){
		ca.setNom(p.getNom());
		ca.setQt(p.getQt());
		ca.setDisponible(p.isDisponible());
		ca.setDatemodif(Timestamp.valueOf(LocalDateTime.now()));
		prod.save(ca);
		cw.getId();
		}}}
  	    return new ResponseEntity<>("Product updated successfully",HttpStatus.OK);
		
	}
	@GetMapping(value="/listProdByCategory/{catId}")
	@ResponseBody
	public List<Produits> getProduitsByCategory(@PathVariable("catId")long catId) {
		return pr.getProduitsByCategory(catId);
	}
	@GetMapping(value="/listofproduct")
	@ResponseBody
	public List<Produits> getAllProduits() {
		return  prod.findAll();
	}
}
