package edu.gwu.csci6531.teamawesome.dao;

import edu.gwu.csci6531.teamawesome.model.User;

public interface IUserDAO extends IDAO<User> {
	User findByUsername(final String username);
}
