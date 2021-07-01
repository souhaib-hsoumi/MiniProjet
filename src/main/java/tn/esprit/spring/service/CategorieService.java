package tn.esprit.spring.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entites.Categories;
import tn.esprit.spring.repository.CategorieRepository;

@Service
public class CategorieService  implements ICategorie{
	@Autowired
	CategorieRepository cat ;

	@Override
	public Categories getCategoryById (long categorieId)
	{
		return cat.getCategoryById(categorieId);
	}
}
