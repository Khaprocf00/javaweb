package javaweb.dao.impl;

import java.util.List;

import javaweb.dao.IProductDetailDAO;
import javaweb.mapper.ProductDetailMapper;
import javaweb.model.ProductDetailModel;
import javaweb.paging.Pageble;

public class ProductDetailDAO extends AbstractDAO<ProductDetailModel> implements IProductDetailDAO{
	@Override
	public List<ProductDetailModel> findAll() {
		String sql = "select * from product_detail";
		return query(sql, new ProductDetailMapper());
	}

	@Override
	public Long insert(ProductDetailModel productDetail) {
		String sql = "insert into product_detail(product_id,color_id,size_id,qty) values(?,?,?,?)";
		Long id = insert(sql, productDetail.getProductId(),productDetail.getColorId(), productDetail.getSizeId(), productDetail.getQty());
		return id;
	}

	@Override
	public void update(ProductDetailModel productDetail) {
		String sql = "update product_detail set product_id = ? , color_id = ?,size_id = ? , qty = ? where id = ?";
		update(sql, productDetail.getProductId(),productDetail.getColorId(), productDetail.getSizeId(), productDetail.getQty() , productDetail.getId());
	}

	@Override
	public List<ProductDetailModel> findAllPage(Pageble pageble) {
		StringBuilder sql = new StringBuilder("select * from product_detail ");
		if (pageble.getSorter() != null) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("limit ?,?");
			return query(sql.toString(), new ProductDetailMapper(), pageble.getOffset(), pageble.getLimit());
		} else {
			return query(sql.toString(), new ProductDetailMapper());
		}

	}
	@Override
	public List<ProductDetailModel> findAllPageById(Pageble pageble,Long productId) {
		StringBuilder sql = new StringBuilder("select * from product_detail where product_id = ? ");
		if (pageble.getSorter() != null) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("limit ?,?");
			return query(sql.toString(), new ProductDetailMapper(),productId, pageble.getOffset(), pageble.getLimit());
		} else {
			return query(sql.toString(), new ProductDetailMapper(), productId);
		}

	}

	@Override
	public Integer totalItemInTable() {
		String sql = "select count(*) from product_detail";
		return count(sql);
	}

	

	@Override
	public ProductDetailModel findById(Long productId) {
		String sql = "select * from product_detail where id = ?";
		List<ProductDetailModel> list = query(sql, new ProductDetailMapper(), productId);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from product_detail where id = ? ";
		update(sql, id);
	}

	@Override
	public List<ProductDetailModel> findAllById(Long productId) {
		String sql = "select * from product_detail where product_id = ?";
		return query(sql, new ProductDetailMapper() , productId);
	}

	@Override
	public Integer totalItemInTableById(Long productId) {
		String sql = "select count(*) from product_detail where product_id = ?";
		return count(sql , productId);
	}

	@Override
	public boolean check(ProductDetailModel productDetail) {
		String sql = "select count(*) from product_detail  where product_id= ? and color_id = ? and size_id = ?";
		if (count(sql,productDetail.getProductId(), productDetail.getColorId(), productDetail.getSizeId()) != 0)
			return false;
		return true;
	}

	@Override
	public int sumQtyProduct(Long productId) {
		String sql = "select sum(qty) from product_detail where product_id = ?";
		return count(sql , productId);
	}

	@Override
	public void updateQtyProduct(Long productId, int sumQty) {
		String sql = "update product set qty = ? where id = ?";
		update(sql, sumQty , productId);
		
	}

	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		return false;
	}
}
