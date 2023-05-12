package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Profesion;
import com.util.HibernateUtil;

public class DAOProfesion {
	

	public void insertProfesion(Profesion p) {
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.persist(p);
			transaction.commit();
			System.out.println("Prof insertada");
		} catch (Exception e) {
			if (transaction!=null) {
				System.out.println("Error al insertar Prof");
				transaction.rollback();
			}
		}
	}
	
	public void updateProfesion(Profesion p) {
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.merge(p);
			transaction.commit();
			System.out.println("Prof actualizada");
		} catch (Exception e) {
			if (transaction!=null) {
				System.out.println("Error al actualizar Prof");
				transaction.rollback();
			}
		}
	}
	
	public void deleteProfesion(int id) {
		Transaction transaction=null;
		Profesion p=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			p=session.get(Profesion.class, id);
			session.remove(p);
			transaction.commit();
			System.out.println("Prof borrada");
		} catch (Exception e) {
			if (transaction!=null) {
				System.out.println("Error al borrar Prof");
				transaction.rollback();
			}
		}
	}
	
	public Profesion selectProfesionById(int id) {
		Transaction transaction=null;
		Profesion p=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			p=session.get(Profesion.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				System.out.println("Error al seleccionar Prof");
				transaction.rollback();
			}
		}
		return p;
	}
	
	public List<Profesion> selectAllProfesiones() {
		Transaction transaction=null;
		List<Profesion> profesiones=null;
		Profesion p=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			profesiones=session.createQuery("from Profesion",Profesion.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				System.out.println("Error al seleccionar Prof");
					transaction.rollback();
			}
		}
		return profesiones;
	}


}
