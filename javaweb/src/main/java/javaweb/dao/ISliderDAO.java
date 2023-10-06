package javaweb.dao;

import java.util.List;

import javaweb.model.SliderModel;
import javaweb.paging.Pageble;

public interface ISliderDAO extends GenericDAO<SliderModel> {
	SliderModel findOne(Long id);
	List<SliderModel> findAll();
	Long insert(SliderModel slider);
	void update(SliderModel slider);
	void delete(Long[] ids);
	List<SliderModel> findAllPage(Pageble pageble);
	int totalItemInTable();
	boolean checkName(String name);
	void deleteById(Long id);
}
