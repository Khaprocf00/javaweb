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
import javaweb.model.ProductModel;
import javaweb.paging.PageRequest;
import javaweb.paging.Pageble;
import javaweb.service.IBrandService;
import javaweb.service.ICategoryService;
import javaweb.service.IProductService;
import javaweb.service.ISliderService;
import javaweb.service.ITagService;
import javaweb.sort.Sorter;
import javaweb.utils.FormUtil;
@MultipartConfig
@WebServlet(urlPatterns = {"/admin-product"})
public class ProductController extends HttpServlet{

	private static final long serialVersionUID = -4710698058396426557L;
	@Inject
	private IProductService productService; 
	
	@Inject
	private ICategoryService categoryService; 
	
	@Inject
	private ITagService tagService; 
	
	@Inject
	private IBrandService brandService; 
	
	@Inject
	private ISliderService SliderService; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("insert")) {
			req.setAttribute("category", categoryService.findAll());
			req.setAttribute("tag", tagService.findAll());
			req.setAttribute("brand", brandService.findAll());
			req.setAttribute("slider", SliderService.findAll());
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/add.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("edit")) {
			ProductModel product = FormUtil.toModel(ProductModel.class, req);
			product = productService.findById(product.getId());
			req.setAttribute("category", categoryService.findAll());
			req.setAttribute("tag", tagService.findAll());
			req.setAttribute("brand", brandService.findAll());
			req.setAttribute("slider", SliderService.findAll());
			req.setAttribute("product", product);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/edit.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("delete")) {
			ProductModel product = FormUtil.toModel(ProductModel.class, req);
			productService.deleteById(product.getId());
			resp.sendRedirect(req.getContextPath() + "/admin-product");
		} else {
			ProductModel product = FormUtil.toModel(ProductModel.class, req);
			product.setListResult(productService.findAll());
			Pageble pageble = new PageRequest(product.getPage(), product.getMaxPageItem(),
					new Sorter(product.getSortName(), product.getSortBy()));
			product.setListResult(productService.findAllPage(pageble));
			product.setTotalItem(productService.totalItemInTable());
			if (product.getTotalItem() % product.getMaxPageItem() != 0) {
				product.setTotalPage(
						((int) Math.ceil((double) (product.getTotalItem() / product.getMaxPageItem()))) + 1);
			} else {
				product.setTotalPage((int) Math.ceil((double) (product.getTotalItem() / product.getMaxPageItem())));
			}
			req.setAttribute(SystemConstant.MODEL, product);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/list.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String uploadPath = "D:/dowload/app to learn to code/java/workspace_all/javaweb-16-09-2023/javaweb/src/main/webapp/uploads/product";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		Part part = req.getPart("imagePath");
		String fileName = getFileName(part);
		if(fileName != "") {
			part.write(uploadPath + File.separator + fileName);
		}
		ProductModel product = FormUtil.toModel(ProductModel.class, req);
		String action = req.getParameter("action");
		if (action != null && action.equals("insert")) {
			Long id = 0L ;
			req.setAttribute("category", categoryService.findAll());
			req.setAttribute("tag", tagService.findAll());
			req.setAttribute("brand", brandService.findAll());
			req.setAttribute("slider", SliderService.findAll());
			boolean checkName = productService.checkName(product.getName());
			product.setImagePath(fileName);
			req.setAttribute("checkName", checkName);
			if (checkName) {
				id = productService.insert(product);
				product = productService.findById(id);
			} 
			req.setAttribute("product", product);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/add.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("edit")) {
			if(fileName == "") {
				fileName = productService.findById(product.getId()).getImagePath();
			}
			Boolean check = false;
			if (productService.checkName(product.getName())
					|| product.getName().equals(productService.findById(product.getId()).getName())) {
				check = true;
				product.setImagePath(fileName);
				productService.update(product);
			}
			req.setAttribute("category", categoryService.findAll());
			req.setAttribute("tag", tagService.findAll());
			req.setAttribute("brand", brandService.findAll());
			req.setAttribute("slider", SliderService.findAll());
			req.setAttribute(SystemConstant.MODEL, productService.findById(product.getId()));
			req.setAttribute("checkName", check);
			req.setAttribute("product", product);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/edit.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/list.jsp");
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
