package com.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idpersona")
	private int idpersona;
	
	@Column(name="nompersona")
	private String nompersona;
	
	@ManyToMany    //(cascade = CascadeType.ALL)
	@JoinTable(
			name="persona_profesion",  //Se crea automaticamente...
			joinColumns = @JoinColumn(name = "idpersona"),
		    inverseJoinColumns = @JoinColumn(name = "idprofesion")
			  )
	private List<Profesion> profesiones=new ArrayList<Profesion>();
	
	public Persona() {
		super();
	}

	public Persona(String nombre) {
		super();
		this.nompersona = nombre;
	}

	public int getIdpers() {
		return idpersona;
	}

	public void setIdpers(int idpers) {
		this.idpersona = idpers;
	}

	public String getNombre() {
		return nompersona;
	}

	public void setNombre(String nombre) {
		this.nompersona = nombre;
	}

	public List<Profesion> getProfesiones() {
		return profesiones;
	}

	public void setProfesiones(List<Profesion> profesiones) {
		this.profesiones = profesiones;
	}
	
	public void anyadirProfesion(Profesion pr) {
		this.profesiones.add(pr);
		pr.getPersonas().add(this);
	}
	
	public void quitarProfesion(Profesion pr) {
		this.profesiones.remove(pr);
		pr.getPersonas().remove(this);
	}

}
