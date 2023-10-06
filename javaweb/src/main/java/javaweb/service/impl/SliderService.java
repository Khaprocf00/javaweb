package javaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import javaweb.dao.ISliderDAO;
import javaweb.model.SliderModel;
import javaweb.paging.Pageble;
import javaweb.service.ISliderService;

public class SliderService implements ISliderService {

	@Inject
	private ISliderDAO sliderDAO;

	@Override
	public List<SliderModel> findAll() {
		return sliderDAO.findAll();
	}

	@Override
	public SliderModel save(SliderModel slider) {
		Long id = sliderDAO.insert(slider);
		return sliderDAO.findOne(id);
	}

	@Override
	public SliderModel update(SliderModel slider) {
		sliderDAO.update(slider);
		return sliderDAO.findOne(slider.getId());
	}

	@Override
	public void delete(Long[] ids) {
		sliderDAO.delete(ids);
	}

	@Override
	public SliderModel findOne(Long id) {
		return sliderDAO.findOne(id);
	}

	@Override
	public List<SliderModel> findAllPage(Pageble pageble) {
		return sliderDAO.findAllPage(pageble);
	}

	@Override
	public int totalItemInTable() {
		return sliderDAO.totalItemInTable();
	}

	@Override
	public boolean checkName(String name) {
		return sliderDAO.checkName(name);
	}

	@Override
	public void insert(SliderModel slider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		sliderDAO.deleteById(id);
		
	}

}
