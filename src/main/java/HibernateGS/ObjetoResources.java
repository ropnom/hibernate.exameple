package HibernateGS;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Table(name = "ObjetoResources", catalog = "hibernate")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity
public class ObjetoResources extends ObjetoPlus {

	protected long Metal = 0;
	protected long Cristal = 0;
	protected long deuterio = 0;

	public ObjetoResources() {

	}

	public ObjetoResources(String name, String description, float prize, String direccion, Date entrega, boolean stock) {

		super(name, description, prize);
		Put(direccion, entrega, stock);
	}

	public long getMetal() {
		return Metal;
	}

	public void setMetal(long metal) {
		Metal = metal;
	}

	public long getCristal() {
		return Cristal;
	}

	public void setCristal(long cristal) {
		Cristal = cristal;
	}

	public long getDeuterio() {
		return deuterio;
	}

	public void setDeuterio(long deuterio) {
		this.deuterio = deuterio;
	}

	
}
