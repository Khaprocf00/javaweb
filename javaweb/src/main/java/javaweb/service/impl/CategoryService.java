package javaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import javaweb.dao.ICategoryDAO;
import javaweb.model.CategoryModel;
import javaweb.paging.Pageble;
import javaweb.service.ICategoryService;

public class CategoryService implements ICategoryService{
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public Long insert(CategoryModel category) {
		return categoryDAO.insert(category);
	}

	@Override
	public void update(CategoryModel category, Long id) {
		categoryDAO.Update(category, id);
	}

	@Override
	public void delete(Long[] ids) {
		categoryDAO.Delete(ids);
	}

	@Override
	public List<CategoryModel> findAllPage(Pageble pageble) {
		return categoryDAO.findAllPage(pageble);
	}

	@Override
	public int totalItemInTable() {
		return categoryDAO.totalItemInTable();
	}
	
}
