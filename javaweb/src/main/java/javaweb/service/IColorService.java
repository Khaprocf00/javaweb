package javaweb.service;

import java.util.List;

import javaweb.model.ColorModel;
import javaweb.paging.Pageble;

public interface IColorService {
	List<ColorModel> findAll();

	Long insert(ColorModel category);

	void update(ColorModel category, Long id);

	void delete(Long[] ids);

	List<ColorModel> findAllPage(Pageble pageble);

	int totalItemInTable();

	boolean checkName(String name);

	ColorModel findById(Long id);

	void deleteById(Long id);
}
