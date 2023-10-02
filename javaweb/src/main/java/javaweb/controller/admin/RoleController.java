package javaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.constant.SystemConstant;
import javaweb.model.RoleModel;
import javaweb.paging.PageRequest;
import javaweb.paging.Pageble;
import javaweb.service.IRoleService;
import javaweb.sort.Sorter;
import javaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-role" })
public class RoleController extends HttpServlet {
	private static final long serialVersionUID = 5911958491447160991L;

	@Inject
	private IRoleService roleService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("insert")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/role/add.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("edit")) {
			RoleModel role = FormUtil.toModel(RoleModel.class, req);
			role = roleService.findById(role.getId());
			;
			req.setAttribute(SystemConstant.MODEL, role);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/role/edit.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("delete")) {
			RoleModel role = FormUtil.toModel(RoleModel.class, req);
			roleService.deleteById(role.getId());
			resp.sendRedirect(req.getContextPath() + "/admin-role");
		} else {
			RoleModel role = FormUtil.toModel(RoleModel.class, req);
			role.setListResult(roleService.findAll());
			Pageble pageble = new PageRequest(role.getPage(), role.getMaxPageItem(),
					new Sorter(role.getSortName(), role.getSortBy()));
			role.setListResult(roleService.findAllPage(pageble));
			role.setTotalItem(roleService.totalItemInTable());
			if (role.getTotalItem() % role.getMaxPageItem() != 0) {
				role.setTotalPage(
						((int) Math.ceil((double) (role.getTotalItem() / role.getMaxPageItem()))) + 1);
			} else {
				role.setTotalPage((int) Math.ceil((double) (role.getTotalItem() / role.getMaxPageItem())));
			}
			req.setAttribute(SystemConstant.MODEL, role);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/role/list.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RoleModel role = FormUtil.toModel(RoleModel.class, req);
		String action = req.getParameter("action");
		if (action != null && action.equals("insert")) {
			boolean checkName = roleService.checkName(role.getName());
			req.setAttribute("checkName", checkName);
			if (checkName) {
				req.setAttribute("role", role);
				roleService.insert(role);
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/role/add.jsp");
				rd.forward(req, resp);

			} else {
				req.setAttribute("role", role);
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/role/add.jsp");
				rd.forward(req, resp);
			}
		} else if (action != null && action.equals("edit")) {
			Boolean check = false;
			if (roleService.checkName(role.getName())
					|| role.getName().equals(roleService.findById(role.getId()).getName())) {
				check = true;
				roleService.update(role, role.getId());
			}
			req.setAttribute(SystemConstant.MODEL, roleService.findById(role.getId()));
			req.setAttribute("check", check);
			req.setAttribute("role", role);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/role/edit.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/role/list.jsp");
			rd.forward(req, resp);
		}
	}
}
