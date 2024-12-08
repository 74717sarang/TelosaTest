package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.entities.Category;

public interface CategoryRepositiry extends JpaRepository<Category, Long> {

}
