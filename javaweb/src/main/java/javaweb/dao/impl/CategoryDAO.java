package javaweb.dao.impl;

import java.util.List;

import javaweb.dao.ICategoryDAO;
import javaweb.mapper.CategoryMapper;
import javaweb.model.CategoryModel;
import javaweb.paging.Pageble;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public Long insert(CategoryModel category) {
		String sql = "insert into category(name,code) values(?,?)";
		return insert(sql, category.getName(), category.getCode());
	}

	@Override
	public void update(CategoryModel category, Long id) {
		String sql = "update category set name = ? , code = ? where id = ?";
		update(sql, category.getName(), category.getCode(), id);
	}

	@Override
	public void delete(Long[] ids) {
		String sql = "delete from category where id = ?";
		for (int i = 0; i < ids.length; i++) {
			update(sql, ids[i]);
		}
	}

	@Override
	public List<CategoryModel> findAllPage(Pageble pageble) {
		StringBuilder sql = new StringBuilder("select * from category ");
		if (pageble.getSorter() != null) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("limit ?,?");
			return query(sql.toString(), new CategoryMapper(), pageble.getOffset(), pageble.getLimit());
		} else {
			return query(sql.toString(), new CategoryMapper());
		}

	}

	@Override
	public int totalItemInTable() {
		String sql = "select count(*) from category";
		return count(sql);
	}

	@Override
	public boolean checkName(String name) {
		String sql = "select count(*) from category where name = ?";
		if (count(sql, name) != 0)
			return false;
		return true;
	}

	@Override
	public CategoryModel findById(Long id) {
		String sql = "select * from category where id = ?";
		List<CategoryModel> list = query(sql, new CategoryMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from category where id = ? ";
		update(sql, id);
	}
}
