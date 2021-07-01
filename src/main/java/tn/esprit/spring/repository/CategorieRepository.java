package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entites.Categories;
@Repository
public interface CategorieRepository extends JpaRepository<Categories, Long> {
	
	@Query("select DISTINCT u from Categories u "
			+ "where u.id=:ca")
    public Categories getCategoryById(@Param("ca")long ca);
}
