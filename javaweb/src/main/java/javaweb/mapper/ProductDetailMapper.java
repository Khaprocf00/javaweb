package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.ProductDetailModel;

public class ProductDetailMapper implements RowMapper<ProductDetailModel>{

	@Override
	public ProductDetailModel mapRow(ResultSet resultSet) {
		ProductDetailModel productDeatil = new ProductDetailModel();
		try {
			productDeatil.setId(resultSet.getLong("id"));
			productDeatil.setProductId(resultSet.getLong("product_id"));
			productDeatil.setColorId(resultSet.getLong("color_id"));
			productDeatil.setSizeId(resultSet.getLong("size_id"));
			productDeatil.setQty(resultSet.getInt("qty"));
			productDeatil.setCreatedBy(resultSet.getString("createdby"));
			productDeatil.setCreatedDate(resultSet.getDate("createddate"));
			if(resultSet.getDate("modifieddate") != null) {
				productDeatil.setModifiedDate(resultSet.getDate("modifieddate"));
			}
			if(resultSet.getString("modifiedby") != null) {
				productDeatil.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return productDeatil;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
