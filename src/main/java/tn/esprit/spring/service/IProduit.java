package tn.esprit.spring.service;
import java.util.List;
import tn.esprit.spring.entites.Produits;

public interface IProduit {

	public List <Produits> getProduitsByCategory (long catId) ;
}
