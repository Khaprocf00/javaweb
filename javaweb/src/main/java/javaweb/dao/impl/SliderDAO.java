package javaweb.dao.impl;

import java.util.List;

import javaweb.dao.ISliderDAO;
import javaweb.mapper.SliderMapper;
import javaweb.model.SliderModel;
import javaweb.paging.Pageble;

public class SliderDAO extends AbstractDAO<SliderModel> implements ISliderDAO {

	@Override
	public List<SliderModel> findAll() {
		String sql = "select * from slider";
		return query(sql, new SliderMapper());
	}

	@Override
	public Long insert(SliderModel slider) {
		String sql = "insert into slider(name,image,content,createdby) values(?,?,?,?)";
		return insert(sql, slider.getName(), slider.getImage(), slider.getContent(), slider.getCreatedBy());
	}

	@Override
	public SliderModel findOne(Long id) {
		String sql = "select * from slider where id = ?";
		List<SliderModel> list = query(sql, new SliderMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void update(SliderModel slider) {
		String sql = "update slider set name = ? , image = ?, content = ? , modifiedby = ? where id = ?";
		update(sql,slider.getName(), slider.getImage(), slider.getContent(), slider.getModifiedBy() , slider.getId());
		
	}

	@Override
	public void delete(Long[] ids) {
		String sql = "delete from slider where id = ?";
		for(Long id : ids) {
			update(sql,id);
		}
		
	}
	public List<SliderModel> findAllPage(Pageble pageble) {
		StringBuilder sql = new StringBuilder("select * from slider ");
		if (pageble.getSorter() != null) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("limit ?,?");
			return query(sql.toString(), new SliderMapper(), pageble.getOffset(), pageble.getLimit());
		} else {
			return query(sql.toString(), new SliderMapper());
		}

	}

	@Override
	public int totalItemInTable() {
		String sql = "select count(*) from slider";
		return count(sql);
	}

	@Override
	public boolean checkName(String name) {
		String sql = "select count(*) from slider where name = ?";
		if (count(sql, name) != 0)
			return false;
		return true;
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from slider where id = ? ";
		update(sql, id);
	}

}
