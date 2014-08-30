package HibernateRelations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import HibernaterObject.Objeto;

@Entity
public class Owner {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long identificator;

	@Column(nullable=false)
	protected String name;	
	protected String surname;
	protected int age = 0;
	
	//This annotation  reference other objects, other tables using a intermediate table
	@OneToMany(targetEntity=Objeto.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Objeto> myobjectsList;
	
	//This annotation  reference other objects, other tables using a field owner form objeto2.
	@OneToMany(targetEntity=Objeto2.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="owner")
	List<Objeto2> myobject2sList;

	public Owner() {

	}

	public Owner(String name, int age) {

		this.name = name;
		this.age = age;
		this.myobjectsList = new ArrayList<Objeto>();
		this.myobject2sList = new ArrayList<Objeto2>();

	}

	public Owner(String name, String surname, int age) {

		this.name = name;
		this.age = age;
		this.surname = surname;
		this.myobjectsList = new ArrayList<Objeto>();
		this.myobject2sList = new ArrayList<Objeto2>();

	}

	public void AddObjeto(Objeto a){
		this.myobjectsList.add(a);
		
	}
	public void AddObjeto2(Objeto2 a){
		this.myobject2sList.add(a);
		
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Objeto> getMyobjectsList() {
		return myobjectsList;
	}

	public void setMyobjectsList(List<Objeto> myobjectsList) {
		this.myobjectsList = myobjectsList;
	}

	public List<Objeto2> getMyobject2sList() {
		return myobject2sList;
	}

	public void setMyobject2sList(List<Objeto2> myobject2sList) {
		this.myobject2sList = myobject2sList;
	}

	


}
