package javaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import javaweb.dao.IColorDAO;
import javaweb.model.ColorModel;
import javaweb.paging.Pageble;
import javaweb.service.IColorService;

public class ColorService implements IColorService{

	@Inject
	private IColorDAO colorDAO;
	
	@Override
	public List<ColorModel> findAll() {
		return colorDAO.findAll();
	}

	@Override
	public Long insert(ColorModel category) {
		return colorDAO.insert(category);
	}

	@Override
	public void update(ColorModel category, Long id) {
		colorDAO.update(category, id);
	}

	@Override
	public void delete(Long[] ids) {
		colorDAO.delete(ids);
	}

	@Override
	public List<ColorModel> findAllPage(Pageble pageble) {
		return colorDAO.findAllPage(pageble);
	}

	@Override
	public int totalItemInTable() {
		return colorDAO.totalItemInTable();
	}

	@Override
	public boolean checkName(String name) {
		return colorDAO.checkName(name);
	}

	@Override
	public ColorModel findById(Long id) {
		return colorDAO.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		colorDAO.deleteById(id);
		
	}
	
}
