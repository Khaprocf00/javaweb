package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.BrandModel;

public class BrandMapper implements RowMapper<BrandModel>{
	@Override
	public BrandModel mapRow(ResultSet resultSet) {
		BrandModel brand = new BrandModel();
		try {
			brand.setId(resultSet.getLong("id"));
			brand.setName(resultSet.getString("name"));
			brand.setCreatedDate(resultSet.getDate("createddate"));
			brand.setCreatedBy(resultSet.getString("createdby"));
			brand.setModifiedDate(resultSet.getDate("modifieddate"));
			brand.setModifiedBy(resultSet.getString("modifiedby"));
			return brand;
		} catch (SQLException e) {
			System.out.println("Error category mapper");
			e.printStackTrace();
		}
		return null;
	}
}
