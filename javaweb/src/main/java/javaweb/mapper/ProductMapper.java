package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.ProductModel;

public class ProductMapper implements RowMapper<ProductModel> {

	@Override
	public ProductModel mapRow(ResultSet resultSet) {
		ProductModel product = new ProductModel();
		try {
			product.setId(resultSet.getLong("id"));
			product.setName(resultSet.getString("name"));
			product.setShortDescription(resultSet.getString("shortDescription"));
			product.setSku(resultSet.getString("sku"));
			product.setImagePath(resultSet.getString("image_path"));
			product.setContent(resultSet.getString("content"));
			product.setPrice(resultSet.getDouble("price"));
			product.setDiscount(resultSet.getDouble("discount"));
			product.setQty(resultSet.getInt("qty"));
			product.setCategoryId(resultSet.getLong("category_id"));
			product.setSliderId(resultSet.getLong("slider_id"));
			product.setBrandId(resultSet.getLong("brand_id"));
			product.setTagId(resultSet.getLong("tag_id"));
			return product;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
