package javaweb.dao.impl;

import java.util.List;

import javaweb.dao.IUserDAO;
import javaweb.mapper.UserMapper;
import javaweb.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	public UserModel findUserAndPasswordAndStatus(String username , String password, int status){
		StringBuilder sql = new StringBuilder("select * from user as u ");
		sql.append("inner join role as r on r.id = u.role_id ");
		sql.append("where username = ? and password = ? and status = ?");
		List<UserModel> list = query(sql.toString(),new UserMapper(),username,password,status);
		return list.isEmpty()? null : list.get(0);
	}

}
