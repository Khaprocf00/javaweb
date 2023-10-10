package javaweb.service;

import java.util.List;

import javaweb.model.ProductModel;
import javaweb.paging.Pageble;

public interface IProductService {

	boolean checkName(String name);

	void update(ProductModel product);

	ProductModel findById(Long id);

	Long insert(ProductModel product);

	Integer totalItemInTable();

	List<ProductModel> findAllPage(Pageble pageble);

	List<ProductModel> findAll();

	void deleteById(Long id);

}
