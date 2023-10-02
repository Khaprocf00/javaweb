package javaweb.controller.user;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.model.UserModel;
import javaweb.service.IUserService;
import javaweb.utils.FormUtil;
import javaweb.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap","/thoat" })
public class HomeController extends HttpServlet {

	ResourceBundle mybundle = ResourceBundle.getBundle("message");
	
	@Inject
	private IUserService userService;
	
	private static final long serialVersionUID = -6175189361695152199L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			String message = req.getParameter("message");
			String alert = req.getParameter("alert");
			if(alert!=null && message!=null) {
				req.setAttribute("alert", alert);
				req.setAttribute("message", mybundle.getString(message));
			}
			RequestDispatcher rd = req.getRequestDispatcher("/views/login/login.jsp");
			rd.forward(req, resp);
		}else if(action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath()+"/trang-chu");
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/index.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, req);
			model = userService.findUserAndPasswordAndStatus(model.getUsername(), model.getPassword(), 1);
			if(model!=null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", model);;
				if(model.getRole().getCode().equals("user")) {
					resp.sendRedirect(req.getContextPath()+"/trang-chu");
				}
				else if(model.getRole().getCode().equals("admin")) {
					resp.sendRedirect(req.getContextPath()+"/admin");
				}
			}else {
				resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=user_pass_invalid&alert=danger");
			}
		}
	}
}
