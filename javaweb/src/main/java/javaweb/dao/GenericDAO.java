package javaweb.dao;

import java.util.List;

import javaweb.mapper.RowMapper;

public interface GenericDAO<T> {
	List<T> query(String sql , RowMapper<T> mapRow, Object... parameters);
	Long insert(String sql,Object... parameters);
	void update(String sql,Object... parameters);
	int count(String sql,Object... parameters);
}
