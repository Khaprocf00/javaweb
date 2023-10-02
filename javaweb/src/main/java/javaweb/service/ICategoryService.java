package javaweb.service;

import java.util.List;

import javaweb.model.CategoryModel;
import javaweb.paging.Pageble;

public interface ICategoryService {
	List<CategoryModel> findAll();
	Long insert(CategoryModel category);
	void update(CategoryModel category , Long id);
	void delete(Long[] ids);
	List<CategoryModel> findAllPage(Pageble pageble);
	int totalItemInTable();
	boolean checkName(String name);
	CategoryModel findById(Long id);
	void deleteById(Long id);
}
