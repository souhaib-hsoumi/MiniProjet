package tn.esprit.spring.entites;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Categories implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nom;
	private int qt ;
	@Column(nullable = false)
    private Timestamp datecreation;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Timestamp datemmodif ;
	@OneToMany(mappedBy="categories", cascade = CascadeType.REMOVE)
	private List<Produits> listProduits;
	@Override
	public String toString() {
		return "Categories [id=" + id + ", nom=" + nom + ", qt=" + qt + ", date_creation=" + datecreation
				+ ", date_mmodif=" + datemmodif + ", list_produits=" + listProduits + "]";
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQt() {
		return qt;
	}
	public void setQt(int qt) {
		this.qt = qt;
	}
	
	public Timestamp getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Timestamp datecreation) {
		this.datecreation = datecreation;
	}
	public Timestamp getDatemmodif() {
		return datemmodif;
	}
	public void setDatemmodif(Timestamp datemmodif) {
		this.datemmodif = datemmodif;
	}
	public List<Produits> getListProduits() {
		return listProduits;
	}
	public void setListProduits(List<Produits> listProduits) {
		this.listProduits = listProduits;
	}
	public Categories(long id, String nom, int qt, Timestamp datecreation, Timestamp datemmodif,
			List<Produits> listProduits) {
		super();
		this.id = id;
		this.nom = nom;
		this.qt = qt;
		this.datecreation = datecreation;
		this.datemmodif = datemmodif;
		this.listProduits = listProduits;
	}
	public Categories() {
		super();
	}
	public Categories(String nom, int qt, Timestamp datecreation, Timestamp datemmodif, List<Produits> listProduits) {
		super();
		this.nom = nom;
		this.qt = qt;
		this.datecreation = datecreation;
		this.datemmodif = datemmodif;
		this.listProduits = listProduits;
	}
	public Categories(String nom, int qt, Timestamp datecreation, Timestamp datemmodif) {
		super();
		this.nom = nom;
		this.qt = qt;
		this.datecreation = datecreation;
		this.datemmodif = datemmodif;
	}
	public Categories(String nom) {
		super();
		this.nom = nom;
	}
	public Categories(String nom, int qt) {
		super();
		this.nom = nom;
		this.qt = qt;
	}
	public Categories(String nom, Timestamp datecreation) {
		super();
		this.nom = nom;
		this.datecreation = datecreation;
	}
	
	public Categories(String nom, int qt, Timestamp datemmodif) {
		super();
		this.nom = nom;
		this.qt = qt;
		this.datemmodif = datemmodif;
	}
}
