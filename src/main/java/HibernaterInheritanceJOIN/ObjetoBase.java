package HibernaterInheritanceJOIN;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Hibernate annotation, to insert the objet in the BBDD
// Anotacionde hibernate, indica que el objeto tiene que ser incluido en la BBDD
@Entity
@Table(name = "ObjetoBase", catalog = "hibernate")
@Inheritance(strategy=InheritanceType.JOINED)
public class ObjetoBase {

	// Fields, Variables del objeto

	// Primary Key annotation
	@Id
	// Autogeneration of primarykey
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long identificator;

	@Column(nullable=false)
	protected String name;	
	protected String description;
	protected double prize = 0;
	
	
	public ObjetoBase() {

	}

	public ObjetoBase(String name, double prize) {

		this.name = name;
		this.prize = prize;
		

	}

	public ObjetoBase(String name, String description, double prize) {

		this.name = name;
		this.prize = prize;
		this.description = description;
		
	}

	public long getIdentificator() {
		return identificator;
	}

	public void setIdentificator(long identificator) {
		this.identificator = identificator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

}
