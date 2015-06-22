package edu.gwu.csci6531.teamawesome.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.gwu.csci6531.teamawesome.dao.AbstractDAO;
import edu.gwu.csci6531.teamawesome.dao.IVulnerableDAO;
import edu.gwu.csci6531.teamawesome.model.User;

@Repository
public class VulnerableDAO extends AbstractDAO<User> implements IVulnerableDAO {

	@Transactional
	public Object findByUsername(final String username) {
		System.out.println(username);
		List<?> foo = em.createNativeQuery(
				"SELECT * from USERS where username='" + username + "'").getResultList();
		
		return foo;
	}
}