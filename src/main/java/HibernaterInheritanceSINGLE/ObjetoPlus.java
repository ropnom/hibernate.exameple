package HibernaterInheritanceSINGLE;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

//Hibernate annotation, to insert the objet in the BBDD
// Anotacionde hibernate, indica que el objeto tiene que ser incluido en la BBDD
@Entity
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
