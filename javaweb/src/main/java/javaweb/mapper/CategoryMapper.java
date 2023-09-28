package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		CategoryModel category = new CategoryModel();
		try {
			category.setId(resultSet.getLong("id"));
			category.setName(resultSet.getString("name"));
			category.setCode(resultSet.getString("code"));
			category.setCreatedDate(resultSet.getDate("createddate"));
			category.setCreatedBy(resultSet.getString("createdby"));
			category.setModifiedDate(resultSet.getDate("modifieddate"));
			category.setModifiedBy(resultSet.getString("modifiedby"));
			return category;
		} catch (SQLException e) {
			System.out.println("Error category mapper");
			e.printStackTrace();
		}
		return null;
	}

}
