package javaweb.dao;

import java.util.List;

import javaweb.model.CategoryModel;
import javaweb.paging.Pageble;


public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
	Long insert(CategoryModel category);
	void Update(CategoryModel category, Long id);
	void Delete(Long[] ids);
	List<CategoryModel> findAllPage(Pageble pageble);
	int totalItemInTable();
}
