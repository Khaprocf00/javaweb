package javaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import javaweb.dao.IProductDetailDAO;
import javaweb.model.ProductDetailModel;
import javaweb.paging.Pageble;
import javaweb.service.IProductDetailService;

public class ProductDetailService implements IProductDetailService{

	@Inject
	private IProductDetailDAO productDetailDAO;
	@Override
	public ProductDetailModel findById(Long id) {
		return productDetailDAO.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		productDetailDAO.deleteById(id);
		
	}

	@Override
	public List<ProductDetailModel> findAllById(Long id) {
		return productDetailDAO.findAllById(id);
	}

	@Override
	public List<ProductDetailModel> findAllPageById(Pageble pageble, Long id) {
		return productDetailDAO.findAllPageById(pageble, id);
	}

	@Override
	public List<ProductDetailModel> findAll() {
		return productDetailDAO.findAll();
	}

	@Override
	public List<ProductDetailModel> findAllPage(Pageble pageble) {
		return productDetailDAO.findAllPage(pageble);
	}

	@Override
	public Integer totalItemInTable() {
		return productDetailDAO.totalItemInTable();
	}

	@Override
	public Integer totalItemInTableById(Long id) {
		return productDetailDAO.totalItemInTableById(id);
	}

	@Override
	public boolean checkName(String name) {
		return productDetailDAO.checkName(name);
	}

	@Override
	public void update(ProductDetailModel productDetail) {
		productDetailDAO.update(productDetail);		
	}

	@Override
	public Long insert(ProductDetailModel product) {
		return productDetailDAO.insert(product);
	}

	@Override
	public boolean check(ProductDetailModel productDetail) {
		return productDetailDAO.check(productDetail);
	}

	@Override
	public int sumQtyProduct(Long productId) {
		return productDetailDAO.sumQtyProduct(productId);
	}

	@Override
	public void updateQtyProduct(Long productId, int sumQty) {
		productDetailDAO.updateQtyProduct(productId, sumQty);		
	}
	
}
