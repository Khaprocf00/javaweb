package javaweb.service;

import java.util.List;

import javaweb.model.RoleModel;
import javaweb.paging.Pageble;

public interface IRoleService {
	List<RoleModel> findAll();
	Long insert(RoleModel category);
	void update(RoleModel category , Long id);
	void delete(Long[] ids);
	List<RoleModel> findAllPage(Pageble pageble);
	int totalItemInTable();
	boolean checkName(String name);
	RoleModel findById(Long id);
	void deleteById(Long id);
}
