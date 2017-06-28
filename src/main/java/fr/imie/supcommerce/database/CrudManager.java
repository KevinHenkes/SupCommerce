package fr.imie.supcommerce.database;

import java.util.ArrayDeque;
import java.util.Deque;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CrudManager {
    Class<Object> classEntity;
    private EntityManager entityManager;
    EntityTransaction transaction;

    @SuppressWarnings("unchecked")
    public CrudManager(Object classObject) throws ClassCastException {
	try {
	    this.classEntity = (Class<Object>) classObject;
	} catch (ClassCastException e) {
	    throw e;
	}
    }

    private void beginTransaction() {
	entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
	transaction = entityManager.getTransaction();
	transaction.begin();
    }

    private void endTransaction() {
	if (transaction.isActive())
	    transaction.rollback();
	entityManager.close();
    }

    public Object add(Object item) {
	try {
	    beginTransaction();
	    entityManager.persist(item);
	    transaction.commit();
	} finally {
	    endTransaction();
	}

	return item;
    }

    public Object rm(Object item) {
	try {
	    beginTransaction();
	    entityManager.remove(item);
	    transaction.commit();
	} finally {
	    endTransaction();
	}

	return item;
    }

    @SuppressWarnings("unchecked")
    public Deque<Object> findAll() {
	Deque<Object> items = new ArrayDeque<Object>();

	try {
	    beginTransaction();
	    entityManager.createQuery("FROM " + classEntity.getSimpleName()).getResultList().forEach(item -> {
		items.push(item);
	    });
	    transaction.commit();
	} finally {
	    endTransaction();
	}

	return items;
    }

    public Object update(Object item) {
	try {
	    beginTransaction();
	    entityManager.merge(item);
	    transaction.commit();
	} finally {
	    endTransaction();
	}

	return item;
    }

    public Object find(long id) {
	Object item;

	try {
	    beginTransaction();
	    item = entityManager.find(classEntity, id);
	    transaction.commit();
	} finally {
	    endTransaction();
	}

	return item;
    }
}
