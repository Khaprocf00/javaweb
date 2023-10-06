package javaweb.controller.admin.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fasterxml.jackson.databind.ObjectMapper;

import javaweb.model.SliderModel;
import javaweb.service.ISliderService;
import javaweb.utils.HttpUtil;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/api-admin-slider" })
public class SliderAPI extends HttpServlet {
	private static final long serialVersionUID = -4021311489455970049L;

	@Inject
	private ISliderService sliderService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		SliderModel slider = HttpUtil.of(req.getReader()).toModel(SliderModel.class);
		slider.setCreatedBy("kha");
		slider = sliderService.save(slider);
		Part part = req.getPart("image");
		String realPath = req.getServletContext().getRealPath("/uploads").toString();
		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		if(!Files.exists(Paths.get(realPath))) {
			Files.createDirectory(Paths.get(realPath));
		}
		part.write(realPath + "/" + fileName);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		SliderModel slider = HttpUtil.of(req.getReader()).toModel(SliderModel.class);
		slider.setModifiedBy("kha");
		slider = sliderService.update(slider);
		mapper.writeValue(resp.getOutputStream(), slider);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		SliderModel slider = HttpUtil.of(req.getReader()).toModel(SliderModel.class);
		sliderService.delete(slider.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

}
