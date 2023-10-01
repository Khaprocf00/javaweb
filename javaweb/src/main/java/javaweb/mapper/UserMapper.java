package javaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.model.RoleModel;
import javaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel user = new UserModel();
		try {
			user.setId(resultSet.getLong("id"));
			user.setUsername(resultSet.getString("username"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			user.setFullname(resultSet.getString("fullname"));
			user.setStatus(resultSet.getInt("status"));
			user.setRoleId(resultSet.getLong("role_id"));
			user.setCreatedDate(resultSet.getDate("createddate"));
			user.setCreatedBy(resultSet.getString("createdby"));
			user.setModifiedDate(resultSet.getDate("modifieddate"));
			user.setModifiedBy(resultSet.getString("modifiedby"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return user;
		} catch (SQLException e) {
			System.out.println("Error user mapper");
			e.printStackTrace();
		}
		return null;
	}

}
