package javaweb.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import javaweb.constant.SystemConstant;
import javaweb.model.SliderModel;
import javaweb.paging.PageRequest;
import javaweb.paging.Pageble;
import javaweb.service.ISliderService;
import javaweb.sort.Sorter;
import javaweb.utils.FormUtil;

@MultipartConfig
@WebServlet(urlPatterns = { "/admin-slider" })
public class SliderController extends HttpServlet {

	private static final long serialVersionUID = 1850408837189911645L;

	@Inject
	private ISliderService sliderService;

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String action = req.getParameter("action");
//		if (action != null && (action.equals("insert") || action.equals("edit"))) {
//			sliderService slider = FormUtil.toModel(sliderService.class, req);
//			if (slider.getId() != null) {
//				slider = sliderService.findOne(slider.getId());
//			}
//			MessageUtil.showMessage(req);
//			req.setAttribute("slider", slider);
//			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/slider/addOrEdit.jsp");
//			rd.forward(req, resp);
//		} else {
//			sliderService slider = FormUtil.toModel(sliderService.class, req);
//			slider.setListResult(sliderService.findAll());
//			Pageble pageble = new PageRequest(slider.getPage(), slider.getMaxPageItem(),
//					new Sorter(slider.getSortName(), slider.getSortBy()));
//			slider.setListResult(sliderService.findAllPage(pageble));
//			slider.setTotalItem(sliderService.totalItemInTable());
//			if (slider.getTotalItem() % slider.getMaxPageItem() != 0) {
//				slider.setTotalPage(((int) Math.ceil((double) (slider.getTotalItem() / slider.getMaxPageItem()))) + 1);
//			} else {
//				slider.setTotalPage((int) Math.ceil((double) (slider.getTotalItem() / slider.getMaxPageItem())));
//			}
//			MessageUtil.showMessage(req);
//			req.setAttribute(SystemConstant.MODEL, slider);
//			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/slider/list.jsp");
//			rd.forward(req, resp);
//		}
//
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		String action = req.getParameter("action");
		if (action != null && action.equals("insert")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/slider/add.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("edit")) {
			SliderModel slider = FormUtil.toModel(SliderModel.class, req);
			slider = sliderService.findOne(slider.getId());
			String uploadPath = req.getServletContext().getRealPath("/uploads/admin/producss");
			req.setAttribute(SystemConstant.MODEL, slider);
			req.setAttribute("uploadPath", uploadPath);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/slider/edit.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("delete")) {
			SliderModel slider = FormUtil.toModel(SliderModel.class, req);
			sliderService.deleteById(slider.getId());
			resp.sendRedirect(req.getContextPath() + "/admin-slider");
		} else {
			SliderModel slider = FormUtil.toModel(SliderModel.class, req);
			slider.setListResult(sliderService.findAll());
			Pageble pageble = new PageRequest(slider.getPage(), slider.getMaxPageItem(),
					new Sorter(slider.getSortName(), slider.getSortBy()));
			slider.setListResult(sliderService.findAllPage(pageble));
			slider.setTotalItem(sliderService.totalItemInTable());
			if (slider.getTotalItem() % slider.getMaxPageItem() != 0) {
				slider.setTotalPage(((int) Math.ceil((double) (slider.getTotalItem() / slider.getMaxPageItem()))) + 1);
			} else {
				slider.setTotalPage((int) Math.ceil((double) (slider.getTotalItem() / slider.getMaxPageItem())));
			}
			req.setAttribute(SystemConstant.MODEL, slider);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/slider/list.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SecurityException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		SliderModel slider = FormUtil.toModel(SliderModel.class, req);
		String action = req.getParameter("action");
		
		String uploadPath = "D:/dowload/app to learn to code/java/workspace_all/javaweb-16-09-2023/javaweb/src/main/webapp/uploads";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		Part part = req.getPart("imagePath");
		String fileName = getFileName(part);
		part.write(uploadPath + File.separator + fileName);

		if (action != null && action.equals("insert")) {
			
			boolean checkName = sliderService.checkName(slider.getName());
			req.setAttribute("checkName", checkName);
			if (checkName) {
				slider.setImage(fileName);
				slider.setCreatedBy("khadz");
				req.setAttribute("slider", slider);
				sliderService.save(slider);
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/slider/add.jsp");
				rd.forward(req, resp);

			} else {
				req.setAttribute("slider", slider);
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/slider/add.jsp");
				rd.forward(req, resp);
			}
		} else if (action != null && action.equals("edit")) {
			Boolean check = false;
			if (sliderService.checkName(slider.getName())
					|| slider.getName().equals(sliderService.findOne(slider.getId()).getName())) {
				check = true;
				slider.setImage(fileName);
				slider.setModifiedBy("khadzzz");
				sliderService.update(slider);
			}
			req.setAttribute(SystemConstant.MODEL, sliderService.findOne(slider.getId()));
			req.setAttribute("check", check);
			req.setAttribute("slider", slider);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/slider/edit.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/slider/list.jsp");
			rd.forward(req, resp);
		}

	}

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return "not file";
	}
}
