package javaweb.dao.impl;

import java.util.List;

import javaweb.dao.ITagDAO;
import javaweb.mapper.TagMapper;
import javaweb.model.TagModel;
import javaweb.paging.Pageble;

public class TagDAO extends AbstractDAO<TagModel> implements ITagDAO {

	@Override
	public Long insert(TagModel tag) {
		String sql = "insert into tag(name) values(?)";
		return insert(sql, tag.getName());
	}

	@Override
	public void update(TagModel tag, Long id) {
		String sql = "update tag set name = ? where id = ?";
		update(sql, tag.getName(), id);
	}

	@Override
	public void delete(Long[] ids) {
		String sql = "delete from tag where id = ?";
		for (int i = 0; i <= ids.length; i++) {
			update(sql, ids[i]);
		}

	}

	@Override
	public List<TagModel> findAll() {
		String sql = "select * from tag";
		return query(sql, new TagMapper());
	}

	public List<TagModel> findAllPage(Pageble pageble) {
		StringBuilder sql = new StringBuilder("select * from tag ");
		if (pageble.getSorter() != null) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("limit ?,?");
			return query(sql.toString(), new TagMapper(), pageble.getOffset(), pageble.getLimit());
		} else {
			return query(sql.toString(), new TagMapper());
		}

	}

	@Override
	public int totalItemInTable() {
		String sql = "select count(*) from tag";
		return count(sql);
	}

	@Override
	public boolean checkName(String name) {
		String sql = "select count(*) from tag where name = ?";
		if (count(sql, name) != 0)
			return false;
		return true;
	}

	@Override
	public TagModel findById(Long id) {
		String sql = "select * from tag where id = ?";
		List<TagModel> list = query(sql, new TagMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from tag where id = ? ";
		update(sql, id);
	}

}
