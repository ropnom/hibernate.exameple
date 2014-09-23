package HibernateGS;

import java.util.Date;

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

		//config.addAnnotatedClass(ObjetoElement.class);
		config.addAnnotatedClass(ObjetoPlus.class);
		config.addAnnotatedClass(ObjetoResources.class);

		config.configure();

		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		// Session sesion = factory.getCurrentSession();
		Session sesion = factory.openSession();

		LLenardatabase(sesion);

	}

	private static void LLenardatabase(Session sesion) {
		sesion.beginTransaction();

		// Create objeto
		ObjetoPlus obj = new ObjetoPlus("Mesa", "Sirve como estructura basica para proceos humanso como comidas o escritura", 60.80);
		obj.Put("mi casa", new Date(), true);
		ObjetoPlus obj2 = new ObjetoPlus("Silla", "Sirve como estructura basica para sentarse", 20.80);
		obj.Put("tu casa", new Date(), false);		
		ObjetoPlus obj5 = new ObjetoPlus("Coca","Cocaina de la buena unos pocos gramos",60.00);
		obj5.Put("en la 027 para los aeronauticos", new Date(2013, 11, 5), true);
	

		// Save objeto in DDBB
		sesion.save(obj);
		sesion.save(obj2);
		sesion.save(obj5);

		System.out.println("Identificacion: " + obj.getIdentificator() + " Nombre: " + obj.getName() + " Descripcion: " + obj.getDescription() + " Precio: " + obj.getPrize());
		System.out.println("Identificacion: " + obj2.getIdentificator() + " Nombre: " + obj2.getName() + " Descripcion: " + obj2.getDescription() + " Precio: " + obj2.getPrize());

		// change objeto propierties
		obj2.setPrize(10.50);
		obj2.setDescription("Estructura de madera o aluminio normlamente planificada para que una persona se siente.");

		// update DDBB
		sesion.update(obj2);
		System.out.println("Identificacion: " + obj2.getIdentificator() + " Nombre: " + obj2.getName() + " Descripcion: " + obj2.getDescription() + " Precio: " + obj2.getPrize());
		
		
		
		//Objeto Resources
		
		ObjetoResources re1 = new ObjetoResources("Tomates", "fruta rojiza muy buena", 1.85f,"supermercado de mi casa",new Date(), true);
		ObjetoResources re2 = new ObjetoResources("Patatas", "amarilals y blancas tuberculos", 3.85f,"supermercado de mi casa",new Date(), true);
		ObjetoResources re3 = new ObjetoResources("LEchuga", "hortaliza verde", 0.85f,"supermercado de mi casa",new Date(), true);

		re1.setCristal(1000);
		re2.setDeuterio(5000);
		re3.setMetal(456);
		
		sesion.save(re1);
		sesion.save(re2);
		sesion.save(re3);
		
		sesion.getTransaction().commit();
		sesion.close();
		System.out.println("/****************** FIN");

	}

}
