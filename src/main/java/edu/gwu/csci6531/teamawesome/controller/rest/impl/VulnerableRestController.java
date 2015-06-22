package edu.gwu.csci6531.teamawesome.controller.rest.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.gwu.csci6531.teamawesome.controller.rest.AbstractRestController;
import edu.gwu.csci6531.teamawesome.dao.IVulnerableDAO;
import edu.gwu.csci6531.teamawesome.model.Category;

@RestController
@RequestMapping("/rest/vuln")
public class VulnerableRestController extends AbstractRestController<Category> {
	
	@Autowired
	private IVulnerableDAO vulnDAO;

	@RequestMapping(value = "/byUsername", method = RequestMethod.GET)
	public @ResponseBody
	Object byUsername(HttpServletResponse res, @RequestParam(value = "username", required = true) String username) {
		return vulnDAO.findByUsername(username);
	}
}