package javaweb.service;

import java.util.List;

import javaweb.model.SizeModel;
import javaweb.paging.Pageble;

public interface ISizeService {
	Long insert(SizeModel brand);

	void update(SizeModel brand, Long id);

	void delete(Long[] ids);

	void deleteById(Long id);

	List<SizeModel> findAll();

	List<SizeModel> findAllPage(Pageble pageble);

	int totalItemInTable();

	boolean checkName(String name);

	SizeModel findById(Long id);
}
