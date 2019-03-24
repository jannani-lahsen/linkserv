package io.github.oliviercailloux.y2018.dauphine_pole_info;

import java.util.Optional;

import javax.json.bind.Jsonb;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;

@Entity
@JsonbPropertyOrder({ "id", "name", "description" })
@XmlRootElement
public class Master {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute @JsonbProperty("id")
	private int id;
	
	@JsonbProperty("name")
	@Column(name = "nom", unique = false)
	private String name;

	@JsonbProperty("description")
	@Column(name = "description", unique = false)
	private String description;

	private static Jsonb jsonb = JsonUtils.getInstance();

	public Master() {
		super();
		this.name = "";

	}

	public Master(int id, String nom, String description) {
		super();
		this.id = id;
		this.name = Strings.nullToEmpty(nom);
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return not null.
	 */
	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Strings.nullToEmpty(name);
	}

	/**
	 * @return not null.
	 */
	@XmlAttribute(name = "description")
	public Optional getDescription() {
		return Optional.ofNullable(description);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Master : json
	 * 
	 */
	public String toJson() {
		return jsonb.toJson(this);
	}

	/**
	 * @param jsonMaster
	 *            : String
	 * @return Object : Master not null
	 */
	public static Master fromJson(String jsonbMaster) {
		return jsonb.fromJson(Strings.nullToEmpty(jsonbMaster), Master.class);
	}
}
