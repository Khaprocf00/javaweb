package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.SliderModel;

public class SliderMapper implements RowMapper<SliderModel>{

	@Override
	public SliderModel mapRow(ResultSet resultSet) {
		SliderModel slider = new SliderModel();
		try {
			slider.setId(resultSet.getLong("id"));
			slider.setName(resultSet.getString("name"));
			slider.setImage(resultSet.getString("image"));
			slider.setContent(resultSet.getString("content"));
			slider.setCreatedBy(resultSet.getString("createdby"));
			slider.setCreatedDate(resultSet.getDate("createddate"));
			if(resultSet.getDate("modifieddate") != null) {
				slider.setModifiedDate(resultSet.getDate("modifieddate"));
			}
			if(resultSet.getString("modifiedby") != null) {
				slider.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return slider;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}
