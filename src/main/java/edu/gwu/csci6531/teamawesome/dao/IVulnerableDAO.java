package edu.gwu.csci6531.teamawesome.dao;

import edu.gwu.csci6531.teamawesome.model.User;


public interface IVulnerableDAO extends IDAO<User> {
	Object findByUsername(final String username);
}
