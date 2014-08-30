package HibernaterObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateDatabase {

	public static void main(String[] args) {
		System.out.println("ARRANCOOO\n\n\n\n\n***********\n\n\n\n\n***********\n\n\n\n\n***********");
		Arranque();
	}
	
	public static void Arranque() {

		// Creamos las tablas
		AnnotationConfiguration config = new AnnotationConfiguration();
		
		
		config.addAnnotatedClass(Objeto.class);
		
		
		config.configure();

		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session sesion = factory.getCurrentSession();

		LLenardatabase(sesion);

	}
	private static void LLenardatabase(Session sesion) {
		sesion.beginTransaction();
		
		//Create objeto		
		Objeto obj = new Objeto("Mesa", "Sirve como estructura basica para proceos humanso como comidas o escritura", 60.80);
		Objeto obj2 = new Objeto("Silla", "Sirve como estructura basica para sentarse", 20.80);
		
		//Save objeto in DDBB
		
		sesion.save(obj);
		sesion.save(obj2);
		System.out.println("Identificacion: "+obj.getIdentificator()+ " Nombre: "+obj.getName()+ " Descripcion: "+ obj.getDescription()+" Precio: "+obj.getPrize());
		System.out.println("Identificacion: "+obj2.getIdentificator()+ " Nombre: "+obj2.getName()+ " Descripcion: "+ obj2.getDescription()+" Precio: "+obj2.getPrize());
		
		//change objeto propierties
		obj2.setPrize(10.50);
		obj2.setDescription("Estructura de madera o aluminio normlamente planificada para que una persona se siente.");
		
		//update DDBB
		sesion.update(obj2);
		System.out.println("Identificacion: "+obj2.getIdentificator()+ " Nombre: "+obj2.getName()+ " Descripcion: "+ obj2.getDescription()+" Precio: "+obj2.getPrize());
		
		sesion.getTransaction().commit();
		// sesion.close();
		System.out.println("/****************** FIN");

	}

}
