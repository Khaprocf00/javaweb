package javaweb.dao;

import javaweb.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{
	UserModel findUserAndPasswordAndStatus(String username , String password, int status);
}
