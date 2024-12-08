package com.blogs.service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dto.ApiResponse;
import com.blogs.entities.Category;
import com.blogs.repository.CategoryRepositiry;

@Service
@Transactional

public class CategporyServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepositiry categoryRepositiry;

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepositiry.findAll();
	}

	@Override
	public Category addNewCategory(Category newCategory) {
		// TODO Auto-generated method stub
		return categoryRepositiry.save(newCategory);
	}

	// eturn " delete failed....";
//	}@Override
//	public String deletecategoryDelete(Long catId) {
//		// TODO Auto-generated method stub
//		if(categoryRepositiry.existsById(catId)) {		
//		categoryRepositiry.deleteById(catId);
//		return "category delete ";}
//		

//	@Override
//	public String deletecategoryDelete1(Long Id) {
//		// TODO Auto-generated method stub
//		return " ";
//	}

	@Override
	public Category getAllcategoryDetails(Long categoryID) {
		// TODO Auto-generated method stub
		Optional<Category> optional = categoryRepositiry.findById(categoryID);
		return optional.orElseThrow(() -> new ResolutionException(" invalid cat Id"));
	}

	@Override
	public Category cupdateCategorydetails(Category category) {
		// TODO Auto-generated method stub
		return categoryRepositiry.save(category);
	}

}
