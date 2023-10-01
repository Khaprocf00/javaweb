package javaweb.dao;

import java.util.List;

import javaweb.model.ColorModel;
import javaweb.paging.Pageble;

public interface IColorDAO extends GenericDAO<ColorModel>{
	Long insert(ColorModel color);
	void update(ColorModel color);
	void delete(Long[] ids);
	List<ColorModel> findAll();
	List<ColorModel> findAllPage(Pageble pageble) ;
	int totalItemInTable();
}
