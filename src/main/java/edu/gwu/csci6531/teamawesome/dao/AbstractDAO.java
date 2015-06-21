package edu.gwu.csci6531.teamawesome.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
public abstract class AbstractDAO<T extends Serializable> implements IDAO<T> {
	protected Class<T> clazz = (Class<T>) ((ParameterizedType) getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];

	@PersistenceContext
	protected EntityManager em;

	@Override
	@Transactional
	public final T findOne(final long id) {
		TypedQuery<T> query = em.createQuery(
				"SELECT t FROM " + clazz.getSimpleName() + " t WHERE t.id = " + id, clazz);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public final List<T> findAll() {
		TypedQuery<T> query = em.createQuery(
        		"SELECT t FROM " + clazz.getSimpleName() + " t ORDER BY t.id", clazz);
        return query.getResultList();
	}

	@Override
	@Transactional
	public void create(final T entity) {
		checkNotNull(entity);

		em.persist(entity);
	}

	@Override
	@Transactional
	public T update(final T entity) {
		checkNotNull(entity);
		return (T) em.merge(entity);
	}

	@Override
	@Transactional
	public final void delete(final T entity) {
		checkNotNull(entity);
		em.remove(entity);
	}

	@Override
	@Transactional
	public final void deleteById(final long entityId) {
		final T entity = findOne(entityId);
		checkState(entity != null);
		delete(entity);
	}

	private <K> K checkNotNull(final K k) {
		if (k == null)
			throw new NullPointerException();
		return k;
	}

	private void checkState(boolean expression) {
		if (!expression)
			throw new IllegalStateException();
	}
}