package javaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.constant.SystemConstant;
import javaweb.model.UserModel;
import javaweb.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse sevletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) sevletResponse;
		String url = req.getRequestURI();
		if(url.startsWith("/admin")) {
			UserModel model = (UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
			if(model!=null) {
				if(model.getRole().equals(SystemConstant.ADMIN)) {
					filterChain.doFilter(servletRequest, sevletResponse);
				}else if(model.getRole().equals(SystemConstant.USER)){
					resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_permission&alert=danger");
				}
			}else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
			}
		}else {
			filterChain.doFilter(servletRequest, sevletResponse);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
