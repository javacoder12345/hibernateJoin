package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Persona;
import com.util.HibernateUtil;

public class DAOPersona {


	public void insertPersona(Persona p) {
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.persist(p);
			transaction.commit();
			System.out.println("Persona insertada");
		} catch (Exception e) {
			if (transaction!=null) {
				System.out.println("Error al insertar persona");
				transaction.rollback();
			}
		}
	}
	
	public void updatePersona(Persona p) {
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.merge(p);
			transaction.commit();
			System.out.println("Persona actualizada");
		} catch (Exception e) {
			if (transaction!=null) {
				System.out.println("Error al actualizar persona");
				transaction.rollback();
			}
		}
	}
	
	public void deletePersona(int id) {
		Transaction transaction=null;
		Persona p=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			p=session.get(Persona.class, id);
			session.remove(p);
			transaction.commit();
			System.out.println("Persona borrada");
		} catch (Exception e) {
			if (transaction!=null) {
				System.out.println("Error al borrar persona");
				transaction.rollback();
			}
		}
	}
	
	public Persona selectPersonaById(int id) {
		Transaction transaction=null;
		Persona p=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			p=session.get(Persona.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				System.out.println("Error al seleccionar persona");
				transaction.rollback();
			}
		}
		return p;
	}
	
	public List<Persona> selectAllPersonas() {
		Transaction transaction=null;
		List<Persona> personas=null;
		Persona p=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			personas=session.createQuery("from Persona",Persona.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				System.out.println("Error al seleccionar personas");
					transaction.rollback();
			}
		}
		return personas;
	}

}

