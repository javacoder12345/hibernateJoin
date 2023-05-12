package com.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="profesion")
public class Profesion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idprofesion")
	private int idprofesion;
	
	@Column(name="nomprofesion")
	private String nomprofesion;
	
	@ManyToMany   //(cascade = CascadeType.ALL)
	@JoinTable(
			name = "persona_profesion", //Se crea automaticamente...
			joinColumns = @JoinColumn(name = "idprofesion"),
            inverseJoinColumns = @JoinColumn(name = "idpersona")
			  )
	private List<Persona> personas=new ArrayList<Persona>();
	
	public Profesion() {
		super();
	}
	
	public Profesion(String nomprof) {
		super();
		this.nomprofesion = nomprof;
	}
	
	public int getIdprof() {
		return idprofesion;
	}
	public void setIdprof(int idprof) {
		this.idprofesion = idprof;
	}
	public String getNomprof() {
		return nomprofesion;
	}
	public void setNomprof(String nomprof) {
		this.nomprofesion = nomprof;
	}
	public List<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	public void anyadirPersona(Persona pe) {
		this.personas.add(pe);
		pe.getProfesiones().add(this);
	}
	
	public void quitarPersona(Persona pe) {
		this.personas.remove(pe);
		pe.getProfesiones().remove(this);
	}
	
}
