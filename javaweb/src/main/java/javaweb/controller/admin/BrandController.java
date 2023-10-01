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
import javaweb.model.BrandModel;
import javaweb.paging.PageRequest;
import javaweb.paging.Pageble;
import javaweb.service.IBrandService;
import javaweb.sort.Sorter;
import javaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-brand" })
public class BrandController extends HttpServlet {
	private static final long serialVersionUID = 5911958491447160991L;

	@Inject
	private IBrandService brandService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("insert")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/brand/add.jsp");
			rd.forward(req, resp);
		}else if(action != null && action.equals("edit")){
			BrandModel brand = FormUtil.toModel(BrandModel.class, req);
			brand = brandService.findById(brand.getId());
;			req.setAttribute(SystemConstant.MODEL, brand);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/brand/edit.jsp");
			rd.forward(req, resp);
		}else if(action != null && action.equals("delete")){
			BrandModel brand = FormUtil.toModel(BrandModel.class, req);
			brandService.deleteById(brand.getId());
			resp.sendRedirect(req.getContextPath()+"/admin-brand");
		}else {
			BrandModel brand = FormUtil.toModel(BrandModel.class, req);
			brand.setListResult(brandService.findAll());
			Pageble pageble = new PageRequest(brand.getPage(), brand.getMaxPageItem(),
					new Sorter(brand.getSortName(), brand.getSortBy()));
			brand.setListResult(brandService.findAllPage(pageble));
			brand.setTotalItem(brandService.totalItemInTable());
			if (brand.getTotalItem() % brand.getMaxPageItem() != 0) {
				brand.setTotalPage(
						((int) Math.ceil((double) (brand.getTotalItem() / brand.getMaxPageItem()))) + 1);
			} else {
				brand.setTotalPage((int) Math.ceil((double) (brand.getTotalItem() / brand.getMaxPageItem())));
			}
			req.setAttribute(SystemConstant.MODEL, brand);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/brand/list.jsp");
			rd.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BrandModel brand = FormUtil.toModel(BrandModel.class, req);
		String action = req.getParameter("action");
		if(action != null && action.equals("insert")) {
			boolean checkName = brandService.checkName(brand.getName());
			req.setAttribute("checkName", checkName);
			if(checkName) {
				req.setAttribute("oldName", brand.getName());
				brandService.insert(brand);
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/brand/add.jsp");
				rd.forward(req, resp);
				
			}else {
				req.setAttribute("oldName", brand.getName());
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/brand/add.jsp");
				rd.forward(req, resp);
			}
		}else if(action != null && action.equals("edit")) {
			Boolean check = false;
			if(brandService.checkName(brand.getName()) || brand.getName().equals(brandService.findById(brand.getId()).getName()))
			{
				check = true;
				brandService.update(brand , brand.getId());
			}
			req.setAttribute(SystemConstant.MODEL, brandService.findById(brand.getId()));
			req.setAttribute("check", check);
			req.setAttribute("oldName", brand.getName());
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/brand/edit.jsp");
			rd.forward(req, resp);
		}else
		{
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/brand/list.jsp");
			rd.forward(req, resp);
		}
	}
}
