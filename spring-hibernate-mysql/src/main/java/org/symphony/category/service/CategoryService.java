package org.symphony.category.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.symphony.category.domain.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Persons
 * 
 */
@Service("categoryService")
@Transactional
public class CategoryService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all persons
	 * 
	 * @return a list of persons
	 */
	public List<Category> getAll() {
		logger.debug("Retrieving all Category");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Category");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single person
	 */
	public Category get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person first
		Category category = (Category) session.get(Category.class, id);
		
		return category;
	}
	/**
	 * Adds a new person
	 */
	public void add(Category category) {
		logger.debug("Adding new Category");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(category);
	}
	
	/**
	 * Deletes an existing person
	 * @param id the id of the existing person
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person first
		Category category = (Category) session.get(Category.class, id);
		
		// Delete 
		session.delete(category);
	}
	
	/**
	 * Edits an existing Category
	 */
	public void edit(Category category) {
		logger.debug("Editing existing Category");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Category via id
		Category existingCategory = (Category) session.get(Category.class, category.getCatId());
		
		// Assign updated values to this category
		existingCategory.setCatName(category.getCatName());
		existingCategory.setCatDesc(category.getCatDesc());

		// Save updates
		session.save(existingCategory);
	}
}
