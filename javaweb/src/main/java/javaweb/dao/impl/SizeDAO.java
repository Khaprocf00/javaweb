package javaweb.dao.impl;

import java.util.List;

import javaweb.dao.ISizeDAO;
import javaweb.mapper.SizeMapper;
import javaweb.model.SizeModel;
import javaweb.paging.Pageble;

public class SizeDAO extends AbstractDAO<SizeModel> implements ISizeDAO {
	@Override
	public Long insert(SizeModel size) {
		String sql = "insert into size(name) values(?)";
		return insert(sql, size.getName());
	}

	@Override
	public void update(SizeModel size, Long id) {
		String sql = "update size set name = ? where id = ?";
		update(sql, size.getName(), id);
	}

	@Override
	public void delete(Long[] ids) {
		String sql = "delete from size where id = ?";
		for (int i = 0; i <= ids.length; i++) {
			update(sql, ids[i]);
		}

	}

	@Override
	public List<SizeModel> findAll() {
		String sql = "select * from size";
		return query(sql, new SizeMapper());
	}

	public List<SizeModel> findAllPage(Pageble pageble) {
		StringBuilder sql = new StringBuilder("select * from size ");
		if (pageble.getSorter() != null) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("limit ?,?");
			return query(sql.toString(), new SizeMapper(), pageble.getOffset(), pageble.getLimit());
		} else {
			return query(sql.toString(), new SizeMapper());
		}

	}

	@Override
	public int totalItemInTable() {
		String sql = "select count(*) from size";
		return count(sql);
	}

	@Override
	public boolean checkName(String name) {
		String sql = "select count(*) from size where name = ?";
		if (count(sql, name) != 0)
			return false;
		return true;
	}

	@Override
	public SizeModel findById(Long id) {
		String sql = "select * from size where id = ?";
		List<SizeModel> list = query(sql, new SizeMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from size where id = ? ";
		update(sql, id);
	}
}
