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
			size.setCreatedBy(resultSet.getString("createdby"));
			size.setCreatedDate(resultSet.getDate("createddate"));
			if(resultSet.getDate("modifieddate") != null) {
				size.setModifiedDate(resultSet.getDate("modifieddate"));
			}
			if(resultSet.getString("modifiedby") != null) {
				size.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return size;
		} catch (SQLException e) {
			System.out.println("Error category mapper");
			e.printStackTrace();
		}
		return null;
	}
}