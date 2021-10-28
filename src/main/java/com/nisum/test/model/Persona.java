package com.nisum.test.model;

import java.util.Date;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="Persona")

@JsonIgnoreProperties(value = { "handler" })
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@CreationTimestamp
	private Date created;
	@LastModifiedDate
	private Date modified;
	
	@Column(name="lastLogin")
	@CreationTimestamp
	private Date lastLogin;
	@Column(name="token")
	private String token;
	@Column(name="isactive")
	private Integer isactive;
	

	
	 @JoinColumn (name = "persona_id") // Nombre de la clave externa asignada
	 @OneToMany (cascade = CascadeType.PERSIST) // Mapa de asociación unidireccional uno a muchos
//	 // @OneToMany (cascade = CascadeType.PERSIST, mappedBy = "customer") // equivalente a las dos líneas anteriores
	@OrderBy(value = "id asc")
	private Set<Phone> phones;
	
		
		
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Phone> getPhones() {
		return phones;
	}
	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	
	



	
	

}
