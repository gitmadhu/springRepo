package org.symphony.category.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.symphony.category.domain.Product;
import org.symphony.category.service.ProductService;


/**
 * Handles and retrieves product request
 */
@Controller
@RequestMapping("/productView")
public class ProductController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="productService")
	private ProductService productService;
	
	/**
	 * Handles and retrieves all product and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/showProducts", method = RequestMethod.GET)
    public String getshowProducts(@RequestParam(value="id", required=true) String id,Model model) {
    	
    	logger.debug("Received request to show all products");
    	
    	// Retrieve all product by delegating the call to productServices
    	List<Product> product = productService.getProductsByCategory(new Integer(id));
    	
    	// Attach product to the Model
    	model.addAttribute("products", product);
    	
    	// This will resolve to /WEB-INF/jsp/ategoriespage.jsp
    	return "productpage";
	}
	
	/**
	 * Handles and retrieves all product and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts(Model model) {
    	
    	logger.debug("Received request to show all products");
    	
    	// Retrieve all product by delegating the call to productServices
    	List<Product> product = productService.getAll();
    	
    	// Attach product to the Model
    	model.addAttribute("products", product);
    	
    	// This will resolve to /WEB-INF/jsp/ategoriespage.jsp
    	return "productpage";
	}
    
    /**
     * Retrieves the add page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
    	logger.debug("Received request to show add page");
    
    	// Create new Person and add to model
    	// This is the formBackingOBject
    	model.addAttribute("productAttribute", new Product());

    	// This will resolve to /WEB-INF/jsp/addpage.jsp
    	return "productaddpage";
	}
 
    /**
     * Adds a new product by delegating the processing to productService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("productAttribute") Product product) {
		logger.debug("Received request to add new product");
		
    	// The "personAttribute" model has been passed to the controller from the JSP
    	// We use the name "personAttribute" because the JSP uses that name
		
		// Call PersonService to do the actual adding
		productService.add(product);

    	// This will resolve to /WEB-INF/jsp/addedpage.jsp
		return "productaddedpage";
	}
    
    /**
     * Deletes an existing person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/persons/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id, 
    										Model model) {
   
		logger.debug("Received request to delete existing person");
		
		// Call PersonService to do the actual deleting
		productService.delete(id);
		
		// Add id reference to Model
		model.addAttribute("id", id);
    	
    	// This will resolve to /WEB-INF/jsp/deletedpage.jsp
		return "deletedpage";
	}
    
    /**
     * Retrieves the edit page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/persons/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id,  
    										Model model) {
    	logger.debug("Received request to show edit page");
    
    	// Retrieve existing Person and add to model
    	// This is the formBackingOBject
    	model.addAttribute("personAttribute", productService.get(id));
    	
    	// This will resolve to /WEB-INF/jsp/editpage.jsp
    	return "editpage";
	}
    
    /**
     * Edits an existing person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/persons/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("personAttribute") Product product, 
    										   @RequestParam(value="id", required=true) Integer id, 
    												Model model) {
    	logger.debug("Received request to update person");
    
    	// The "personAttribute" model has been passed to the controller from the JSP
    	// We use the name "productAttribute" because the JSP uses that name
    	
    	// We manually assign the id because we disabled it in the JSP page
    	// When a field is disabled it will not be included in the ModelAttribute
    	product.setProdId(id);
    	
    	// Delegate to productService for editing
    	productService.edit(product);
    	
    	// Add id reference to Model
		model.addAttribute("id", id);
		
    	// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return "editedpage";
	}
    
}
