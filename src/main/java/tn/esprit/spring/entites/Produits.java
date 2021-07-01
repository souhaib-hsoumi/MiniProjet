package tn.esprit.spring.entites;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Produits  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nom;
	private int qt ;
	private boolean disponible ;
	@Column(nullable = false)
    private Timestamp datecreation;
	@JsonIgnore
	@JsonFormat(pattern="yyyy-MM-dd")
	private Timestamp datemodif ;
	@JsonIgnore
	@ManyToOne
	private Categories  categories;

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

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Timestamp getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Timestamp datecreation) {
		this.datecreation = datecreation;
	}

	public Timestamp getDatemodif() {
		return datemodif;
	}

	public void setDatemodif(Timestamp datemodif) {
		this.datemodif = datemodif;
	}

	@Override
	public String toString() {
		return "Produits [id=" + id + ", nom=" + nom + ", qt=" + qt + ", disponible=" + disponible + ", date_creation="
				+ datecreation + ", date_modif=" + datemodif + ", categories=" + categories + "]";
	}

	public Produits(long id, String nom, int qt, boolean disponible, Timestamp datecreation, Timestamp datemodif,
			Categories categories) {
		super();
		this.id = id;
		this.nom = nom;
		this.qt = qt;
		this.disponible = disponible;
		this.datecreation = datecreation;
		this.datemodif = datemodif;
		this.categories = categories;
	}

	public Produits() {
		super();
	}

	public Produits(String nom, int qt, boolean disponible, Timestamp datecreation, Timestamp datemodif,
			Categories categories) {
		super();
		this.nom = nom;
		this.qt = qt;
		this.disponible = disponible;
		this.datecreation = datecreation;
		this.datemodif = datemodif;
		this.categories = categories;
	}
	
	
	
	
}
