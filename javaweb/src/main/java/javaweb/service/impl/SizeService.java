package javaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import javaweb.dao.ISizeDAO;
import javaweb.model.SizeModel;
import javaweb.paging.Pageble;
import javaweb.service.ISizeService;

public class SizeService implements ISizeService{

	@Inject
	private ISizeDAO sizeDAO;
	@Override
	public Long insert(SizeModel brand) {
		return sizeDAO.insert(brand);
	}

	@Override
	public void update(SizeModel brand ,Long id) {
		sizeDAO.update(brand, id);
		
	}

	@Override
	public void delete(Long[] ids) {
		sizeDAO.delete(ids);
		
	}

	@Override
	public List<SizeModel> findAll() {
		return sizeDAO.findAll();
	}

	@Override
	public List<SizeModel> findAllPage(Pageble pageble) {
		return sizeDAO.findAllPage(pageble);
	}

	@Override
	public int totalItemInTable() {
		return sizeDAO.totalItemInTable();
	}

	@Override
	public boolean checkName(String name) {
		return sizeDAO.checkName(name);
	}

	@Override
	public SizeModel findById(Long id) {
		return sizeDAO.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		sizeDAO.deleteById(id);
		
	}
	
}
