package javaweb.dao.impl;

import javaweb.dao.IBrandDAO;
import javaweb.model.BrandModel;

public class BrandDAO extends AbstractDAO<BrandModel> implements IBrandDAO{

	@Override
	public Long insert(BrandModel brand) {
		String sql= "insert into brand(name) values(?)";
		return insert(sql, brand.getName());
	}
	
}
