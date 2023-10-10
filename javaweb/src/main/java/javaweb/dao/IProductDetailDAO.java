package javaweb.dao;

import java.util.List;

import javaweb.model.ProductDetailModel;
import javaweb.paging.Pageble;

public interface IProductDetailDAO extends GenericDAO<ProductDetailModel> {
	ProductDetailModel findById(Long id);

	void deleteById(Long id);

	List<ProductDetailModel> findAllById(Long productId);

	List<ProductDetailModel> findAllPageById(Pageble pageble, Long productId);

	List<ProductDetailModel> findAll();

	List<ProductDetailModel> findAllPage(Pageble pageble);

	Integer totalItemInTable();

	Integer totalItemInTableById(Long productId);

	boolean checkName(String name);

	void update(ProductDetailModel productDetail);

	Long insert(ProductDetailModel productDetail);

	boolean check(ProductDetailModel productDetail);

	int sumQtyProduct(Long productId);
	
	void updateQtyProduct(Long productId, int sumQty);
}
