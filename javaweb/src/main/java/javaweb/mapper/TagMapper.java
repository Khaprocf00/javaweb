package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.TagModel;

public class TagMapper implements RowMapper<TagModel>{

	@Override
	public TagModel mapRow(ResultSet resultSet) {
		TagModel tag = new TagModel();
		try {
			tag.setId(resultSet.getLong("id"));
			tag.setName(resultSet.getString("name"));
			tag.setCreatedDate(resultSet.getDate("createddate"));
			tag.setCreatedBy(resultSet.getString("createdby"));
			tag.setModifiedDate(resultSet.getDate("modifieddate"));
			tag.setModifiedBy(resultSet.getString("modifiedby"));
			return tag;
		} catch (SQLException e) {
			System.out.println("Error category mapper");
			e.printStackTrace();
		}
		return null;
	}

}
