package btlweb.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import btlweb.mvc.dao.CategoryDao;
import btlweb.mvc.dao.ProductDao;
import btlweb.mvc.dao.impl.CategoryDaoImpl;
import btlweb.mvc.dao.impl.ProductDaoImpl;
import btlweb.mvc.model.Category;
import btlweb.mvc.service.CategoryService;
import btlweb.mvc.service.ProductService;

public class CategoryServiceImpl implements CategoryService{
	
	private CategoryDao _categoryDao = new CategoryDaoImpl();
	private ProductDao _productDao = new ProductDaoImpl();
	
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return _categoryDao.getAll();
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return _categoryDao.getCategoryById(id);
	}

	@Override
	public int insertCategory(Category category) {
		// TODO Auto-generated method stub
		return _categoryDao.insertCategory(category);
	}

	@Override
	public int deleteCategory(int id) {
		// TODO Auto-generated method stub
		_productDao.deletProductByCategoryId(id);
		return _categoryDao.deleteCategory(id);
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
