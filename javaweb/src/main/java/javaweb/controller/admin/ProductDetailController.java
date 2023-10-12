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
import javaweb.model.ProductDetailModel;
import javaweb.paging.PageRequest;
import javaweb.paging.Pageble;
import javaweb.service.IColorService;
import javaweb.service.IProductDetailService;
import javaweb.service.IProductService;
import javaweb.service.ISizeService;
import javaweb.sort.Sorter;
import javaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-product-detail" })
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 2578818473883477395L;

	@Inject
	private IProductDetailService productDetailService;
	
	@Inject
	private ISizeService sizeService;
	
	@Inject
	private IColorService colorService;
	
	@Inject
	private IProductService productService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		ProductDetailModel productDetail = FormUtil.toModel(ProductDetailModel.class, req);
		if (action != null && action.equals("insert")) {
			if (productDetail.getProductId() != null) {
				req.setAttribute("productId", productDetail.getProductId());
			}
			req.setAttribute("product", productService.findAll());
			req.setAttribute("color", colorService.findAll());
			req.setAttribute("size", sizeService.findAll());
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/productDetail/add.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("edit")) {
			productDetail = productDetailService.findById(productDetail.getId());
			req.setAttribute("product", productService.findAll());
			req.setAttribute("color", colorService.findAll());
			req.setAttribute("size", sizeService.findAll());
			req.setAttribute("productDetail", productDetail);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/productDetail/edit.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("delete")) {
			Long productId = productDetailService.findById(productDetail.getId()).getProductId();
			productDetailService.deleteById(productDetail.getId());
			int sumQty = productDetailService.sumQtyProduct(productId);
			productDetailService.updateQtyProduct(productId, sumQty);
			resp.sendRedirect(req.getContextPath() + "/admin-product-detail");
			
		} else {
			Pageble pageble = new PageRequest(productDetail.getPage(), productDetail.getMaxPageItem(),
					new Sorter(productDetail.getSortName(), productDetail.getSortBy()));
			if (productDetail.getProductId() != null) {
				productDetail.setListResult(productDetailService.findAllById(productDetail.getProductId()));
				productDetail.setListResult(productDetailService.findAllPageById(pageble, productDetail.getProductId()));
				productDetail.setTotalItem(productDetailService.totalItemInTableById(productDetail.getProductId()));
				req.setAttribute("productId", productDetail.getProductId());
			} else {
				productDetail.setListResult(productDetailService.findAll());
				productDetail.setListResult(productDetailService.findAllPage(pageble));
				productDetail.setTotalItem(productDetailService.totalItemInTable());
			}
			if (productDetail.getTotalItem() % productDetail.getMaxPageItem() != 0) {
				productDetail.setTotalPage(
						((int) Math.ceil((double) (productDetail.getTotalItem() / productDetail.getMaxPageItem())))
								+ 1);
			} else {
				productDetail.setTotalPage(
						(int) Math.ceil((double) (productDetail.getTotalItem() / productDetail.getMaxPageItem())));
			}
			req.setAttribute(SystemConstant.MODEL, productDetail);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/productDetail/list.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		String action = req.getParameter("action");
		ProductDetailModel productDetail = FormUtil.toModel(ProductDetailModel.class, req);
		if (action != null && action.equals("insert")) {
			Long id = 0L;
			int sumqty = productDetailService.sumQtyProduct(productDetail.getProductId());
			productDetailService.updateQtyProduct(productDetail.getProductId(), sumqty);
			boolean check = productDetailService.check(productDetail);
			req.setAttribute("checkName", check);
			if (check) {
				id = productDetailService.insert(productDetail);
				productDetail = productDetailService.findById(id);
				int sumQty = productDetailService.sumQtyProduct(productDetail.getProductId());
				productDetailService.updateQtyProduct(productDetail.getProductId(), sumQty);
			}
			req.setAttribute("product", productService.findAll());
			req.setAttribute("color", colorService.findAll());
			req.setAttribute("size", sizeService.findAll());
			req.setAttribute("productDetail", productDetail);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/productDetail/add.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("edit")) {
			Boolean check = false;
			ProductDetailModel productCheck = productDetailService.findById(productDetail.getId());
			if (productDetailService.check(productDetail)
					|| (productDetail.getProductId() == productCheck.getProductId())
							&& productDetail.getColorId() == productCheck.getColorId()
							&& productDetail.getSizeId() == productCheck.getSizeId()) {
				check = true;
				productDetailService.update(productDetail);
				int sumQty = productDetailService.sumQtyProduct(productDetail.getProductId());
				productDetailService.updateQtyProduct(productDetail.getProductId(), sumQty);
			}
			req.setAttribute("product", productService.findAll());
			req.setAttribute("color", colorService.findAll());
			req.setAttribute("size", sizeService.findAll());
			req.setAttribute("productDetail", productDetailService.findById(productDetail.getId()));
			req.setAttribute("checkName", check);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/productDetail/edit.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/productDetail/list.jsp");
			rd.forward(req, resp);
		}
	}
}
