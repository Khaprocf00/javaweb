package javaweb.controller.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.constant.SystemConstant;
import javaweb.service.ICategoryService;

@WebServlet(urlPatterns = { "/trang-chu" })
public class HomeController extends HttpServlet {

	@Inject
	private ICategoryService categoryService;

	private static final long serialVersionUID = -6175189361695152199L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		CategoryModel category = new CategoryModel();
//		category.setCode("the-man");
//		category.setName("the man");
//		Long id = categoryService.insert(category);
//		System.out.println(id);

//		CategoryModel category = new CategoryModel();
//		category.setCode("the-girl");
//		category.setName("the man girl");
//		Long id = 8L;
//		categoryService.update(category, id);

		
//		Long[] ids = { 6L, 7L, 8L };
//		categoryService.delete(ids);
		
		req.setAttribute(SystemConstant.MODEL, categoryService.findAll());
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/index.jsp");
		rd.forward(req, resp);
	}
}
