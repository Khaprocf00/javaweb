package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.SizeModel;

public class SizeMapper implements RowMapper<SizeModel> {
	@Override
	public SizeModel mapRow(ResultSet resultSet) {
		SizeModel size = new SizeModel();
		try {
			size.setId(resultSet.getLong("id"));
			size.setName(resultSet.getString("name"));
			size.setCreatedDate(resultSet.getDate("createddate"));
			size.setCreatedBy(resultSet.getString("createdby"));
			size.setModifiedDate(resultSet.getDate("modifieddate"));
			size.setModifiedBy(resultSet.getString("modifiedby"));
			return size;
		} catch (SQLException e) {
			System.out.println("Error category mapper");
			e.printStackTrace();
		}
		return null;
	}
}