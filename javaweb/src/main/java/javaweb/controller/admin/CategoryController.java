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
import javaweb.model.CategoryModel;
import javaweb.paging.PageRequest;
import javaweb.paging.Pageble;
import javaweb.service.ICategoryService;
import javaweb.sort.Sorter;
import javaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-category" })
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 5911958491447160991L;

	@Inject
	private ICategoryService categoryServlet;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("insert")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category/add.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("edit")) {
			CategoryModel category = FormUtil.toModel(CategoryModel.class, req);
			category = categoryServlet.findById(category.getId());
			;
			req.setAttribute(SystemConstant.MODEL, category);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category/edit.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("delete")) {
			CategoryModel category = FormUtil.toModel(CategoryModel.class, req);
			categoryServlet.deleteById(category.getId());
			resp.sendRedirect(req.getContextPath() + "/admin-category");
		} else {
			CategoryModel category = FormUtil.toModel(CategoryModel.class, req);
			category.setListResult(categoryServlet.findAll());
			Pageble pageble = new PageRequest(category.getPage(), category.getMaxPageItem(),
					new Sorter(category.getSortName(), category.getSortBy()));
			category.setListResult(categoryServlet.findAllPage(pageble));
			category.setTotalItem(categoryServlet.totalItemInTable());
			if (category.getTotalItem() % category.getMaxPageItem() != 0) {
				category.setTotalPage(
						((int) Math.ceil((double) (category.getTotalItem() / category.getMaxPageItem()))) + 1);
			} else {
				category.setTotalPage((int) Math.ceil((double) (category.getTotalItem() / category.getMaxPageItem())));
			}
			req.setAttribute(SystemConstant.MODEL, category);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category/list.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryModel category = FormUtil.toModel(CategoryModel.class, req);
		String action = req.getParameter("action");
		if (action != null && action.equals("insert")) {
			boolean checkName = categoryServlet.checkName(category.getName());
			req.setAttribute("checkName", checkName);
			if (checkName) {
				req.setAttribute("category", category);
				categoryServlet.insert(category);
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category/add.jsp");
				rd.forward(req, resp);

			} else {
				req.setAttribute("category", category);
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category/add.jsp");
				rd.forward(req, resp);
			}
		} else if (action != null && action.equals("edit")) {
			Boolean check = false;
			if (categoryServlet.checkName(category.getName())
					|| category.getName().equals(categoryServlet.findById(category.getId()).getName())) {
				check = true;
				categoryServlet.update(category, category.getId());
			}
			req.setAttribute(SystemConstant.MODEL, categoryServlet.findById(category.getId()));
			req.setAttribute("check", check);
			req.setAttribute("category", category);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category/edit.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category/list.jsp");
			rd.forward(req, resp);
		}
	}
}
