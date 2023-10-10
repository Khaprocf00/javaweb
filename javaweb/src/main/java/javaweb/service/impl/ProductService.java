package javaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import javaweb.dao.IProductDAO;
import javaweb.model.ProductModel;
import javaweb.paging.Pageble;
import javaweb.service.IProductService;

public class ProductService implements IProductService{

	@Inject
	private IProductDAO productDAO;
	
	@Override
	public boolean checkName(String name) {
		return productDAO.checkName(name);
	}

	@Override
	public void update(ProductModel product) {
		productDAO.update(product);
	}

	@Override
	public ProductModel findById(Long id) {
		return productDAO.findById(id);
	}

	@Override
	public Long insert(ProductModel product) {
		return productDAO.insert(product);
	}

	@Override
	public Integer totalItemInTable() {
		return productDAO.totalItemInTable();
	}

	@Override
	public List<ProductModel> findAllPage(Pageble pageble) {
		return productDAO.findAllPage(pageble);
	}

	@Override
	public List<ProductModel> findAll() {
		return productDAO.findAll();
	}

	@Override
	public void deleteById(Long id) {
		productDAO.deleteById(id);
	}
	
}
