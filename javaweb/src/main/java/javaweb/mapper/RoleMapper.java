package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel> {

	@Override
	public RoleModel mapRow(ResultSet resultSet) {
		RoleModel role = new RoleModel();
		try {
			role.setId(resultSet.getLong("id"));
			role.setName(resultSet.getString("name"));
			role.setCode(resultSet.getString("code"));
			role.setCreatedDate(resultSet.getDate("createddate"));
			role.setCreatedBy(resultSet.getString("createdby"));
			role.setModifiedDate(resultSet.getDate("modifieddate"));
			role.setModifiedBy(resultSet.getString("modifiedby"));
			return role;
		} catch (SQLException e) {
			System.out.println("Error role mapper");
			e.printStackTrace();
		}
		return null;
	}

}
