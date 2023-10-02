package javaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import javaweb.dao.ITagDAO;
import javaweb.model.TagModel;
import javaweb.paging.Pageble;
import javaweb.service.ITagService;

public class TagService implements ITagService{

	@Inject
	private ITagDAO tagDAO;
	
	@Override
	public Long insert(TagModel tag) {
		return tagDAO.insert(tag);
	}

	@Override
	public void update(TagModel tag ,Long id) {
		tagDAO.update(tag, id);
		
	}

	@Override
	public void delete(Long[] ids) {
		tagDAO.delete(ids);
		
	}

	@Override
	public List<TagModel> findAll() {
		return tagDAO.findAll();
	}

	@Override
	public List<TagModel> findAllPage(Pageble pageble) {
		return tagDAO.findAllPage(pageble);
	}

	@Override
	public int totalItemInTable() {
		return tagDAO.totalItemInTable();
	}

	@Override
	public boolean checkName(String name) {
		return tagDAO.checkName(name);
	}

	@Override
	public TagModel findById(Long id) {
		return tagDAO.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		tagDAO.deleteById(id);
		
	}
}
