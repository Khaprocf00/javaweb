package javaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import javaweb.dao.IBrandDAO;
import javaweb.model.BrandModel;
import javaweb.paging.Pageble;
import javaweb.service.IBrandService;

public class BrandService implements IBrandService{

	@Inject
	private IBrandDAO brandDAO;
	@Override
	public Long insert(BrandModel brand) {
		return brandDAO.insert(brand);
	}

	@Override
	public void update(BrandModel brand ,Long id) {
		brandDAO.update(brand, id);
		
	}

	@Override
	public void delete(Long[] ids) {
		brandDAO.delete(ids);
		
	}

	@Override
	public List<BrandModel> findAll() {
		return brandDAO.findAll();
	}

	@Override
	public List<BrandModel> findAllPage(Pageble pageble) {
		return brandDAO.findAllPage(pageble);
	}

	@Override
	public int totalItemInTable() {
		return brandDAO.totalItemInTable();
	}

	@Override
	public boolean checkName(String name) {
		return brandDAO.checkName(name);
	}

	@Override
	public BrandModel findById(Long id) {
		return brandDAO.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		brandDAO.deleteById(id);
		
	}
	
}
