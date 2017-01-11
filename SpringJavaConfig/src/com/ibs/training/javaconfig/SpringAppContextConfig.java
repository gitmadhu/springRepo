package com.ibs.training.javaconfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibs.training.model.Circle;
import com.ibs.training.model.Rectangle;
import com.ibs.training.model.Square;
import com.ibs.training.model.Triangle;
import com.ibs.training.service.ProfessionalDrawing;
import com.ibs.training.service.RectangleDrawing;
import com.ibs.training.service.ShapesCollection;
import com.ibs.training.service.SquareDrawing;

@Configuration
public class SpringAppContextConfig {

	@Bean
	public RectangleDrawing rectangleDrawing(){
		return new RectangleDrawing();
	}
	
	@Bean
	public SquareDrawing squareDrawing(){
		return new SquareDrawing();
	}
	
	@Bean
	public ProfessionalDrawing professionalDrawing(){
		return new ProfessionalDrawing(circle());
	}
	
	@Bean
	public Triangle triangle(){
		return new Triangle();
	}
	
	@Bean
	public Circle circle(){
		return new Circle();
	}
	
	@Bean
	public Rectangle rectangle(){
		return new Rectangle();
	}
	
	@Bean
	public Square square(){
		return new Square();
	}
	
	@Bean
	public ShapesCollection shapesCollection(){
		ShapesCollection shapesCollection = new ShapesCollection();
		
		 List<Object> lists = new ArrayList<>();
		 Set<Object> sets = new HashSet<>();
		 Map<Object, Object> maps =  new HashMap<>();
		 Properties pros =  new Properties(); 
		 
		 lists.add(triangle());
		 lists.add(circle());
		 shapesCollection.setLists(lists);
		 
		 sets.add(triangle());
		 sets.add(circle());
		 shapesCollection.setSets(sets);
		 
		 maps.put("1", triangle());
		 maps.put("2", circle());
		 shapesCollection.setMaps(maps);
		 
		 pros.put("admin", "admin@ibs.com");
		 pros.put("support", "support@ibs.com");
		 shapesCollection.setPros(pros);
		 
		 shapesCollection.setNum(1);
		 shapesCollection.setMessage("hello");
		 
		return shapesCollection;
	}
	
	
}
