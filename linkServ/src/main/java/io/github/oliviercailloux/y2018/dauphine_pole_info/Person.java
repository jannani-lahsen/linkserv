package io.github.oliviercailloux.y2018.dauphine_pole_info;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;

@Entity
@JsonbPropertyOrder({ "id", "firstname", "lastname", "email", "phone","fax","homePage","cv","note","role","master","yearMaster","address","mobile","temporary" })
@XmlRootElement
@Table(name = "Personne")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute @JsonbProperty("id")
	private int id;
	
	@JsonbProperty("firstname")
	@Column(name = "prenom", unique = false)
	private String firstname;
	
	@JsonbProperty("lastname")
	@Column(name = "nom", unique = false)
	private String lastname;
	
	@JsonbProperty("email")
	@Column(name = "email", unique = false)
	private String email;

	@JsonbProperty("phone")
	@Column(name = "telephone", unique = false)
	private String phone;

	@JsonbProperty("fax")
	@Column(name = "fax", unique = false)
	private String fax;

	@JsonbProperty("homePage")
	@Column(name = "home_page", unique = false)
	private String homePage;

	@JsonbProperty("cv")
	@Column(name = "cv", unique = false)
	private String cv;

	@JsonbProperty("note")
	@Column(name = "notes", unique = false)
	private String note; // comment renommage !!!

	@JsonbProperty("password")
	@Column(name = "password", unique = false)
	private String password;

	@JsonbProperty("role")
	@Column(name = "roles", unique = false)
	private String role;

	@JsonbProperty("master")
	@OneToOne
	private Master master;
	
	@JsonbProperty("yearMaster")
	private int yearMaster;

	@JsonbProperty("address")
	@Column(name = "adresse", unique = false)
	private String address;

	@JsonbProperty("mobile")
	@Column(name = "mobile", unique = false)
	private String mobile;

	@JsonbProperty("temporary")
	@Column(name = "vacataire", unique = false)
	private String temporary;

	private static Jsonb jsonb = JsonUtils.getInstance();

	public Person() {
		super();
		this.firstname = "";
		this.lastname = "";
	}

	/**
	 * Short constructor by design. Use setters to complete the object.
	 * 
	 * @param id
	 *            int
	 * @param firstname
	 *            String
	 * @param lastname
	 *            String
	 */
	public Person(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = Strings.nullToEmpty(firstname);
		this.lastname = Strings.nullToEmpty(lastname);
	}
	

	public Person(String firstname, String lastname, String email, String phone, String fax) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.fax = fax;
	}


	public int getId() {
		return id;
	}

	public void setId(int idPerson) {
		this.id = idPerson;
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = Strings.nullToEmpty(firstname);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = Strings.nullToEmpty(lastname);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = Strings.nullToEmpty(email);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = Strings.nullToEmpty(phone);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = Strings.nullToEmpty(fax);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getHome_page() {
		return homePage;
	}

	public void setHomePage(String home_page) {
		this.homePage = Strings.nullToEmpty(home_page);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = Strings.nullToEmpty(cv);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = Strings.nullToEmpty(note);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Strings.nullToEmpty(password);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = Strings.nullToEmpty(role);
	}

	/**
	 * @return not <code>null</code>.
	 * */
	public Master getMaster() {
		return master;
	}

	public void setMaster(Master idMaster) {
		this.master = idMaster;
	}

	/**
	 * @return not <code>null</code>.
	 * */
	public int getYear_master() {
		return yearMaster;
	}

	public void setYearMaster(int year_master) {
		this.yearMaster = year_master;
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = Strings.nullToEmpty(address);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = Strings.nullToEmpty(mobile);
	}

	/**
	 * 
	 * @return String not null
	 */
	public String getTemporary() {
		return temporary;
	}

	public void setTemporary(String temporary) {
		this.temporary = Strings.nullToEmpty(temporary);
	}

	/**
	 * @return Person not null
	 */
	public String toJson() {
		return jsonb.toJson(this);
	}

	/**
	 * @param jsonPerson
	 *            : String
	 * @return Object : Person
	 */
	public static Person fromJson(String jsonPersonne) {
		return jsonb.fromJson(jsonPersonne, Person.class);
	}
}