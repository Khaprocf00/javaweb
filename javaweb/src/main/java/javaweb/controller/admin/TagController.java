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
import javaweb.model.TagModel;
import javaweb.paging.PageRequest;
import javaweb.paging.Pageble;
import javaweb.service.ITagService;
import javaweb.sort.Sorter;
import javaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-tag" })
public class TagController extends HttpServlet{
	private static final long serialVersionUID = -5687961477049217213L;
	@Inject
	private ITagService tagService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("insert")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/tag/add.jsp");
			rd.forward(req, resp);
		}else if(action != null && action.equals("edit")){
			TagModel tag = FormUtil.toModel(TagModel.class, req);
			tag = tagService.findById(tag.getId());
;			req.setAttribute(SystemConstant.MODEL, tag);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/tag/edit.jsp");
			rd.forward(req, resp);
		}else if(action != null && action.equals("delete")){
			TagModel tag = FormUtil.toModel(TagModel.class, req);
			tagService.deleteById(tag.getId());
			resp.sendRedirect(req.getContextPath()+"/admin-tag");
		}else {
			TagModel tag = FormUtil.toModel(TagModel.class, req);
			tag.setListResult(tagService.findAll());
			Pageble pageble = new PageRequest(tag.getPage(), tag.getMaxPageItem(),
					new Sorter(tag.getSortName(), tag.getSortBy()));
			tag.setListResult(tagService.findAllPage(pageble));
			tag.setTotalItem(tagService.totalItemInTable());
			if (tag.getTotalItem() % tag.getMaxPageItem() != 0) {
				tag.setTotalPage(
						((int) Math.ceil((double) (tag.getTotalItem() / tag.getMaxPageItem()))) + 1);
			} else {
				tag.setTotalPage((int) Math.ceil((double) (tag.getTotalItem() / tag.getMaxPageItem())));
			}
			req.setAttribute(SystemConstant.MODEL, tag);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/tag/list.jsp");
			rd.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TagModel tag = FormUtil.toModel(TagModel.class, req);
		String action = req.getParameter("action");
		if(action != null && action.equals("insert")) {
			boolean checkName = tagService.checkName(tag.getName());
			req.setAttribute("checkName", checkName);
			if(checkName) {
				req.setAttribute("oldName", tag.getName());
				tagService.insert(tag);
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/tag/add.jsp");
				rd.forward(req, resp);
				
			}else {
				req.setAttribute("oldName", tag.getName());
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/tag/add.jsp");
				rd.forward(req, resp);
			}
		}else if(action != null && action.equals("edit")) {
			Boolean check = false;
			if(tagService.checkName(tag.getName()) || tag.getName().equals(tagService.findById(tag.getId()).getName()))
			{
				check = true;
				tagService.update(tag , tag.getId());
			}
			req.setAttribute(SystemConstant.MODEL, tagService.findById(tag.getId()));
			req.setAttribute("check", check);
			req.setAttribute("oldName", tag.getName());
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/tag/edit.jsp");
			rd.forward(req, resp);
		}else
		{
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/tag/list.jsp");
			rd.forward(req, resp);
		}
	}
}
