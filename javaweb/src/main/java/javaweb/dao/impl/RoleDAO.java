package javaweb.dao.impl;

import java.util.List;

import javaweb.dao.IRoleDAO;
import javaweb.mapper.RoleMapper;
import javaweb.model.RoleModel;
import javaweb.paging.Pageble;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO{
	@Override
	public List<RoleModel> findAll() {
		String sql = "select * from role";
		return query(sql, new RoleMapper());
	}

	@Override
	public Long insert(RoleModel role) {
		String sql = "insert into role(name,code) values(?,?)";
		return insert(sql, role.getName(), role.getCode());
	}

	@Override
	public void update(RoleModel role, Long id) {
		String sql = "update role set name = ? , code = ? where id = ?";
		update(sql, role.getName(), role.getCode(), id);
	}

	@Override
	public void delete(Long[] ids) {
		String sql = "delete from role where id = ?";
		for (int i = 0; i < ids.length; i++) {
			update(sql, ids[i]);
		}
	}

	@Override
	public List<RoleModel> findAllPage(Pageble pageble) {
		StringBuilder sql = new StringBuilder("select * from role ");
		if (pageble.getSorter() != null) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("limit ?,?");
			return query(sql.toString(), new RoleMapper(), pageble.getOffset(), pageble.getLimit());
		} else {
			return query(sql.toString(), new RoleMapper());
		}

	}

	@Override
	public int totalItemInTable() {
		String sql = "select count(*) from role";
		return count(sql);
	}

	@Override
	public boolean checkName(String name) {
		String sql = "select count(*) from role where name = ?";
		if (count(sql, name) != 0)
			return false;
		return true;
	}

	@Override
	public RoleModel findById(Long id) {
		String sql = "select * from role where id = ?";
		List<RoleModel> list = query(sql, new RoleMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from role where id = ? ";
		update(sql, id);
	}
}
