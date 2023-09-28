package javaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.service.ICategoryService;


@WebServlet(urlPatterns = {"/admin"})
public class HomeController extends HttpServlet{

	@Inject
	private ICategoryService categoryServlet;
	private static final long serialVersionUID = -6175189361695152199L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/index.jsp");
		rd.forward(req, resp);
	}
	
}
