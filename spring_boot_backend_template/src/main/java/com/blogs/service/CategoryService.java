package com.blogs.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.blogs.dto.ApiResponse;
import com.blogs.entities.Category;

public interface CategoryService  {

  java.util.List<Category>getAllCategories();

  Category addNewCategory( Category newCategory); 
  
  //ApiResponse deletecategoryDelete(Long Id);
  
  Category getAllcategoryDetails(@PathVariable Long categoryID) ;
  
  Category cupdateCategorydetails( @RequestBody Category category ) ;
}
