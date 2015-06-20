package edu.gwu.csci6531.teamawesome.controller.rest.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.gwu.csci6531.teamawesome.controller.rest.AbstractRestController;
import edu.gwu.csci6531.teamawesome.model.Category;

@RestController
@RequestMapping("/rest/category")
public class CategoryRestController extends AbstractRestController<Category> {

}