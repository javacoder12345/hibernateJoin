package com.main;

import com.dao.DAOPersona;
import com.dao.DAOProfesion;
import com.model.Persona;
import com.model.Profesion;

public class Main {

	public static void main(String[] args) {
		
		DAOPersona dpers=new DAOPersona();
		DAOProfesion dprof=new DAOProfesion();
		
		Persona pe1=new Persona("Pepe");
		Persona pe2=new Persona("Juan");
		Persona pe3=new Persona("Luis");
		dpers.insertPersona(pe1);
		dpers.insertPersona(pe2);
		dpers.insertPersona(pe3);
		
		Profesion pr1=new Profesion("Jardinero");
		Profesion pr2=new Profesion("Cocinero");
		Profesion pr3=new Profesion("Taxista");
		dprof.insertProfesion(pr1);
		dprof.insertProfesion(pr2);
		dprof.insertProfesion(pr3);
		
		pe1.anyadirProfesion(pr3);
		pe1.anyadirProfesion(pr2);
		dpers.updatePersona(pe1);
		
		pe2.anyadirProfesion(pr3);
		dpers.updatePersona(pe2);
		
		pr1.anyadirPersona(pe3);
		pr1.anyadirPersona(pe2);
		dprof.updateProfesion(pr1);
		
		pr1.quitarPersona(pe2);
		dprof.updateProfesion(pr1);
		
		dpers.deletePersona(pe1.getIdpers());
	}

}
