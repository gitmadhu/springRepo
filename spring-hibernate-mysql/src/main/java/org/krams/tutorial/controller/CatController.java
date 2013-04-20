package org.krams.tutorial.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.krams.tutorial.domain.Category;
import org.krams.tutorial.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Handles and retrieves Category request
 */
@Controller
@RequestMapping("/catView")
public class CatController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="categoryService")
	private CategoryService catService;
	
	/**
	 * Handles and retrieves all Categorys and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/cats", method = RequestMethod.GET)
    public String getCategory(Model model) {
    	
    	logger.debug("Received request to show all Categorys");
    	
    	// Retrieve all Categorys by delegating the call to CategoryServices
    	List<Category> cat = catService.getAll();
    	
    	// Attach Categorys to the Model
    	model.addAttribute("cats", cat);
    	
    	// This will resolve to /WEB-INF/jsp/ategoriespage.jsp
    	return "categorypage";
	}
    
    /**
     * Retrieves the add page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/cats/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
    	logger.debug("Received request to show add page");
    
    	// Create new Person and add to model
    	// This is the formBackingOBject
    	model.addAttribute("categoryAttribute", new Category());

    	// This will resolve to /WEB-INF/jsp/addpage.jsp
    	return "cataddpage";
	}
 
    /**
     * Adds a new Category by delegating the processing to CategoryService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/cats/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("categoryAttribute") Category category) {
		logger.debug("Received request to add new Category");
		
    	// The "personAttribute" model has been passed to the controller from the JSP
    	// We use the name "personAttribute" because the JSP uses that name
		
		// Call PersonService to do the actual adding
		catService.add(category);

    	// This will resolve to /WEB-INF/jsp/addedpage.jsp
		return "cataddedpage";
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
		catService.delete(id);
		
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
    	model.addAttribute("personAttribute", catService.get(id));
    	
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
    public String saveEdit(@ModelAttribute("personAttribute") Category category, 
    										   @RequestParam(value="id", required=true) Integer id, 
    												Model model) {
    	logger.debug("Received request to update person");
    
    	// The "personAttribute" model has been passed to the controller from the JSP
    	// We use the name "CategoryAttribute" because the JSP uses that name
    	
    	// We manually assign the id because we disabled it in the JSP page
    	// When a field is disabled it will not be included in the ModelAttribute
    	category.setCatId(id);
    	
    	// Delegate to CategoryService for editing
    	catService.edit(category);
    	
    	// Add id reference to Model
		model.addAttribute("id", id);
		
    	// This will resolve to /WEB-INF/jsp/editedpage.jsp
		return "editedpage";
	}
    
}
