package org.krams.tutorial.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.krams.tutorial.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Products
 * 
 */
@Service("procuctService")
@Transactional
public class ProductService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all Product
	 * 
	 * @return a list of Product
	 */
	public List<Product> getAll() {
		logger.debug("Retrieving all Product");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Product");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single Product
	 */
	public Product get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Product first
		Product product = (Product) session.get(Product.class, id);
		
		return product;
	}
	/**
	 * Adds a new Product
	 */
	public void add(Product product) {
		logger.debug("Adding new Product");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(product);
	}
	
	/**
	 * Deletes an existing Product
	 * @param id the id of the existing Product
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing Product");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Product first
		Product product = (Product) session.get(Product.class, id);
		
		// Delete 
		session.delete(product);
	}
	
	/**
	 * Edits an existing Product
	 */
	public void edit(Product product) {
		logger.debug("Editing existing Product");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing Product via id
		Product existingProduct = (Product) session.get(Product.class, product.getProdId());
		
		// Assign updated values to this Product
		existingProduct.setProdName(product.getProdName());
		existingProduct.setProdPrice(product.getProdPrice());
		// Save updates
		session.save(existingProduct);
	}
}
