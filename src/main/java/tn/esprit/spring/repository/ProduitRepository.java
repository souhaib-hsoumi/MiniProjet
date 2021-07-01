package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entites.Produits;

@Repository
public interface ProduitRepository  extends JpaRepository<Produits, Long> {
 @Query("select DISTINCT e from Produits e "
			+ "join e.categories m "
			+ "where m.id=:ca")
    public List<Produits> getProduitsByCategory(@Param("ca")long ca);
}
