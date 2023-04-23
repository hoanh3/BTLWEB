package btlweb.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import btlweb.mvc.dao.CategoryDao;
import btlweb.mvc.dao.impl.CategoryDaoImpl;
import btlweb.mvc.model.Category;
import btlweb.mvc.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	
	private CategoryDao _categoryDao = new CategoryDaoImpl();
	
	// du lieu test
	public static List<Category> categories = new ArrayList<>();
	
	static {
		categories.add(new Category(1, "shirts"));
		categories.add(new Category(2, "t-shirts"));
		categories.add(new Category(3, "polo"));
		categories.add(new Category(4, "hoodies"));
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return CategoryServiceImpl.categories;
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return CategoryServiceImpl.categories.get(id - 1);
	}

	@Override
	public int insertCategory(Category category) {
		// TODO Auto-generated method stub
		CategoryServiceImpl.categories.add(category);
		return 1;
	}

	@Override
	public int deleteCategory(int id) {
		// TODO Auto-generated method stub
		CategoryServiceImpl.categories.remove(id - 1);
		return 1;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return _categoryDao.updateCategory(category);
	}

	@Override
	public int getNumOfCategory() {
		// TODO Auto-generated method stub
		return _categoryDao.getNumOfCategory();
	}

	@Override
	public List<Category> getCategoryInPage(int pageId) {
		// TODO Auto-generated method stub
		return _categoryDao.getCategoryInPage(pageId);
	}
}
