package HibernateRelations;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class LastUpdateListener {

	@PreUpdate
	@PrePersist
	public void setLastupdate(Objeto2 o) {
		o.setLastupdate(new Date());
	}
}