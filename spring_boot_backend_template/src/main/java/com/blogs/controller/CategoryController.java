package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.entities.Category;
import com.blogs.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	public CategoryController() {
		System.out.println("in const of-" + getClass());
	}

	@GetMapping
	public List<Category> listAllcategory() {

		System.out.println(" in list of category");

		return categoryService.getAllCategories();

	}

	// responsebody---> marshaling
	@PostMapping
	public Category addNewCategory(@RequestBody Category category) {

		System.out.println("in add new category" + category);

		return categoryService.addNewCategory(category);

	}
	
	/**
	 * 3. Delete catgeory details
        Design- end point of REST API for deleting existing category (Create)
        URL - http://host:port/categories/{categoryId} (URI template variable |path variable)
        Method- DELETE
        Payload(request data)- None
        Response- @ResponseBody-- plain string message*/
	
	@DeleteMapping("/{categoryID}")
	//@pathvariable --> method arg level annotation to bind incoming path variable  
	/*
	public ApiResponse deleteCategoryDelete(@PathVariable Long categoryID) {
		System.out.println("in delete category.."+categoryID);
		
	return new ApiResponse(categoryService.deletecategoryDelete(categoryID)); 	
	}*/

	
	@GetMapping("/{catId}")
	public Category getAllcategoryDetails(@PathVariable Long categoryID) {
		return categoryService.getAllcategoryDetails(categoryID);

	
	}
	
	
	@PutMapping("/category")
	public Category updateCategorydetails( @RequestBody Category category ) {
		System.out.println(" in update"+category);
		
		return categoryService.cupdateCategorydetails(category);
	}

	
	
}
