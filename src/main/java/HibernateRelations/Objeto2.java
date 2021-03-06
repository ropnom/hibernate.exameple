package HibernateRelations;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Hibernate annotation, to insert the objet in the BBDD
// Anotacionde hibernate, indica que el objeto tiene que ser incluido en la BBDD
@Entity
//@EntityListeners( LastUpdateListener.class )
@EntityListeners( Objeto2.class )
public class Objeto2 {

	// Fields, Variables del objeto

	// Primary Key annotation
	@Id
	// Autogeneration of primarykey
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long identificator;

	@Column(nullable = false)
	protected String name;
	protected String description;
	protected double prize = 0;

	protected long owner;

	// thats annotations make the field inicializated and update with the local
	// time only for mysql
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdate", insertable = false,columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	protected Date lastupdate;

	// For update from hiberante is necesary:
	
	//DON'T WORK
	

	public Objeto2() {

	}

	public Objeto2(String name, double prize) {

		this.name = name;
		this.prize = prize;
		this.lastupdate = new Date();

	}

	public Objeto2(String name, String description, double prize) {

		this.name = name;
		this.prize = prize;
		this.description = description;
		this.lastupdate = new Date();

	}
	
	
	
	@PostUpdate
	private void someLateUpdateWorking() {
       System.out.println("REalizado un UPDATE a las: "+ new Date());
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

	public long getOwner() {
		return owner;
	}

	public void setOwner(long owner) {
		this.owner = owner;
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

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}
	

}
