package tn.esprit.spring.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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


import tn.esprit.spring.dto.CategoriesDTO;
import tn.esprit.spring.entites.Categories;
import tn.esprit.spring.repository.CategorieRepository;
import tn.esprit.spring.service.ICategorie;
@CrossOrigin(origins = "http://localhost:59441")
@RestController
public class CategoriesController {
	@Autowired 
	ICategorie ca ;
	@Autowired
	CategorieRepository cat ;
	@Autowired 
	private ModelMapper mapper ;
	@PostMapping("/addCategories")
	@ResponseBody
	public long ajoutercategorie(@RequestBody CategoriesDTO c) {
		Categories cw  = mapper.map(c, Categories.class);
		cw.setDatecreation(Timestamp.valueOf(LocalDateTime.now()));
		
		cat.save(cw);
		return cw.getId();
 
	}
	
	@DeleteMapping("/deleteCategorieById/{ent-id}")
	public void deleteCategorieById(@PathVariable("ent-id") long cate) {
		Categories e =cat.findById(cate).orElse(null);
		 if (e != null) {
		cat.delete(e);		
	}}
	
	@PutMapping("/updatecategory/{idCat}")
	  	@ResponseBody
	  	public ResponseEntity<String> updateCategory(
	  		@RequestBody CategoriesDTO categ,@PathVariable("idCat")long idCat) {
		
		Categories cw  = mapper.map(categ, Categories.class);
		if (idCat != 0){
		Categories c = cat.findById(idCat).orElse(null);
		if (c != null){
		c.setNom(categ.getNom());
		c.setQt(categ.getQt());
		c.setDatemmodif(Timestamp.valueOf(LocalDateTime.now()));
		cat.save(c);
		cw.getId();
		}   }
		return new ResponseEntity<>("categorieupdated successfully",HttpStatus.OK);
		
		}
	 @GetMapping("/getCategoryById/{idcat}")
	    @ResponseBody
		public Categories getCategoryById(@PathVariable("idcat") long catId) {

			return ca.getCategoryById(catId);
		}
		@GetMapping(value="/listofcategory")
		@ResponseBody
		public List<Categories> getAllCategories() {
			return  cat.findAll();
		}

}
