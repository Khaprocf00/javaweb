package javaweb.service;

import java.util.List;

import javaweb.model.BrandModel;
import javaweb.paging.Pageble;

public interface IBrandService {
	Long insert(BrandModel brand);
	void update(BrandModel brand , Long id);
	void delete(Long[] ids);
	void deleteById(Long id);
	List<BrandModel> findAll();
	List<BrandModel> findAllPage(Pageble pageble) ;
	int totalItemInTable();
	boolean checkName(String name);
	BrandModel findById(Long id);
	
}
