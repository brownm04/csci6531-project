package edu.gwu.csci6531.teamawesome.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.gwu.csci6531.teamawesome.dao.AbstractDAO;
import edu.gwu.csci6531.teamawesome.dao.IUserDAO;
import edu.gwu.csci6531.teamawesome.model.User;

@Repository
public class UserDAO extends AbstractDAO<User> implements IUserDAO {

	@Transactional
	public User findByUsername(final String username) {
		return (User) em.createQuery(
				"from " + clazz.getName() + " where username='" + username + "'").getSingleResult();
	}
}
