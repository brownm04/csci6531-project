package edu.gwu.csci6531.teamawesome.controller.rest.impl;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.gwu.csci6531.teamawesome.controller.rest.AbstractRestController;
import edu.gwu.csci6531.teamawesome.controller.rest.exception.NoSuchUserException;
import edu.gwu.csci6531.teamawesome.dao.IUserDAO;
import edu.gwu.csci6531.teamawesome.model.User;

@RestController
@RequestMapping("/rest/users")
public class UserRestController extends AbstractRestController<User> {
	@Autowired
	private IUserDAO userDAO;

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public @ResponseBody
	User signIn(HttpServletResponse res, @RequestBody final User user) {
		User newUser = userDAO.findByUsername(user.getUsername());

		if (user.getPassword() == null || !user.getPassword().equals(newUser.getPassword()))
			throw new NoSuchUserException();

		log.info("User " + user.getUsername() + " logged in.");

		res.addCookie(new Cookie("user", "" + newUser.getId()));
		return newUser;
	}
}
