package javaweb.service;

import java.util.List;

import javaweb.model.ProductDetailModel;
import javaweb.paging.Pageble;

public interface IProductDetailService {

	ProductDetailModel findById(Long id);

	void deleteById(Long id);

	List<ProductDetailModel> findAllById(Long id);

	List<ProductDetailModel> findAllPageById(Pageble pageble, Long id);

	List<ProductDetailModel> findAll();

	List<ProductDetailModel> findAllPage(Pageble pageble);

	Integer totalItemInTable();

	Integer totalItemInTableById(Long id);

	boolean checkName(String name);

	void update(ProductDetailModel product);

	Long insert(ProductDetailModel product);

	boolean check(ProductDetailModel productDetail);

	int sumQtyProduct(Long productId);

	void updateQtyProduct(Long productId, int sumQty);

}
