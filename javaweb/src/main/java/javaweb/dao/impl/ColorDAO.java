package javaweb.dao.impl;

import java.util.List;

import javaweb.dao.IColorDAO;
import javaweb.mapper.ColorMapper;
import javaweb.model.ColorModel;
import javaweb.paging.Pageble;

public class ColorDAO extends AbstractDAO<ColorModel> implements IColorDAO{
	@Override
	public Long insert(ColorModel color) {
		String sql= "insert into color(name,code) values(?,?)";
		return insert(sql, color.getName(),color.getCode());
	}

	@Override
	public void update(ColorModel color) {
		String sql= "update color set name = ? , code = ?";
		update(sql, color.getName(),color.getCode());
	}

	@Override
	public void delete(Long[] ids) {
		String sql = "delete from color where id = ?";
		for(int i = 0; i<= ids.length;i++) {
			update(sql,ids[i]);
		}
		
	}

	@Override
	public List<ColorModel> findAll() {
		String sql = "select * from color";
		return query(sql, new ColorMapper());
	}
	public List<ColorModel> findAllPage(Pageble pageble) {
		StringBuilder sql = new StringBuilder("select * from color ");
		if (pageble.getSorter() != null) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
			}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("limit ?,?");
			return query(sql.toString(), new ColorMapper(), pageble.getOffset(), pageble.getLimit());
		} else {
			return query(sql.toString(), new ColorMapper());
		}

	}
	@Override
	public int totalItemInTable() {
		String sql = "select count(*) from color";
		return count(sql);
	}
}
