package com.ncu.MovieApp.services;

import com.ncu.MovieApp.entities.Category;
import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    Category getCategoryById(int id);
    List<Category> getAllCategories();
}
