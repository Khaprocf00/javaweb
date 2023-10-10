package javaweb.dao.impl;

import java.util.List;

import javaweb.dao.IProductDAO;
import javaweb.mapper.ProductMapper;
import javaweb.model.ProductModel;
import javaweb.paging.Pageble;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {
	@Override
	public List<ProductModel> findAll() {
		String sql = "select * from product";
		return query(sql, new ProductMapper());
	}

	@Override
	public Long insert(ProductModel product) {
		String sql = "insert into product(name,price,discount,shortdescription,sku,image_path,content,category_id,slider_id,brand_id,tag_id) values(?,?,?,?,?,?,?,?,?,?,?)";
		Long id = insert(sql, product.getName(), product.getPrice(), product.getDiscount(), product.getShortDescription(),
				product.getSku(), product.getImagePath(), product.getContent(),
				product.getCategoryId(), product.getSliderId(), product.getBrandId(), product.getTagId());
		return id;
	}

	@Override
	public void update(ProductModel product) {
		String sql = "update product set name = ? , price = ?,discount = ? , shortdescription = ?,qty = ? , sku = ?,image_path = ? , content = ?,category_id = ? , slider_id = ?,brand_id = ? , tag_id = ? where id = ?";
		update(sql, product.getName(), product.getPrice(), product.getDiscount(), product.getShortDescription(),
				product.getQty(), product.getSku(), product.getImagePath(), product.getContent(),
				product.getCategoryId(), product.getSliderId(), product.getBrandId(), product.getTagId(), product.getId());
	}

	@Override
	public List<ProductModel> findAllPage(Pageble pageble) {
		StringBuilder sql = new StringBuilder("select * from product ");
		if (pageble.getSorter() != null) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("limit ?,?");
			return query(sql.toString(), new ProductMapper(), pageble.getOffset(), pageble.getLimit());
		} else {
			return query(sql.toString(), new ProductMapper());
		}

	}

	@Override
	public Integer totalItemInTable() {
		String sql = "select count(*) from product";
		return count(sql);
	}

	@Override
	public boolean checkName(String name) {
		String sql = "select count(*) from product where name = ?";
		if (count(sql, name) != 0)
			return false;
		return true;
	}

	@Override
	public ProductModel findById(Long id) {
		String sql = "select * from product where id = ?";
		List<ProductModel> list = query(sql, new ProductMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from product where id = ? ";
		update(sql, id);
	}

}
