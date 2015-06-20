package edu.gwu.csci6531.teamawesome.controller.rest;

import java.io.Serializable;
import java.util.List;

public interface IRestController<T extends Serializable> {
	T findOne(final Long id);

	List<T> findAll();

	void create(final T entity);

	T update(final T entity);

	void delete(final T entity, final Long id);
}
