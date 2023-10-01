package javaweb.dao.impl;

import java.util.List;

import javaweb.dao.IBrandDAO;
import javaweb.mapper.BrandMapper;
import javaweb.model.BrandModel;
import javaweb.paging.Pageble;

public class BrandDAO extends AbstractDAO<BrandModel> implements IBrandDAO {

	@Override
	public Long insert(BrandModel brand) {
		String sql = "insert into brand(name) values(?)";
		return insert(sql, brand.getName());
	}

	@Override
	public void update(BrandModel brand, Long id) {
		String sql = "update brand set name = ? where id = ?";
		update(sql, brand.getName(), id);
	}

	@Override
	public void delete(Long[] ids) {
		String sql = "delete from brand where id = ?";
		for (int i = 0; i <= ids.length; i++) {
			update(sql, ids[i]);
		}

	}

	@Override
	public List<BrandModel> findAll() {
		String sql = "select * from brand";
		return query(sql, new BrandMapper());
	}

	public List<BrandModel> findAllPage(Pageble pageble) {
		StringBuilder sql = new StringBuilder("select * from brand ");
		if (pageble.getSorter() != null) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("limit ?,?");
			return query(sql.toString(), new BrandMapper(), pageble.getOffset(), pageble.getLimit());
		} else {
			return query(sql.toString(), new BrandMapper());
		}

	}

	@Override
	public int totalItemInTable() {
		String sql = "select count(*) from brand";
		return count(sql);
	}

	@Override
	public boolean checkName(String name) {
		String sql = "select count(*) from brand where name = ?";
		if (count(sql, name) != 0)
			return false;
		return true;
	}

	@Override
	public BrandModel findById(Long id) {
		String sql = "select * from brand where id = ?";
		List<BrandModel> list = query(sql, new BrandMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from brand where id = ? ";
		update(sql, id);
	}

}
