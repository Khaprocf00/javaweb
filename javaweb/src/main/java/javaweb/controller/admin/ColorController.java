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
import javaweb.model.ColorModel;
import javaweb.paging.PageRequest;
import javaweb.paging.Pageble;
import javaweb.service.IColorService;
import javaweb.sort.Sorter;
import javaweb.utils.FormUtil;


@WebServlet(urlPatterns = {"/admin-color"})
public class ColorController extends HttpServlet {

	private static final long serialVersionUID = -3920315746237341494L;

	@Inject
	private IColorService colorService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("insert")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/color/add.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("edit")) {
			ColorModel color = FormUtil.toModel(ColorModel.class, req);
			color = colorService.findById(color.getId());
			;
			req.setAttribute(SystemConstant.MODEL, color);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/color/edit.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("delete")) {
			ColorModel color = FormUtil.toModel(ColorModel.class, req);
			colorService.deleteById(color.getId());
			resp.sendRedirect(req.getContextPath() + "/admin-color");
		} else {
			ColorModel color = FormUtil.toModel(ColorModel.class, req);
			color.setListResult(colorService.findAll());
			Pageble pageble = new PageRequest(color.getPage(), color.getMaxPageItem(),
					new Sorter(color.getSortName(), color.getSortBy()));
			color.setListResult(colorService.findAllPage(pageble));
			color.setTotalItem(colorService.totalItemInTable());
			if (color.getTotalItem() % color.getMaxPageItem() != 0) {
				color.setTotalPage(((int) Math.ceil((double) (color.getTotalItem() / color.getMaxPageItem()))) + 1);
			} else {
				color.setTotalPage((int) Math.ceil((double) (color.getTotalItem() / color.getMaxPageItem())));
			}
			req.setAttribute(SystemConstant.MODEL, color);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/color/list.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ColorModel color = FormUtil.toModel(ColorModel.class, req);
		String action = req.getParameter("action");
		if (action != null && action.equals("insert")) {
			boolean checkName = colorService.checkName(color.getName());
			req.setAttribute("checkName", checkName);
			if (checkName) {
				req.setAttribute("color", color);
				colorService.insert(color);
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/color/add.jsp");
				rd.forward(req, resp);

			} else {
				req.setAttribute("color", color);
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/color/add.jsp");
				rd.forward(req, resp);
			}
		} else if (action != null && action.equals("edit")) {
			Boolean check = false;
			if (colorService.checkName(color.getName())
					|| color.getName().equals(colorService.findById(color.getId()).getName())) {
				check = true;
				colorService.update(color, color.getId());
			}
			req.setAttribute(SystemConstant.MODEL, colorService.findById(color.getId()));
			req.setAttribute("check", check);
			req.setAttribute("color", color);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/color/edit.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/color/list.jsp");
			rd.forward(req, resp);
		}
	}
}
