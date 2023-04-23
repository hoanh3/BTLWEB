package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.Category;

public interface CategoryService {

	List<Category> getAll();
	Category getCategoryById(int id);
	int insertCategory(Category category);
	int updateCategory(Category category);
	int deleteCategory(int id);
	

	int getNumOfCategory();
	List<Category> getCategoryInPage(int pageId);
}
