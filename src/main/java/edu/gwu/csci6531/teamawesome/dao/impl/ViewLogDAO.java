package edu.gwu.csci6531.teamawesome.dao.impl;

import org.springframework.stereotype.Repository;

import edu.gwu.csci6531.teamawesome.dao.AbstractDAO;
import edu.gwu.csci6531.teamawesome.dao.IViewLogDAO;
import edu.gwu.csci6531.teamawesome.model.ViewLog;

@Repository
public class ViewLogDAO extends AbstractDAO<ViewLog> implements IViewLogDAO {

}