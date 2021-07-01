package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entites.Produits;
import tn.esprit.spring.repository.CategorieRepository;
import tn.esprit.spring.repository.ProduitRepository;



@Service
public class ProduitService  implements IProduit{
	@Autowired
	ProduitRepository prod ;
	@Autowired
	CategorieRepository cc ;

	@Override
	public List <Produits> getProduitsByCategory (long catId)
	{
		return   prod.getProduitsByCategory(catId) ;
	}

}
