package javaweb.service;

import java.util.List;

import javaweb.model.SliderModel;
import javaweb.paging.Pageble;

public interface ISliderService {
	List<SliderModel> findAll();
	SliderModel save(SliderModel slider);
	SliderModel update(SliderModel slider);
	void delete(Long[] ids);
	SliderModel findOne(Long id);
	List<SliderModel> findAllPage(Pageble pageble);
	int totalItemInTable();
	boolean checkName(String name);
	void insert(SliderModel slider);
	void deleteById(Long id);
}
