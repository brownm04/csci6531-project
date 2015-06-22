package edu.gwu.csci6531.teamawesome.controller.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.gwu.csci6531.teamawesome.controller.rest.AbstractRestController;
import edu.gwu.csci6531.teamawesome.dao.IDAO;
import edu.gwu.csci6531.teamawesome.model.ViewLog;

@RestController
@RequestMapping("/rest/viewlog")
public class ViewLogRestController extends AbstractRestController<ViewLog> {

	@Autowired
	private IDAO<ViewLog> viewLog;
	
	@Override
	protected IDAO<ViewLog> getDao() {
		return viewLog;
	}
}