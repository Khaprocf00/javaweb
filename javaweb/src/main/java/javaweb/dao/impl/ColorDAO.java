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
	public void update(ColorModel color, Long id) {
		String sql= "update color set name = ? , code = ? where id = ?";
		update(sql, color.getName(),color.getCode(),id);
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
	@Override
	public boolean checkName(String name) {
		String sql = "select count(*) from color where name = ?";
		if (count(sql, name) != 0)
			return false;
		return true;
	}

	@Override
	public ColorModel findById(Long id) {
		String sql = "select * from color where id = ?";
		List<ColorModel> list = query(sql, new ColorMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from color where id = ? ";
		update(sql, id);
	}

}	
