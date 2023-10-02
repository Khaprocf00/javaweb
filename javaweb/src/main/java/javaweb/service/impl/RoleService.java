package javaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import javaweb.dao.IRoleDAO;
import javaweb.model.RoleModel;
import javaweb.paging.Pageble;
import javaweb.service.IRoleService;

public class RoleService implements IRoleService{
	@Inject
	private IRoleDAO roleDAO;

	@Override
	public List<RoleModel> findAll() {
		return roleDAO.findAll();
	}

	@Override
	public Long insert(RoleModel category) {
		return roleDAO.insert(category);
	}

	@Override
	public void update(RoleModel category, Long id) {
		roleDAO.update(category, id);
	}

	@Override
	public void delete(Long[] ids) {
		roleDAO.delete(ids);
	}

	@Override
	public List<RoleModel> findAllPage(Pageble pageble) {
		return roleDAO.findAllPage(pageble);
	}

	@Override
	public int totalItemInTable() {
		return roleDAO.totalItemInTable();
	}

	@Override
	public boolean checkName(String name) {
		return roleDAO.checkName(name);
	}

	@Override
	public RoleModel findById(Long id) {
		return roleDAO.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		roleDAO.deleteById(id);

	}
}
