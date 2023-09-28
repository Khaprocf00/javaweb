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

@WebServlet(urlPatterns = { "/admin-new-list" })
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 5911958491447160991L;

	@Inject
	private ICategoryService categoryServlet;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
