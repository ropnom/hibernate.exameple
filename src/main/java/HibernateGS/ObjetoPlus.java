package HibernateGS;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//Hibernate annotation, to insert the objet in the BBDD
// Anotacionde hibernate, indica que el objeto tiene que ser incluido en la BBDD
//@Table(name = "ObjetoPlus", catalog = "hibernate")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class ObjetoPlus extends ObjetoElement {

	// Fields, Variables del objeto
	protected String direccion;
	protected Date entrega;
	protected boolean stock;

	// Primary Key annotation

	public ObjetoPlus() {
		super();
	}

	public ObjetoPlus(String name, double prize) {
		super(name, prize);
	}

	public ObjetoPlus(String name, String description, double prize) {
		super(name, description, prize);
	}
	
	public void Put(String direccion, Date entrega, boolean stock){
		
		this.stock = stock;
		this.entrega = entrega;
		this.direccion = direccion;		
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getEntrega() {
		return entrega;
	}

	public void setEntrega(Date entrega) {
		this.entrega = entrega;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

}
