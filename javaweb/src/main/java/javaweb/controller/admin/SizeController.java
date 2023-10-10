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
import javaweb.model.SizeModel;
import javaweb.paging.PageRequest;
import javaweb.paging.Pageble;
import javaweb.service.ISizeService;
import javaweb.sort.Sorter;
import javaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-size" })
public class SizeController extends HttpServlet{
	private static final long serialVersionUID = -5687961477049217213L;
	@Inject
	private ISizeService sizeService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("insert")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/size/add.jsp");
			rd.forward(req, resp);
		}else if(action != null && action.equals("edit")){
			SizeModel size = FormUtil.toModel(SizeModel.class, req);
			size = sizeService.findById(size.getId());
;			req.setAttribute(SystemConstant.MODEL, size);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/size/edit.jsp");
			rd.forward(req, resp);
		}else if(action != null && action.equals("delete")){
			SizeModel size = FormUtil.toModel(SizeModel.class, req);
			sizeService.deleteById(size.getId());
			resp.sendRedirect(req.getContextPath()+"/admin-size");
		}else {
			SizeModel size = FormUtil.toModel(SizeModel.class, req);
			size.setListResult(sizeService.findAll());
			Pageble pageble = new PageRequest(size.getPage(), size.getMaxPageItem(),
					new Sorter(size.getSortName(), size.getSortBy()));
			size.setListResult(sizeService.findAllPage(pageble));
			size.setTotalItem(sizeService.totalItemInTable());
			if (size.getTotalItem() % size.getMaxPageItem() != 0) {
				size.setTotalPage(
						((int) Math.ceil((double) (size.getTotalItem() / size.getMaxPageItem()))) + 1);
			} else {
				size.setTotalPage((int) Math.ceil((double) (size.getTotalItem() / size.getMaxPageItem())));
			}
			req.setAttribute(SystemConstant.MODEL, size);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/size/list.jsp");
			rd.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SizeModel size = FormUtil.toModel(SizeModel.class, req);
		String action = req.getParameter("action");
		if(action != null && action.equals("insert")) {
			String x = req.getParameter("text");
			req.setAttribute("text", x);
			boolean checkName = sizeService.checkName(size.getName());
			req.setAttribute("checkName", checkName);
			if(checkName) {
				req.setAttribute("oldName", size.getName());
				sizeService.insert(size);
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/size/add.jsp");
				rd.forward(req, resp);
				
			}else {
				req.setAttribute("oldName", size.getName());
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/size/add.jsp");
				rd.forward(req, resp);
			}
		}else if(action != null && action.equals("edit")) {
			Boolean check = false;
			if(sizeService.checkName(size.getName()) || size.getName().equals(sizeService.findById(size.getId()).getName()))
			{
				check = true;
				sizeService.update(size , size.getId());
			}
			req.setAttribute(SystemConstant.MODEL, sizeService.findById(size.getId()));
			req.setAttribute("check", check);
			req.setAttribute("oldName", size.getName());
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/size/edit.jsp");
			rd.forward(req, resp);
		}else
		{
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/size/list.jsp");
			rd.forward(req, resp);
		}
	}
}
