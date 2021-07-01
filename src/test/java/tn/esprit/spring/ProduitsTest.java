package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entites.Produits;
import tn.esprit.spring.repository.ProduitRepository;
@SpringBootTest
@RunWith(SpringRunner.class) 
public class ProduitsTest {
	@Autowired
	ProduitRepository pRepo ;
	@Test
	@Order(1)
	public void testCreateProduits ( ) {
		Produits p = new Produits();
		
		p.setNom("VV");
		p.setDatecreation(Timestamp.valueOf(LocalDateTime.now()));
		
		pRepo.save(p);
		
	}
		
	@Test
	@Order(2)
	public void testReadAllProduits () {
		List<Produits> list = (List<Produits>) pRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
		
	@Test
	@Order(3)
	public void testReadProduit() {
		Produits product = pRepo.findById(16L).get();
		assertEquals("short", product.getNom());
	}
		
	@Test
	@Order(4)
	public void testUpdateProduit () {
		Produits p = pRepo.findById(16L).get();
		p.setQt(11);
		pRepo.save(p);
		assertNotEquals(7, pRepo.findById(16L).get().getQt());
	}
		
	@Test
	@Order(5)
	public void testDeleteProduits () {
		pRepo.deleteById(22L);
		assertThat(pRepo.existsById(22L)).isFalse();
	}

}
