package HibernateRelations;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import HibernaterObject.Objeto;

public class CreateDatabase {

	public static void main(String[] args) {
		System.out.println("ARRANCOOO\n\n\n\n\n***********\n\n\n\n\n***********\n\n\n\n\n***********");
		Arranque();
	}

	public static void Arranque() {

		// Creamos las tablas
		AnnotationConfiguration config = new AnnotationConfiguration();

		config.addAnnotatedClass(Owner.class);
		config.addAnnotatedClass(Objeto.class);
		config.addAnnotatedClass(Objeto2.class);

		config.configure();

		new SchemaExport(config).create(true, true);

		// Session sesion = factory.getCurrentSession();

		LLenardatabase(config);
		UpdateDDBB(config);

	}

	private static void LLenardatabase(AnnotationConfiguration config) {

		SessionFactory factory = config.buildSessionFactory();
		Session sesion = factory.openSession();
		sesion.beginTransaction();

		// Create objeto
		Objeto obj = new Objeto("Mesa", "Sirve como estructura basica para proceos humanso como comidas o escritura", 60.80);
		Objeto obj2 = new Objeto("Silla", "Sirve como estructura basica para sentarse", 20.80);

		Objeto2 obj3 = new Objeto2("Coche", "Sirve como medio de trnasporte individual", 9000);
		Objeto2 obj4 = new Objeto2("Casa", "Sirve como estructura basica para vivir y sobrevivir mas confortablemente que a la intemperie", 150000);

		Owner owner = new Owner("Rodrigo", "Sampedro Casis", 23);

		// Save objeto in DDBB

		// firts save root objects, then tree objects
		sesion.save(owner);

		sesion.save(obj);
		sesion.save(obj2);
		// add objets to owner
		owner.AddObjeto(obj);
		owner.AddObjeto(obj2);

		// push identificator table
		obj3.setOwner(owner.getIdentificator());
		obj4.setOwner(owner.getIdentificator());

		sesion.save(obj3);
		sesion.save(obj4);
		// add objet2s to owner
		owner.AddObjeto2(obj3);
		owner.AddObjeto2(obj4);

		System.out.println();
		System.out.println("Identificacion: " + obj.getIdentificator() + " Nombre: " + obj.getName() + " Descripcion: " + obj.getDescription() + " Precio: " + obj.getPrize());
		System.out.println("Identificacion: " + obj2.getIdentificator() + " Nombre: " + obj2.getName() + " Descripcion: " + obj2.getDescription() + " Precio: " + obj2.getPrize());
		System.out.println("Identificacion: " + obj3.getIdentificator() + " Nombre: " + obj3.getName() + " Descripcion: " + obj3.getDescription() + " Precio: " + obj3.getPrize() + " LastUpdate: " + obj3.getLastupdate());
		System.out.println("Identificacion: " + obj4.getIdentificator() + " Nombre: " + obj4.getName() + " Descripcion: " + obj4.getDescription() + " Precio: " + obj4.getPrize() + " LastUpdate: " + obj4.getLastupdate());
		System.out.println();

		// Update owner
		sesion.update(owner);

		obj3.setPrize(10000);

		// make change DDBB

		sesion.getTransaction().commit();
		// sesion.close();
		System.out.println("/****************** FIN");
		sesion.close();

	}

	private static void UpdateDDBB(AnnotationConfiguration config) {

		System.out.println();
		System.out.println("/****************** UPDATE");
		// wait to see the change in lastupdate obj3
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		SessionFactory factory = config.buildSessionFactory();
		Session sesion = factory.openSession();
		sesion.beginTransaction();

		// Search

		Query q = sesion.createQuery("from Objeto2 where identificator = 1");
		Objeto2 obj2 = (Objeto2) q.uniqueResult();

		if (obj2 != null) {
			// change objeto propierties
			obj2.setPrize(12.50);
			obj2.setDescription("Estructura de madera o aluminio normlamente planificada para que una persona se siente.Mod");
			sesion.update(obj2);
			sesion.getTransaction().commit();
			System.out.println("Identificacion: " + obj2.getIdentificator() + " Nombre: " + obj2.getName() + " Descripcion: " + obj2.getDescription() + " Precio: " + obj2.getPrize()+" Lastupdate: "+ obj2.getLastupdate());

			
		}

		q = sesion.createQuery("from Owner where identificator = 1");
		Owner owner = (Owner) q.uniqueResult();
		System.out.println("Nombre: " + owner.getName() + " Identificator: " + owner.getIdentificator() + " Objetos: " + owner.getMyobjectsList().size() + " Objetos2: " + owner.getMyobject2sList().size());

		for (int i = 0; i < owner.getMyobjectsList().size(); i++) {

			System.out.println("Identificacion: " + owner.getMyobjectsList().get(i).getIdentificator() + " Nombre: " + owner.getMyobjectsList().get(i).getName() + " Descripcion: " + owner.getMyobjectsList().get(i).getDescription() + " Precio: " + owner.getMyobjectsList().get(i).getPrize());

		}
		for (int i = 0; i < owner.getMyobject2sList().size(); i++) {

			System.out.println("Identificacion: " + owner.getMyobject2sList().get(i).getIdentificator() + " Nombre: " + owner.getMyobject2sList().get(i).getName() + " Descripcion: " + owner.getMyobject2sList().get(i).getDescription() + " Precio: " + owner.getMyobject2sList().get(i).getPrize() + " Last Update: " + owner.getMyobject2sList().get(i).getLastupdate());

		}

		sesion.close();
		System.out.println("/****************** FIN");

	}
}
