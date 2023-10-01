package javaweb.service;

import javaweb.dao.GenericDAO;
import javaweb.model.UserModel;

public interface IUserService extends GenericDAO<UserModel> {
	UserModel findUserAndPasswordAndStatus(String username, String password, int status);
}
