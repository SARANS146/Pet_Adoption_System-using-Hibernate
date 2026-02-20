package com.kce.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.entity.Pet;
import com.kce.util.HibernateUtil;


public class PetDAO {

    public Pet findPet(String petID) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Pet.class, petID);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

	public List<Pet> viewAllPets()
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Pet", Pet.class).list();
        }
    }
	
	public void InsetPet(Pet pet) {
	    Transaction transaction = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();

	        session.persist(pet);  

	        transaction.commit();

	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	    }
	}



	public void updateAvailability(String petID, String availability) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Pet pet = session.get(Pet.class, petID);

            if (pet != null) {
                pet.setAvailable(availability);
                session.merge(pet);
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
	
	public void updateMedicalStatus(String petID, String medicalStatus) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Pet pet = session.get(Pet.class, petID);

            if (pet != null) {
                pet.setMedicalStatus(medicalStatus);
                session.merge(pet);
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
	
	public boolean deletePet(String petID) {
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Pet pet = session.get(Pet.class, petID);            if (pet != null) {
                session.remove(petID);
                System.out.println("Product deleted: " + pet);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return false;
    }
}
