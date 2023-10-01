package javaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import javaweb.dao.IUserDAO;
import javaweb.mapper.RowMapper;
import javaweb.model.UserModel;
import javaweb.service.IUserService;

public class UserService implements IUserService{
	
	@Inject
	private IUserDAO userDAO;
	@Override
	public UserModel findUserAndPasswordAndStatus(String username, String password, int status) {
		return userDAO.findUserAndPasswordAndStatus(username, password, status);
		
	}
	@Override
	public List<UserModel> query(String sql, RowMapper<UserModel> mapRow, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long insert(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int count(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
