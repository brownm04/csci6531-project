package edu.gwu.csci6531.teamawesome.dao.impl;

import org.springframework.stereotype.Repository;

import edu.gwu.csci6531.teamawesome.dao.AbstractDAO;
import edu.gwu.csci6531.teamawesome.dao.ICategoryDAO;
import edu.gwu.csci6531.teamawesome.model.Category;

@Repository
public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO {

}