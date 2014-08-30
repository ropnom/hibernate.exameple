package HibernaterObject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Hibernate annotation, to insert the objet in the BBDD
// Anotacionde hibernate, indica que el objeto tiene que ser incluido en la BBDD
@Entity
public class Objeto {

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
	
	
	public Objeto() {

	}

	public Objeto(String name, double prize) {

		this.name = name;
		this.prize = prize;
		

	}

	public Objeto(String name, String description, double prize) {

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
