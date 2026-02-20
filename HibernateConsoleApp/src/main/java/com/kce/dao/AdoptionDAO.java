package com.kce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kce.entity.Adoption;
import com.kce.util.HibernateUtil;

public class AdoptionDAO {

 
    public boolean recordAdoption(Adoption adoption) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(adoption);

            transaction.commit();
            return true;

        } catch (Exception e) {

            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public List<Adoption> getAllAdoptions() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery("FROM Adoption", Adoption.class).list();

        } catch (Exception e) {

            e.printStackTrace();
            return List.of();   
        }
    }

    public Adoption findAdoption(int adoptionID) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Adoption.class, adoptionID);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public boolean updateAdoption(Adoption adoption) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(adoption);

            transaction.commit();
            return true;

        } catch (Exception e) {

            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAdoption(int adoptionID) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Adoption adoption = session.get(Adoption.class, adoptionID);

            if (adoption != null) {
                session.remove(adoption);
            }

            transaction.commit();
            return true;

        } catch (Exception e) {

            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
