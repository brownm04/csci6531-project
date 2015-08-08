package edu.gwu.csci6531.teamawesome.controller.rest;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.gwu.csci6531.teamawesome.dao.IDAO;

public abstract class AbstractRestController<T extends Serializable> implements
		IRestController<T> {
	@SuppressWarnings("unchecked")
	protected final Log log = LogFactory
			.getLog((Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0]);

	@Override
	@RequestMapping(value = AbstractRestURIConstants.FIND_ALL, method = RequestMethod.GET)
	public @ResponseBody
	List<T> findAll() {
		return getDao().findAll();
	}

	@Override
	@RequestMapping(value = AbstractRestURIConstants.FIND_ONE, method = RequestMethod.GET)
	public @ResponseBody
	T findOne(@PathVariable(value = "id") final Long id) {
		return getDao().findOne(id);
	}

	@Override
	@RequestMapping(value = AbstractRestURIConstants.CREATE, method = RequestMethod.POST)
	public @ResponseBody
	void create(@RequestBody final T entity) {
		log.info("Creating new entity: " + entity.toString());
		getDao().create(entity);
	}

	@Override
	@RequestMapping(value = AbstractRestURIConstants.UPDATE, method = RequestMethod.PUT)
	public @ResponseBody
	T update(@RequestBody final T entity) {
		return getDao().update(entity);
	}

	@Override
	@RequestMapping(value = AbstractRestURIConstants.DELETE, method = RequestMethod.DELETE)
	public @ResponseBody
	void delete(@RequestBody final T entity,
			@RequestParam(value = "id", required = false) final Long id) {
		if (id != null)
			getDao().deleteById(id);
		else
			getDao().delete(entity);
	}
	
	protected abstract IDAO<T> getDao();
}
