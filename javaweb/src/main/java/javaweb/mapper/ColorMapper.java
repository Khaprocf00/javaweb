package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.ColorModel;

public class ColorMapper implements RowMapper<ColorModel>{

	@Override
	public ColorModel mapRow(ResultSet resultSet) {
		ColorModel color = new ColorModel();
		try {
			color.setId(resultSet.getLong("id"));
			color.setName(resultSet.getString("name"));
			color.setCode(resultSet.getString("code"));
			color.setCreatedDate(resultSet.getDate("createddate"));
			color.setCreatedBy(resultSet.getString("createdby"));
			color.setModifiedDate(resultSet.getDate("modifieddate"));
			color.setModifiedBy(resultSet.getString("modifiedby"));
			return color;
		} catch (SQLException e) {
			System.out.println("Error category mapper");
			e.printStackTrace();
		}
		return null;
	}
	
}
