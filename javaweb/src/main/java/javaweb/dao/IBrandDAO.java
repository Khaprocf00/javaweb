package javaweb.dao;

import javaweb.model.BrandModel;

public interface IBrandDAO extends GenericDAO<BrandModel>{
	Long insert(BrandModel brand);
}
