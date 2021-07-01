package tn.esprit.spring;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entites.Categories;
import tn.esprit.spring.repository.CategorieRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
@SpringBootTest
@RunWith(SpringRunner.class) 
public class CategoriesTest {
	@Autowired
	CategorieRepository pRepo; ;

	@Test
	@Order(1)
	public void testCreateCategories ( ) {
		Categories p = new Categories();
		
		p.setNom("VV");
		p.setDatecreation(Timestamp.valueOf(LocalDateTime.now()));
		pRepo.save(p);
		
	}
		
	@Test
	@Order(2)
	public void testReadAllCategories () {
		List<Categories> list = pRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
		
	@Test
	@Order(3)
	public void testReadCategorie () {
		Categories product = pRepo.findById(17L).get();
		assertEquals("SPORT", product.getNom());
	}
		
	@Test
	@Order(4)
	public void testUpdateCategorie () {
		Categories p = pRepo.findById(17L).get();
		p.setQt(18);
		pRepo.save(p);
		assertNotEquals(7, pRepo.findById(17L).get().getQt());
	}
		
	@Test
	@Order(5)
	public void testDeleteCategorie () {
		pRepo.deleteById(42L);
		assertThat(pRepo.existsById(42L)).isFalse();
	}

	
}
